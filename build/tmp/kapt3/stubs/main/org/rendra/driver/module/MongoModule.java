package org.rendra.driver.module;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/rendra/driver/module/MongoModule;", "", "()V", "log", "Lorg/slf4j/Logger;", "datastore", "Lorg/mongodb/morphia/Datastore;", "client", "Lcom/mongodb/MongoClient;", "databaseName", "", "provideInitializer", "Lkotlin/Function0;", "", "Lorg/rendra/driver/type/UnitCallable;", "kotlinAPI-drivers"})
@dagger.Module(includes = {id.yoframework.morphia.module.MorphiaModule.class})
public final class MongoModule {
    private final org.slf4j.Logger log = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final org.mongodb.morphia.Datastore datastore(@org.jetbrains.annotations.NotNull()
    com.mongodb.MongoClient client, @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "morphiaDatabaseName")
    java.lang.String databaseName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "dataInitializer")
    @javax.inject.Singleton()
    @dagger.Provides()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> provideInitializer(@org.jetbrains.annotations.NotNull()
    org.mongodb.morphia.Datastore datastore) {
        return null;
    }
    
    public MongoModule() {
        super();
    }
}