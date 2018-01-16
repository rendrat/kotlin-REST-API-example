package org.rendra.driver.model;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B)\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0002\u0010\bB\u0005\u00a2\u0006\u0002\u0010\tR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lorg/rendra/driver/model/Point;", "", "type", "", "latitude", "", "Lorg/rendra/driver/type/Degree;", "longitude", "(Ljava/lang/String;DD)V", "()V", "coordinates", "", "getCoordinates", "()[Ljava/lang/Double;", "setCoordinates", "([Ljava/lang/Double;)V", "[Ljava/lang/Double;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "kotlinAPI-drivers"})
@org.mongodb.morphia.annotations.Embedded()
public final class Point {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    public java.lang.Double[] coordinates;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Double[] getCoordinates() {
        return null;
    }
    
    public final void setCoordinates(@org.jetbrains.annotations.NotNull()
    java.lang.Double[] p0) {
    }
    
    public Point() {
        super();
    }
    
    public Point(@org.jetbrains.annotations.NotNull()
    java.lang.String type, double latitude, double longitude) {
        super();
    }
}