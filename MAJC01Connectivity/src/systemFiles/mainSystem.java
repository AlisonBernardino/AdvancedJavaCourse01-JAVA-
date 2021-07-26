// These commands were used to create 
// a temporary command for "mainSystem" class
// and show the "Home" screen
package systemFiles;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainSystem {
    // Login screen configuration
    public static JPanel mainSystemScreen;
    public static JFrame mainSystemFrame;

    // Home screen configuration
    // public static JPanel homeScreen;
    // public static JFrame homeFrame;
    public static void main(String[] args) {
        createComponents();
    }

    private static void createComponents() {
        mainSystemFrame = new JFrame("Triple S - Home");
        mainSystemFrame.setSize(720,520);
        mainSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSystemFrame.setLocationRelativeTo(null);

        appNavigator.systemLogin();
    }
}

// These commands were used to create 
// a temporary command for "mainSystem" class
// and show the "Login" screen
/*
package systemFiles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import systemFrames.loginFrame;
import systemFrames.homeFrame;

public class mainSystem {
    // Login screen configuration
    public static JPanel mainSystemScreen;
    public static JFrame mainSystemFrame;

    // Home screen configuration
    // public static JPanel homeScreen;
    // public static JFrame homeFrame;
    public static void main(String[] args) {
        createComponents();
    }

    private static void createComponents() {
        mainSystemFrame = new JFrame("Main system frame");
        mainSystemFrame.setSize(720,520);
        mainSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSystemFrame.setLocationRelativeTo(null);

        // homeFrame = new JFrame("Triple S - Home");
        // homeFrame.setSize(730, 530);
        // homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // homeFrame.setLocationRelativeTo(null);

        mainSystemScreen = new loginFrame();
        mainSystemScreen.setVisible(true);
        mainSystemFrame.add(mainSystemScreen);
        mainSystemFrame.setVisible(true);
        
        // homeScreen = new homeFrame();
        // homeScreen.setVisible(true);
        // homeScreen.add(homeScreen);
        // homeScreen.setVisible(true);
    }
}
*/
