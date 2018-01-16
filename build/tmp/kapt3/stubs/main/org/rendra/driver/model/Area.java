package org.rendra.driver.model;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\t\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u00a2\u0006\u0002\u0010\u000bB\u0005\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060\u0006j\u0002`\u00072\n\u0010 \u001a\u00060\u0006j\u0002`\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\u00060\u0006j\u0002`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u00060\u0006j\u0002`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\t\u001a\u00060\u0006j\u0002`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006!"}, d2 = {"Lorg/rendra/driver/model/Area;", "", "code", "", "name", "minLatitude", "", "Lorg/rendra/driver/type/Degree;", "maxLatitude", "minLongitude", "maxLongitude", "(Ljava/lang/String;Ljava/lang/String;DDDD)V", "()V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getMaxLatitude", "()D", "setMaxLatitude", "(D)V", "getMaxLongitude", "setMaxLongitude", "getMinLatitude", "setMinLatitude", "getMinLongitude", "setMinLongitude", "getName", "setName", "isInside", "", "latitude", "longitude", "kotlinAPI-drivers"})
@org.mongodb.morphia.annotations.Entity(value = "area")
public final class Area {
    @org.jetbrains.annotations.NotNull()
    @org.mongodb.morphia.annotations.Id()
    public java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String name;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double getMinLatitude() {
        return 0.0;
    }
    
    public final void setMinLatitude(double p0) {
    }
    
    public final double getMaxLatitude() {
        return 0.0;
    }
    
    public final void setMaxLatitude(double p0) {
    }
    
    public final double getMinLongitude() {
        return 0.0;
    }
    
    public final void setMinLongitude(double p0) {
    }
    
    public final double getMaxLongitude() {
        return 0.0;
    }
    
    public final void setMaxLongitude(double p0) {
    }
    
    public final boolean isInside(double latitude, double longitude) {
        return false;
    }
    
    public Area() {
        super();
    }
    
    public Area(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        super();
    }
}