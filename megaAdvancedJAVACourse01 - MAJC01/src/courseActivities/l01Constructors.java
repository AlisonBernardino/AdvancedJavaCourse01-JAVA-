package courseActivities;

// "Bicycle" class
public class l01Constructors {
    private String bicycleMark;
    private String bicycleModel;
    private float bicycleWeight;
    private float bicycleKilometersTraveled;
    private boolean isBicycleMaintained;
    private boolean isBicycleWashed;
    
    public l01Constructors(String itemMark, String itemModel, float itemWeight, float itemKilometersTraveled, boolean isItemMaintained, boolean isItemWashed){
        this.bicycleMark = itemMark;
        this.bicycleModel = itemModel;
        this.bicycleWeight = itemWeight;
        this.bicycleKilometersTraveled = itemKilometersTraveled;
        this.isBicycleMaintained = isItemMaintained;
        this.isBicycleWashed = isItemWashed;
    }
}
