package courseActivities;
import javax.swing.JFrame;
import javax.swing.JComboBox;

// "Dog" class
public class l02JComboBox {
    public static void main(String[] args){
        JFrame dogFrame = new JFrame("Dog frame");
        dogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dogFrame.setSize(425,325);
        dogFrame.setLayout(null);
        
        String[] dogs = {"Theodoro","Chance","Shadow"};
        JComboBox dogsComboBox = new JComboBox(dogs);
        
        dogsComboBox.setBounds(30,140,370,50);
        dogFrame.add(dogsComboBox);
        dogFrame.setVisible(true);
    }
}
