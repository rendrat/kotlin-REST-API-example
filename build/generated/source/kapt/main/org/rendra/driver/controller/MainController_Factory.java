package org.rendra.driver.controller;

import dagger.internal.Factory;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mongodb.morphia.Datastore;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainController_Factory implements Factory<MainController> {
  private final Provider<Router> routerProvider;

  private final Provider<Datastore> datastoreProvider;

  private final Provider<EventBus> eventBusProvider;

  public MainController_Factory(
      Provider<Router> routerProvider,
      Provider<Datastore> datastoreProvider,
      Provider<EventBus> eventBusProvider) {
    this.routerProvider = routerProvider;
    this.datastoreProvider = datastoreProvider;
    this.eventBusProvider = eventBusProvider;
  }

  @Override
  public MainController get() {
    return new MainController(
        routerProvider.get(), datastoreProvider.get(), eventBusProvider.get());
  }

  public static Factory<MainController> create(
      Provider<Router> routerProvider,
      Provider<Datastore> datastoreProvider,
      Provider<EventBus> eventBusProvider) {
    return new MainController_Factory(routerProvider, datastoreProvider, eventBusProvider);
  }
}
