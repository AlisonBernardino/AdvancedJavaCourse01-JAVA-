package courseActivities;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

// "Human" class
public class l02JPasswordField {
    public static void main(String[] args) {
        JFrame humanFrame = new JFrame("Human frame");
        humanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        humanFrame.setSize(430,330);
        humanFrame.setLayout(null);
        
        JPasswordField humanPasswordField = new JPasswordField();
        humanPasswordField.setBounds(15,115,335,35);
        
        humanFrame.add(humanPasswordField);
        humanFrame.setVisible(true);
    }
}
