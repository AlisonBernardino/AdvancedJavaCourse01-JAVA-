package courseActivities;

public enum ENUMfruitSales {
    banana(0.31f), apple(0.23f), pear(0.33f), grape(0.12f), kiwi(0.25f), strawberry(0.08f);
    
    private float fruitWeight;
    
    // Constructor
    ENUMfruitSales(float itemWeight){
        this.fruitWeight = itemWeight; 
    }
    
    public float getFruitWeight(){
        return this.fruitWeight;
    }
}
