package org.rendra.driver.module;

import com.mongodb.MongoClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mongodb.morphia.Datastore;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MongoModule_DatastoreFactory implements Factory<Datastore> {
  private final MongoModule module;

  private final Provider<MongoClient> clientProvider;

  private final Provider<String> databaseNameProvider;

  public MongoModule_DatastoreFactory(
      MongoModule module,
      Provider<MongoClient> clientProvider,
      Provider<String> databaseNameProvider) {
    this.module = module;
    this.clientProvider = clientProvider;
    this.databaseNameProvider = databaseNameProvider;
  }

  @Override
  public Datastore get() {
    return Preconditions.checkNotNull(
        module.datastore(clientProvider.get(), databaseNameProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Datastore> create(
      MongoModule module,
      Provider<MongoClient> clientProvider,
      Provider<String> databaseNameProvider) {
    return new MongoModule_DatastoreFactory(module, clientProvider, databaseNameProvider);
  }
}
