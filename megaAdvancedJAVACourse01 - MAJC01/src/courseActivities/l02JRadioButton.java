package courseActivities;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

// "Hospital" class
public class l02JRadioButton {
    public static void main(String[] args){
        JFrame hospitalFrame = new JFrame("Hospital frame");
        hospitalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hospitalFrame.setSize(410,310);
        hospitalFrame.setLayout(null);
        
        JRadioButton hospitalRadioButton = new JRadioButton("Hospital radio button");
        hospitalRadioButton.setBounds(25,135,365,45);
        hospitalFrame.add(hospitalRadioButton);
        hospitalFrame.setVisible(true);
    }
}
