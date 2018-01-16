package org.rendra.driver.verticle;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.rendra.driver.consumer.DriverConsumer;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WorkerVerticle_Factory implements Factory<WorkerVerticle> {
  private final Provider<DriverConsumer> driverConsumerProvider;

  public WorkerVerticle_Factory(Provider<DriverConsumer> driverConsumerProvider) {
    this.driverConsumerProvider = driverConsumerProvider;
  }

  @Override
  public WorkerVerticle get() {
    return new WorkerVerticle(driverConsumerProvider.get());
  }

  public static Factory<WorkerVerticle> create(Provider<DriverConsumer> driverConsumerProvider) {
    return new WorkerVerticle_Factory(driverConsumerProvider);
  }
}
