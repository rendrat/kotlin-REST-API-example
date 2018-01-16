package org.rendra.driver.verticle;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lorg/rendra/driver/verticle/WorkerVerticle;", "Lio/vertx/core/AbstractVerticle;", "driverConsumer", "Lorg/rendra/driver/consumer/DriverConsumer;", "(Lorg/rendra/driver/consumer/DriverConsumer;)V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "start", "", "startFuture", "Lio/vertx/core/Future;", "Ljava/lang/Void;", "kotlinAPI-drivers"})
@javax.inject.Singleton()
public final class WorkerVerticle extends io.vertx.core.AbstractVerticle {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger log = null;
    private final org.rendra.driver.consumer.DriverConsumer driverConsumer = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.slf4j.Logger getLog() {
        return null;
    }
    
    @java.lang.Override()
    public void start(@org.jetbrains.annotations.NotNull()
    io.vertx.core.Future<java.lang.Void> startFuture) {
    }
    
    @javax.inject.Inject()
    public WorkerVerticle(@org.jetbrains.annotations.NotNull()
    org.rendra.driver.consumer.DriverConsumer driverConsumer) {
        super();
    }
}