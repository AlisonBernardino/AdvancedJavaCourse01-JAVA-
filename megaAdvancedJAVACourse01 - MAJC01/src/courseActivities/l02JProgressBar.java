package courseActivities;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

// "Battery" class
public class l02JProgressBar {
    public static void main(String[] args){
        JFrame batteryFrame = new JFrame("Battery frame");
        batteryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        batteryFrame.setSize(420,320);
        batteryFrame.setLayout(null);
        
        JProgressBar batteryBar = new JProgressBar(JProgressBar.HORIZONTAL, 2, 100);
        batteryBar.setValue(25);
        batteryBar.setBounds(15,125,355,10);
        
        batteryFrame.add(batteryBar);
        batteryFrame.setVisible(true);
    }
}
