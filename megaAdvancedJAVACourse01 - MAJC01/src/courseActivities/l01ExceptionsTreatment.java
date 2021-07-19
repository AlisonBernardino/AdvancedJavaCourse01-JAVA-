package courseActivities;

// "Registered cars" system
public class l01ExceptionsTreatment {
    public static void main(String[] args){
        int carSearchIndex = 98;
        int maxSystemIndex = 65;
        
        l01ExceptionsTreatment[] newCars = new l01ExceptionsTreatment[maxSystemIndex];  
    
        if(carSearchIndex > 0 && carSearchIndex <= maxSystemIndex){
            System.out.println(newCars[carSearchIndex]);
        }else{
            System.out.println("Error A-03! The requested ID was not found! Please, re-insert the car ID to proceed.");
        }
    }
}
