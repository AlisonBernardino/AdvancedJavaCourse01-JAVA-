package courseActivities;
import javax.swing.JFrame;
import javax.swing.JCheckBox;

// "House" class
public class l02JCheckBox {
    public static void main(String[] args){
        JFrame houseFrame = new JFrame("House frame");
        houseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        houseFrame.setSize(445,345);
        houseFrame.setLayout(null);
        
        JCheckBox houseCheckBox = new JCheckBox("House checkBox");
        houseCheckBox.setBounds(25,135,355,35);
        
        houseFrame.add(houseCheckBox);
        houseFrame.setVisible(true);
    }
}
