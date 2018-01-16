package org.rendra.driver.module;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lorg/rendra/driver/module/AppComponent;", "", "dataInitializer", "Lkotlin/Function0;", "", "Lorg/rendra/driver/type/UnitCallable;", "dataStore", "Lorg/mongodb/morphia/Datastore;", "mainVerticle", "Lorg/rendra/driver/verticle/MainVerticle;", "workerVerticle", "Lorg/rendra/driver/verticle/WorkerVerticle;", "kotlinAPI-drivers"})
@dagger.Component(modules = {id.yoframework.core.module.CoreModule.class, id.yoframework.web.module.WebModule.class, org.rendra.driver.module.MongoModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.mongodb.morphia.Datastore dataStore();
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.rendra.driver.verticle.MainVerticle mainVerticle();
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.rendra.driver.verticle.WorkerVerticle workerVerticle();
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "dataInitializer")
    public abstract kotlin.jvm.functions.Function0<kotlin.Unit> dataInitializer();
}