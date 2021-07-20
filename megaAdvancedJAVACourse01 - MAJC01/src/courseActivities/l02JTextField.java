package courseActivities;
// Importing the respective classes
import javax.swing.JFrame;
import javax.swing.JTextField;

// "Soldier" class
public class l02JTextField {
    public static void main(String[] args){
        JFrame soldierFrame = new JFrame("Soldier frame");
        soldierFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        soldierFrame.setSize(440,340);
        soldierFrame.setLayout(null);
        
        JTextField soldierTextField = new JTextField();
        soldierTextField.setBounds(20,120,310,30);
        
        soldierFrame.add(soldierTextField);
        soldierFrame.setVisible(true);
    }
}
