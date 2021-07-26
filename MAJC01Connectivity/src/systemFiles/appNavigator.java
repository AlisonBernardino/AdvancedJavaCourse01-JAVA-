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
    private static JMenuBar mainMenuBar;
    private static JMenu fileMenu, professionalMenu, occupationMenu, relatoryMenu;
    private static JMenuItem exitItem, searchProfessionalItem, newProfessionalItem;
    private static JMenuItem searchOccupationItem, newOccupationItem, occupationRelatoryItem, occupationSalaryRelatoryItem;
    
    public static void systemLogin(){
        mainSystem.mainSystemScreen = new loginFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Smart Supermarket System");
        appNavigator.updateScreen();
    }
    
    public static void homeFrame(){
        mainSystem.mainSystemScreen = new homeFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Supermarket system - Home");
        appNavigator.updateScreen();
    }
    
    public static void professionalRegister(){
        mainSystem.mainSystemScreen = new professionalFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Add new professional");
    }
    
    public static void professionalNameSearch(){
        mainSystem.mainSystemScreen = new professionalSearchFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Search professional by name");
        appNavigator.updateScreen();
    }
    
    public static void professionalNameEdit(professionalName workerName){
        mainSystem.mainSystemScreen = new professionalEditFrame();
        mainSystem.mainSystemFrame.setTitle("Triple S - Edit professional name");
        appNavigator.updateScreen();
    }
    
    public static void updateScreen(){
        mainSystem.mainSystemFrame.getContentPane().removeAll();
        mainSystem.mainSystemScreen.setVisible(true);
        mainSystem.mainSystemFrame.add(mainSystem.mainSystemScreen);
        mainSystem.mainSystemFrame.setVisible(true);
    }
    
    private static void menuBuild(){
        if(!isMenuBuilded){
            isMenuBuilded = true;
            mainMenuBar = new JMenuBar();
            
            // "Files" sub-menu
            fileMenu = new JMenu("Files");
            mainMenuBar.add(fileMenu);
            exitItem = new JMenuItem("Exit");
            fileMenu.add(exitItem);
            
            // "Professionals" sub-menu
            professionalMenu = new JMenu("Professionals");
            mainMenuBar.add(professionalMenu);
            newProfessionalItem = new JMenuItem("Add new member");
            professionalMenu.add(newProfessionalItem);
            searchProfessionalItem = new JMenuItem("Search for a member");
            professionalMenu.add(searchProfessionalItem);
            
            // "Occupations" sub-menu
            occupationMenu = new JMenu("Occupations");
            mainMenuBar.add(occupationMenu);
            newOccupationItem = new JMenuItem("Add new ooccupation");
            occupationMenu.add(newOccupationItem);
            searchOccupationItem = new JMenuItem("Search for an occupation");
            
            // "Relatories" sub-menu
            relatoryMenu = new JMenu("Relatories");
            mainMenuBar.add(relatoryMenu);
            occupationRelatoryItem = new JMenuItem("Occupation relatory");
            relatoryMenu.add(occupationRelatoryItem);
            occupationSalaryRelatoryItem = new JMenuItem("Occupation salaries relatory");
            relatoryMenu.add(occupationSalaryRelatoryItem);
            
            createEventsMenu();
        }
    }
    
    // To enable the menu
    public static void enableMenu(){
        if(!isMenuBuilded){
            menuBuild();
        }
        if(!isMenuEnabled){
            isMenuEnabled = true;
            mainSystem.mainSystemFrame.setJMenuBar(mainMenuBar);
        }
    }
    
    // To disable the menu
    public static void disableMenu(){
        if(isMenuEnabled){
            isMenuEnabled = false;
            mainSystem.mainSystemFrame.setJMenuBar(null);
        }
    }
    
    private static void createEventsMenu(){
        exitItem.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent createEventMenu){
               System.exit(0);
           }
        });
        
        newProfessionalItem.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent newProfessionalNameEvent){
               
           }
        });
        
        searchProfessionalItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent searchProfessionalEvent) {
               
           }
        });
        
        occupationRelatoryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent occupationRelatoryEvent){
                
            }
        });
        
        occupationSalaryRelatoryItem.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent salaryRelatoryEvent){
                
            }
        });
    }
    
}
