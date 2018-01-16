package org.rendra.driver.module;

import com.mongodb.MongoClient;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.yoframework.core.module.CoreModule;
import id.yoframework.core.module.CoreModule_ProvideConfigFactory;
import id.yoframework.core.module.CoreModule_ProvideEventBusFactory;
import id.yoframework.core.module.CoreModule_ProvideVertxFactory;
import id.yoframework.morphia.module.MorphiaModule;
import id.yoframework.morphia.module.MorphiaModule_DatabaseNameFactory;
import id.yoframework.morphia.module.MorphiaModule_ProvideMorphiaClientFactory;
import id.yoframework.web.module.WebModule;
import id.yoframework.web.module.WebModule_ProvideRouterFactory;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import javax.annotation.Generated;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.mongodb.morphia.Datastore;
import org.rendra.driver.consumer.DriverConsumer;
import org.rendra.driver.consumer.DriverConsumer_Factory;
import org.rendra.driver.controller.MainController;
import org.rendra.driver.controller.MainController_Factory;
import org.rendra.driver.verticle.MainVerticle;
import org.rendra.driver.verticle.MainVerticle_Factory;
import org.rendra.driver.verticle.WorkerVerticle;
import org.rendra.driver.verticle.WorkerVerticle_Factory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<JsonObject> provideConfigProvider;

  private Provider<MongoClient> provideMorphiaClientProvider;

  private Provider<String> databaseNameProvider;

  private Provider<Datastore> datastoreProvider;

  private Provider<Vertx> provideVertxProvider;

  private Provider<Router> provideRouterProvider;

  private Provider<EventBus> provideEventBusProvider;

  private Provider<MainController> mainControllerProvider;

  private Provider<MainVerticle> mainVerticleProvider;

  private Provider<DriverConsumer> driverConsumerProvider;

  private Provider<WorkerVerticle> workerVerticleProvider;

  private Provider<Function0<Unit>> provideInitializerProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideConfigProvider =
        DoubleCheck.provider(CoreModule_ProvideConfigFactory.create(builder.coreModule));
    this.provideMorphiaClientProvider =
        DoubleCheck.provider(
            MorphiaModule_ProvideMorphiaClientFactory.create(
                builder.morphiaModule, provideConfigProvider));
    this.databaseNameProvider =
        DoubleCheck.provider(
            MorphiaModule_DatabaseNameFactory.create(builder.morphiaModule, provideConfigProvider));
    this.datastoreProvider =
        DoubleCheck.provider(
            MongoModule_DatastoreFactory.create(
                builder.mongoModule, provideMorphiaClientProvider, databaseNameProvider));
    this.provideVertxProvider =
        DoubleCheck.provider(CoreModule_ProvideVertxFactory.create(builder.coreModule));
    this.provideRouterProvider =
        WebModule_ProvideRouterFactory.create(builder.webModule, provideVertxProvider);
    this.provideEventBusProvider =
        DoubleCheck.provider(CoreModule_ProvideEventBusFactory.create(builder.coreModule));
    this.mainControllerProvider =
        DoubleCheck.provider(
            MainController_Factory.create(
                provideRouterProvider, datastoreProvider, provideEventBusProvider));
    this.mainVerticleProvider =
        DoubleCheck.provider(MainVerticle_Factory.create(mainControllerProvider));
    this.driverConsumerProvider =
        DoubleCheck.provider(
            DriverConsumer_Factory.create(provideEventBusProvider, datastoreProvider));
    this.workerVerticleProvider =
        DoubleCheck.provider(WorkerVerticle_Factory.create(driverConsumerProvider));
    this.provideInitializerProvider =
        DoubleCheck.provider(
            MongoModule_ProvideInitializerFactory.create(builder.mongoModule, datastoreProvider));
  }

  @Override
  public Datastore dataStore() {
    return datastoreProvider.get();
  }

  @Override
  public MainVerticle mainVerticle() {
    return mainVerticleProvider.get();
  }

  @Override
  public WorkerVerticle workerVerticle() {
    return workerVerticleProvider.get();
  }

  @Override
  public Function0<Unit> dataInitializer() {
    return provideInitializerProvider.get();
  }

  public static final class Builder {
    private CoreModule coreModule;

    private MorphiaModule morphiaModule;

    private MongoModule mongoModule;

    private WebModule webModule;

    private Builder() {}

    public AppComponent build() {
      if (coreModule == null) {
        throw new IllegalStateException(CoreModule.class.getCanonicalName() + " must be set");
      }
      if (morphiaModule == null) {
        this.morphiaModule = new MorphiaModule();
      }
      if (mongoModule == null) {
        this.mongoModule = new MongoModule();
      }
      if (webModule == null) {
        this.webModule = new WebModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder coreModule(CoreModule coreModule) {
      this.coreModule = Preconditions.checkNotNull(coreModule);
      return this;
    }

    public Builder webModule(WebModule webModule) {
      this.webModule = Preconditions.checkNotNull(webModule);
      return this;
    }

    public Builder mongoModule(MongoModule mongoModule) {
      this.mongoModule = Preconditions.checkNotNull(mongoModule);
      return this;
    }

    public Builder morphiaModule(MorphiaModule morphiaModule) {
      this.morphiaModule = Preconditions.checkNotNull(morphiaModule);
      return this;
    }
  }
}
