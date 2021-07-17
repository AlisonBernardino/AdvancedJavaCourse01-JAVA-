package courseActivities;

public class ENUMLightBulb {
    private int lightPositionIndex;
    private int lightRangeIndex;
    private float lightBulbHeight;
    private float lightEnergyUse;
    private boolean isLightBulbTurnedOn;
    private boolean isLightBulbNew;
    private ENUMLightBulbEnum lightBulbEnumerator;
    
    // Constructor - Model 01 - Empty constructor
    public ENUMLightBulb(){
        super();
    }
    
    // Constructor - Model 02 - Filled constructor
    public ENUMLightBulb(int objectPositionIndex, int objectRangeIndex, float objectHeight, float objectEnergyUse, boolean isObjectTurnedOn, boolean isObjectNew, ENUMLightBulbEnum objectEnumerator){
        super();
        this.lightPositionIndex = objectPositionIndex;
        this.lightRangeIndex = objectRangeIndex;
        this.lightBulbHeight = objectHeight;
        this.lightEnergyUse = objectEnergyUse;
        this.isLightBulbTurnedOn = isObjectTurnedOn;
        this.isLightBulbNew = isObjectNew;
        this.lightBulbEnumerator = objectEnumerator;
    }
    
    // Getters and setters
    public int getLightPositionIndex(){
        return lightPositionIndex;
    }
    
    public void setLightPositionIndex(int itemPositionIndex){
        this.lightPositionIndex = itemPositionIndex;
    }
    
    public int getLightRangeIndex(){
        return lightRangeIndex;
    }
    
    public void setLightRangeIndex(int itemRangeIndex){
        this.lightRangeIndex = itemRangeIndex;
    }
    
    public float getLightBulbHeight(){
        return lightBulbHeight;
    }
    
    public void setLightBulbHeight(float itemHeight){
        this.lightBulbHeight = itemHeight;
    }
    
    public float getLightEnergyUse(){
        return lightEnergyUse;
    }
    
    public void setLightEnergyUse(float itemEnergyUse){
        this.lightEnergyUse = itemEnergyUse;
    }
    
    public boolean getIsLightBulbTurnedOn(){
        return isLightBulbTurnedOn;
    }
    
    public void setIsLightBulbTurnedOn(boolean isItemTurnedOn){
        this.isLightBulbTurnedOn = isItemTurnedOn;
    }
    
    public boolean getIsLightBulbNew(){
        return isLightBulbNew;
    }
    
    public void setIsLightBulbNew(boolean isItemNew){
        this.isLightBulbNew = isItemNew;
    }
}
