package org.rendra.driver.consumer;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010H\u0086\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lorg/rendra/driver/consumer/DriverConsumer;", "", "eventBus", "Lio/vertx/core/eventbus/EventBus;", "datastore", "Lorg/mongodb/morphia/Datastore;", "(Lio/vertx/core/eventbus/EventBus;Lorg/mongodb/morphia/Datastore;)V", "getDatastore", "()Lorg/mongodb/morphia/Datastore;", "getEventBus", "()Lio/vertx/core/eventbus/EventBus;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "invoke", "", "kotlinAPI-drivers"})
@javax.inject.Singleton()
public final class DriverConsumer {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger log = null;
    @org.jetbrains.annotations.NotNull()
    private final io.vertx.core.eventbus.EventBus eventBus = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mongodb.morphia.Datastore datastore = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.slf4j.Logger getLog() {
        return null;
    }
    
    public final void invoke() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.vertx.core.eventbus.EventBus getEventBus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mongodb.morphia.Datastore getDatastore() {
        return null;
    }
    
    @javax.inject.Inject()
    public DriverConsumer(@org.jetbrains.annotations.NotNull()
    io.vertx.core.eventbus.EventBus eventBus, @org.jetbrains.annotations.NotNull()
    org.mongodb.morphia.Datastore datastore) {
        super();
    }
}