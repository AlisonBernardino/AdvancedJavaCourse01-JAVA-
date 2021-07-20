package courseActivities;
// JFrame and JLabel classes imported
import javax.swing.JFrame;
import javax.swing.JLabel;

// "Motorbike" class
public class l02JLabel {
    public static void main(String[] args){
        JFrame motorbikeFrame = new JFrame("Motorbike label frame");
        motorbikeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        motorbikeFrame.setSize(480,380);
        motorbikeFrame.setLayout(null);
        
        JLabel motorbikeLabel = new JLabel("This is your motorbike system",JLabel.CENTER);
        motorbikeLabel.setBounds(25,140,375,50);
        motorbikeFrame.add(motorbikeLabel);
        motorbikeFrame.setVisible(true);
    }
}
