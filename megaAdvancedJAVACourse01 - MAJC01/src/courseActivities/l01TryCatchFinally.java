package courseActivities;

// "Helicopter" class
// M.R.A. = Main Rotor Assembly
public class l01TryCatchFinally {

    public static void main(String[] args) {
        System.out.println("Scanning the choppers....");
        l01TryCatchFinally[] choppersArea = new l01TryCatchFinally[15];

        int chopperSelectionIndex = 28;
        
        // Exceptions treatment using "Try | Catch | Finally"
        try{
            System.out.println(choppersArea[chopperSelectionIndex]);
        // In case of selection index > array size, "catch" will be executed
        }catch(ArrayIndexOutOfBoundsException outOfBoundsError){
            System.out.println("Error B-02! This chopper ID doesnt exist! Please, insert a registered ID.");
        }finally{
            System.out.println("This command belongs to 'finally' block");
        }
    }
}
