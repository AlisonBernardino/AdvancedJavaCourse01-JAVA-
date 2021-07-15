package courseActivities;

public class ENUMOutputClass {
    public static void main(String[] args){
        outputUsingConstants();
        outputUsingEnumerators();
    }
    
    // Output using constants
    // "Static" is used to call this method inside "main" method
    // "Void" is used to demonstrate the "no return" status
    private static void carSpecsOutput(String vehicleModel){
        switch (vehicleModel){
            case "Pagani Huayra":
                System.out.println("Pagani Huayra");
            case "Ferrari Maranello":
                System.out.println("Ferrari Maranello");
//            default:
//                System.out.println("Error A-01! The car model wasnt identified!");
        }
    }
    
    // Method 01 - To print the created constants
    private static void outputUsingConstants(){
        String car01 = ENUMcarModelsConstantVersion.CARMODEL01;
        String car02 = ENUMcarModelsConstantVersion.CARMODEL02;
        
        System.out.println("Output - >> Constants << version");
        carSpecsOutput(car01);
        // OR =
        // carSpecsOutput(ENUMcarModelsConstantVersion.CARMODEL01);
        carSpecsOutput(car02);
        // OR =
        //carSpecsOutput(ENUMcarModelsConstantVersion.CARMODEL02);
    }
    
    // Output using enumerators
    private static void carSpecsOutputEnum(ENUMcarModelsEnumVersion carOutput){
        switch(carOutput){
            case autoType01:
                System.out.println("BMW 320i");
                System.out.println("The top seller vehicle!");
            case autoType02:
                System.out.println("Lamborghini Aventador");
                System.out.println("A master choice to accelerate!");
            //default:
            //    System.out.println("Error B-01: Vehicle unknown! Please, re-insert the vehicle model");
        }
    }
    
    // Method 02 - To print the created enum (Enumerator) 
    // Enum = BETTER technique
    private static void outputUsingEnumerators(){
        ENUMcarModelsEnumVersion vehicle001 = ENUMcarModelsEnumVersion.autoType01;
        ENUMcarModelsEnumVersion vehicle002 = ENUMcarModelsEnumVersion.autoType02;
        System.out.println("");
        System.out.println("Output - >> Enum << version");
        carSpecsOutputEnum(vehicle001);
        carSpecsOutputEnum(vehicle002);
    }
}
