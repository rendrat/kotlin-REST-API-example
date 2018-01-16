package org.rendra.driver.model;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BK\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u000b\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fB\u0005\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006+"}, d2 = {"Lorg/rendra/driver/model/Location;", "", "id", "Lorg/bson/types/ObjectId;", "driverId", "", "areaCode", "", "latitude", "", "Lorg/rendra/driver/type/Degree;", "longitude", "accuracy", "lastUpdated", "Ljava/time/LocalDateTime;", "(Lorg/bson/types/ObjectId;ILjava/lang/String;DDDLjava/time/LocalDateTime;)V", "()V", "getAccuracy", "()D", "setAccuracy", "(D)V", "getAreaCode", "()Ljava/lang/String;", "setAreaCode", "(Ljava/lang/String;)V", "getDriverId", "()I", "setDriverId", "(I)V", "getId", "()Lorg/bson/types/ObjectId;", "setId", "(Lorg/bson/types/ObjectId;)V", "getLastUpdated", "()Ljava/time/LocalDateTime;", "setLastUpdated", "(Ljava/time/LocalDateTime;)V", "point", "Lorg/rendra/driver/model/Point;", "getPoint", "()Lorg/rendra/driver/model/Point;", "setPoint", "(Lorg/rendra/driver/model/Point;)V", "kotlinAPI-drivers"})
@org.mongodb.morphia.annotations.Indexes(value = {@org.mongodb.morphia.annotations.Index(options = @org.mongodb.morphia.annotations.IndexOptions(unique = true), value = "driver_id_idx", fields = {@org.mongodb.morphia.annotations.Field(value = "driverId")})})
@org.mongodb.morphia.annotations.Entity(value = "location")
public final class Location {
    @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.databind.ser.std.ToStringSerializer.class)
    @org.mongodb.morphia.annotations.Id()
    private org.bson.types.ObjectId id;
    private int driverId;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String areaCode;
    @org.jetbrains.annotations.NotNull()
    @org.mongodb.morphia.annotations.Indexed(value = org.mongodb.morphia.utils.IndexDirection.GEO2DSPHERE)
    public org.rendra.driver.model.Point point;
    private double accuracy;
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.databind.ser.std.ToStringSerializer.class)
    public java.time.LocalDateTime lastUpdated;
    
    @org.jetbrains.annotations.Nullable()
    public final org.bson.types.ObjectId getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    org.bson.types.ObjectId p0) {
    }
    
    public final int getDriverId() {
        return 0;
    }
    
    public final void setDriverId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAreaCode() {
        return null;
    }
    
    public final void setAreaCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.rendra.driver.model.Point getPoint() {
        return null;
    }
    
    public final void setPoint(@org.jetbrains.annotations.NotNull()
    org.rendra.driver.model.Point p0) {
    }
    
    public final double getAccuracy() {
        return 0.0;
    }
    
    public final void setAccuracy(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getLastUpdated() {
        return null;
    }
    
    public final void setLastUpdated(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
    
    public Location() {
        super();
    }
    
    public Location(@org.jetbrains.annotations.Nullable()
    org.bson.types.ObjectId id, int driverId, @org.jetbrains.annotations.NotNull()
    java.lang.String areaCode, double latitude, double longitude, double accuracy, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime lastUpdated) {
        super();
    }
}