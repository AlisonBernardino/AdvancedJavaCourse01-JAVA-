package courseActivities;
// To build the menu, we will need 04 different classes imports = 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// "Clock" class
public class l02JMenu {
    public static void main(String[] args){
        JFrame clockFrame = new JFrame("Clock frame");
        clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clockFrame.setSize(440,340);
        clockFrame.setLayout(null);
        
        JMenuBar clockMenuBar = new JMenuBar();
        JMenu clockMenu = new JMenu("Clock menu");
        JMenuItem clockMenuItem = new JMenuItem("The clock is ticking...");
        
        clockMenu.add(clockMenuItem);
        clockMenuBar.add(clockMenu);
        
        clockFrame.setJMenuBar(clockMenuBar);
        clockFrame.setVisible(true);
    }
}
