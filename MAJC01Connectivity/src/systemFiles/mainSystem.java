// These commands were used to create 
// a temporary command for "mainSystem" class
package systemFiles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import systemFrames.loginFrame;

public class mainSystem {
    public static JPanel mainSystemScreen;
    public static JFrame mainSystemFrame;
    
    public static void main(String[] args){
        createComponents();
    }
    
    private static void createComponents(){
        mainSystemFrame = new JFrame("Main system frame");
        mainSystemFrame.setSize(720,520);
        mainSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSystemFrame.setLocationRelativeTo(null);
        
        mainSystemScreen = new loginFrame();
        mainSystemScreen.setVisible(true);
        mainSystemFrame.add(mainSystemScreen);
        mainSystemFrame.setVisible(true);
    }
}
