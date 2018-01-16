package org.rendra.driver.consumer;

import dagger.internal.Factory;
import io.vertx.core.eventbus.EventBus;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mongodb.morphia.Datastore;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DriverConsumer_Factory implements Factory<DriverConsumer> {
  private final Provider<EventBus> eventBusProvider;

  private final Provider<Datastore> datastoreProvider;

  public DriverConsumer_Factory(
      Provider<EventBus> eventBusProvider, Provider<Datastore> datastoreProvider) {
    this.eventBusProvider = eventBusProvider;
    this.datastoreProvider = datastoreProvider;
  }

  @Override
  public DriverConsumer get() {
    return new DriverConsumer(eventBusProvider.get(), datastoreProvider.get());
  }

  public static Factory<DriverConsumer> create(
      Provider<EventBus> eventBusProvider, Provider<Datastore> datastoreProvider) {
    return new DriverConsumer_Factory(eventBusProvider, datastoreProvider);
  }
}
