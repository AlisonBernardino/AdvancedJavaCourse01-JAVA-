package systemFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import systemParts.Professional;
import systemFrames.professionalSearchFrame;
import systemFrames.professionalEditFrame;
import systemFrames.professionalFrame;
import systemFrames.homeFrame;
import systemFrames.loginFrame;

public class appNavigator {
    private static boolean isMenuBuilded;
    private static boolean isMenuEnabled;
    private static JMenuBar menuBar;
    private static JMenu fileMenu, professionalMenu, occupationMenu, relatoryMenu;
    private static JMenuItem exitMenuItem, searchProfessionalMenuItem, newProfessionalMenuItem;
    private static JMenuItem searchOccupationMenuItem, occupationRelatoryMenuItem, occupationSalaryRelatoryMenuItem;
    
    public static void systemLogin(){
        mainSystem.mainSystemScreen = new loginFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Supermarket system - Professionals");
        appNavigator.updateScreen();
    }
}
