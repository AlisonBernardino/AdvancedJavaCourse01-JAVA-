package systemFrames;

import javax.swing.JLabel;
import javax.swing.JPanel;
import systemFiles.appNavigator;

public class homeFrame extends JPanel {
    JLabel titleLabel;
    
    public homeFrame(){
        enableItems();
        enableEvents();
        appNavigator.enableMenu();
    }
    
    private void enableItems(){
        // This command indicates no layout manager use
        setLayout(null);
        
        titleLabel = new JLabel("Choose a menu option to proceed", JLabel.CENTER);
        titleLabel.setBounds(25,105,665,45);
        add(titleLabel);
        setVisible(true);
    }
    
    private void enableEvents(){
        
    }
}
