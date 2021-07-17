package courseActivities;

// Enum - Important points = 
// 01a - You can make comparison using "==";
// 01b - When we need to compare classes, we use "equals" method;
// 01c - Each Java object(instance) points to a memory address;
// 02 - Enums cant be instantiated using "new";
// 03 - A new enum extends the java.lang.Enum class;
// 04 - Enums can be declared inside a class or separatedly;
// 05 - It can implement an interface
 

public class ENUMfruitSalesOutputClass {

    public static void main(String[] args) {
        ENUMfruitSales fruit01 = ENUMfruitSales.banana;
        ENUMfruitSales fruit02 = ENUMfruitSales.apple;
        ENUMfruitSales fruit03 = ENUMfruitSales.pear;
        ENUMfruitSales fruit04 = ENUMfruitSales.grape;
        ENUMfruitSales fruit05 = ENUMfruitSales.kiwi;
        ENUMfruitSales fruit06 = ENUMfruitSales.strawberry;
        
        System.out.println("======= FRUIT SALE - v1.0 =======");
        System.out.println(fruit01.toString() + " - " + fruit01.getFruitWeight() + "kg.");
        System.out.println(fruit02.toString() + " - " + fruit02.getFruitWeight() + "kg.");
        System.out.println(fruit03.toString() + " - " + fruit03.getFruitWeight() + "kg.");
        System.out.println(fruit04.toString() + " - " + fruit04.getFruitWeight() + "kg.");
        System.out.println(fruit05.toString() + " - " + fruit05.getFruitWeight() + "kg.");
        System.out.println(fruit06.toString() + " - " + fruit06.getFruitWeight() + "kg.");
    
        // Using the lightBulb class and enumerator to make data output 
        ENUMLightBulb lightSystem01 = new ENUMLightBulb(1,3,2.3f,150.5f,true,true,ENUMLightBulbEnum.neonLights);
        System.out.println(lightSystem01.getIsLightBulbNew());
    }
}
