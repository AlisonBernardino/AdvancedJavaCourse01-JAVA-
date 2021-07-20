package courseActivities;
import javax.swing.JFrame;
import javax.swing.JButton;

// "Archer" class
public class l02JButton {
    public static void main(String[] args){
        JFrame archerFrame = new JFrame("Archer frame");
        archerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        archerFrame.setSize(410,310);
        archerFrame.setLayout(null);
        
        JButton archerButton = new JButton("Archer button");
        archerButton.setBounds(30,140,380,50);
        
        archerFrame.add(archerButton);
        archerFrame.setVisible(true);
    }
}
