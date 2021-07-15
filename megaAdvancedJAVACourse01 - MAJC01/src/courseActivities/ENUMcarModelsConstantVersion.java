package courseActivities;

public class ENUMcarModelsConstantVersion {
    // To declare constants, we use "final" classification
    // "public + static" discards the "carModelsConstantVersion"
    // instance need when using it on another class.
    // Instead, we use carModelsConstantVersion.CARMODEL01
    // to obtain the CARMODEL01 value.
    public static final String CARMODEL01 = "Pagani Huayra";
    public static final String CARMODEL02 = "Ferrari Maranello";
    public static final float CAR01GASOLINE = 100.0f;
    public static final float CAR02GASOLINE = 85.5f;
    public static final double CAR01WEIGHT = 255.0d;
    public static final double CAR02WEIGHT = 197.4d;
    public static final int CAR01DOORS = 2;
    public static final int CAR02DOORS = 2;
    public static final boolean ISCAR01READY = true;
    public static final boolean ISCAR02READY = false;
}
