package org.rendra.driver.controller;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lorg/rendra/driver/controller/MainController;", "Lid/yoframework/web/controller/Controller;", "router", "Lio/vertx/ext/web/Router;", "datastore", "Lorg/mongodb/morphia/Datastore;", "eventBus", "Lio/vertx/core/eventbus/EventBus;", "(Lio/vertx/ext/web/Router;Lorg/mongodb/morphia/Datastore;Lio/vertx/core/eventbus/EventBus;)V", "getDatastore", "()Lorg/mongodb/morphia/Datastore;", "getEventBus", "()Lio/vertx/core/eventbus/EventBus;", "getRouter", "()Lio/vertx/ext/web/Router;", "kotlinAPI-drivers"})
@javax.inject.Singleton()
public final class MainController extends id.yoframework.web.controller.Controller {
    @org.jetbrains.annotations.NotNull()
    private final io.vertx.ext.web.Router router = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mongodb.morphia.Datastore datastore = null;
    @org.jetbrains.annotations.NotNull()
    private final io.vertx.core.eventbus.EventBus eventBus = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vertx.ext.web.Router getRouter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mongodb.morphia.Datastore getDatastore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.vertx.core.eventbus.EventBus getEventBus() {
        return null;
    }
    
    @javax.inject.Inject()
    public MainController(@org.jetbrains.annotations.NotNull()
    io.vertx.ext.web.Router router, @org.jetbrains.annotations.NotNull()
    org.mongodb.morphia.Datastore datastore, @org.jetbrains.annotations.NotNull()
    io.vertx.core.eventbus.EventBus eventBus) {
        super(null);
    }
}