package systemParts;

public class Occupation {
    int occupationID;
    String occupationName;
    String occcupationType;
    float occupationSalary;
    boolean isOccupationAvailable;

    public int getOccupationID() {
        return occupationID;
    }

    public void setOccupationID(int occupationID) {
        this.occupationID = occupationID;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public String getOcccupationType() {
        return occcupationType;
    }

    public void setOcccupationType(String occcupationType) {
        this.occcupationType = occcupationType;
    }

    public float getOccupationSalary() {
        return occupationSalary;
    }

    public void setOccupationSalary(float occupationSalary) {
        this.occupationSalary = occupationSalary;
    }
    
    public boolean isIsOccupationAvailable() {
        return isOccupationAvailable;
    }

    public void setIsOccupationAvailable(boolean isOccupationAvailable) {
        this.isOccupationAvailable = isOccupationAvailable;
    }
}
