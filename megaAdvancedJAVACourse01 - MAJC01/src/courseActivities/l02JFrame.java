package courseActivities;
import javax.swing.JFrame;

// "Drone" class
public class l02JFrame {
    public static void main(String[] args){
        JFrame droneFrame = new JFrame("Drone frame");
        droneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        droneFrame.setSize(450,350);
        droneFrame.setLayout(null);
        
        droneFrame.setVisible(true);
    }
}
