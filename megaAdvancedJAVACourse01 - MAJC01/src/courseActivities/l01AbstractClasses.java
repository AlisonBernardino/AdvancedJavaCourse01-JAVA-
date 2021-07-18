package courseActivities;

// "Boat" class
abstract class l01AbstractClasses {
    String boatModel;
    float boatMaxSpeed;
    int boatExhausts;

    public class powerBoat extends l01AbstractClasses {
        float boatWeight;
        boolean isBoatRefuelled;
    }

    public class speedBoat extends l01AbstractClasses {
        int boatSeats;
        float boatExtraFueltankCapacity;
    }
}
