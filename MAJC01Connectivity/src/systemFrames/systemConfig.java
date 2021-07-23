package systemFrames;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class systemConfig {
    public static JPanel appScreen;
    public static JFrame appFrame;
    
    public static void main(String[] args){
        createComponents();
    }
    
    private static void createComponents(){
        appFrame = new JFrame("Supermarket system frame");
        appFrame.setSize(720,520);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setLocationRelativeTo(null);
        
        Browser.login();
    }
}
