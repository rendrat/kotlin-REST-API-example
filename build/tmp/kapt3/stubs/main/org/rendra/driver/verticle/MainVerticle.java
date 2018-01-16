package org.rendra.driver.verticle;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lorg/rendra/driver/verticle/MainVerticle;", "Lio/vertx/kotlin/coroutines/CoroutineVerticle;", "mainController", "Lorg/rendra/driver/controller/MainController;", "(Lorg/rendra/driver/controller/MainController;)V", "log", "Lorg/slf4j/Logger;", "start", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinAPI-drivers"})
@javax.inject.Singleton()
public final class MainVerticle extends io.vertx.kotlin.coroutines.CoroutineVerticle {
    private final org.slf4j.Logger log = null;
    private final org.rendra.driver.controller.MainController mainController = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object start(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.experimental.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @javax.inject.Inject()
    public MainVerticle(@org.jetbrains.annotations.NotNull()
    org.rendra.driver.controller.MainController mainController) {
        super();
    }
}