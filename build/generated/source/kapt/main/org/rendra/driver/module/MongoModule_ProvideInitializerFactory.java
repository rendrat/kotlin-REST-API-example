package org.rendra.driver.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.mongodb.morphia.Datastore;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MongoModule_ProvideInitializerFactory implements Factory<Function0<Unit>> {
  private final MongoModule module;

  private final Provider<Datastore> datastoreProvider;

  public MongoModule_ProvideInitializerFactory(
      MongoModule module, Provider<Datastore> datastoreProvider) {
    this.module = module;
    this.datastoreProvider = datastoreProvider;
  }

  @Override
  public Function0<Unit> get() {
    return Preconditions.checkNotNull(
        module.provideInitializer(datastoreProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Function0<Unit>> create(
      MongoModule module, Provider<Datastore> datastoreProvider) {
    return new MongoModule_ProvideInitializerFactory(module, datastoreProvider);
  }
}
