package courseActivities;

// "Technology" class
public class l01Heritage {
    private String deviceName;
    private int deviceBatteries;
    private boolean isDeviceTurnedOn;
    
    public String getDeviceName(){
        return this.deviceName;
    }
    
    public void setDeviceName(String itemName){
        this.deviceName = itemName;
    }
    
    public int getDeviceBatteries(){
        return this.deviceBatteries;
    }
    
    public void setDeviceBatteries(int itemBatteries){
        this.deviceBatteries = itemBatteries;
    }
    
    public boolean getIsDeviceTurnedOn(){
        return this.isDeviceTurnedOn;
    }
    
    public void setIsDeviceTurnedOn(boolean isItemTurnedOn){
        this.isDeviceTurnedOn = isItemTurnedOn;
    }
    
    public void deviceMessage(){
        System.out.println("The device is ready to be used!");
    }
    
    // "Smartphone" class extends "Technology (l01Heritage)" class
    public class Smartphone extends l01Heritage{
        public void Smartphone(){
            this.setDeviceName("Alison's personal phone");
        }
        
        // Method to print the device message
        @Override
        public void deviceMessage(){
            System.out.println("Hi, Alison! Your phone status = All set!");
        }
    }
    
    // "Tablet" class - "Technology" class heritage
    public class Tablet extends l01Heritage {
        public void Tablet(){
            this.setDeviceName("Alison's personal tablet!");
        }
        
        @Override
        public void deviceMessage(){
            System.out.println("Welcome, Alison! Tablet status = Loading system...");
        }
    }    
    
    // "Notebook" class inherited from "Technology" class
    public class Notebook extends l01Heritage{
        public void Notebook(){
            this.setDeviceBatteries(2);
        }
        
        @Override
        public void deviceMessage(){
            System.out.println("Alison's personal notebook = 02 batteries available for use.");
        }
    }
    
    // "desktopPC" class - "Technology" class heritage
    public class desktopPC extends l01Heritage{
        public void desktopPC(){
            this.setIsDeviceTurnedOn(true);
        }
        
        @Override
        public void deviceMessage(){
            System.out.println("Desktop PC status = Turned ON!");
        }
    }
    public static void main(String[] args){
        System.out.println("Personal device messages");
        
        l01Heritage alisonsSmartphone = new l01Heritage();
        System.out.println("Starting smartphone system...");
        alisonsSmartphone.deviceMessage();
        
        l01Heritage alisonsTablet = new l01Heritage();
        System.out.println("Starting tablet operational system...");
        alisonsTablet.deviceMessage();
        
        l01Heritage alisonsNotebook = new l01Heritage();
        System.out.println("Starting notebook system...");
        alisonsNotebook.deviceMessage();
        
        l01Heritage alisonsDesktopComputer = new l01Heritage();
        System.out.println("Starting desktop PC operational system...");
        alisonsDesktopComputer.deviceMessage();
    }
}
