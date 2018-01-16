package org.rendra.driver.verticle;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.rendra.driver.controller.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainVerticle_Factory implements Factory<MainVerticle> {
  private final Provider<MainController> mainControllerProvider;

  public MainVerticle_Factory(Provider<MainController> mainControllerProvider) {
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public MainVerticle get() {
    return new MainVerticle(mainControllerProvider.get());
  }

  public static Factory<MainVerticle> create(Provider<MainController> mainControllerProvider) {
    return new MainVerticle_Factory(mainControllerProvider);
  }
}
