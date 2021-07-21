package courseActivities;
import javax.swing.JFrame;
import javax.swing.JScrollBar;

// "Cat" class
public class l02JScrollBar {
    public static void main(String[] args){
        JFrame catFrame = new JFrame("Cat frame");
        catFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        catFrame.setSize(440,340);
        catFrame.setLayout(null);
        
        JScrollBar catScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 55, 2, 1, 110);
        catScrollBar.setBounds(25, 135, 365, 20);
        catFrame.add(catScrollBar);
        catFrame.setVisible(true);
    }
}
