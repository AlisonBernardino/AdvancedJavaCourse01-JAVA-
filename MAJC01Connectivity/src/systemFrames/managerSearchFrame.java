package systemFrames;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import systemFiles.databaseConfiguration;
import systemFiles.appNavigator;
import systemParts.Manager;

public class managerSearchFrame extends JPanel{
    Manager currentManager;
    JLabel titleLabel, managerLabel;
    JTextField managerField;
    JButton searchButton, editButton, deleteButton;
    DefaultListModel<Manager> managerListModel = new DefaultListModel();
    JList<Manager> managerList;
    
    public managerSearchFrame(){
        createItems();
        createEvents();
    }
    
    private void createItems(){
        setLayout(null);
        titleLabel = new JLabel("Triple S - Search for a manager", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 22));
        managerLabel = new JLabel("Manager name: ", JLabel.LEFT);
        managerField = new JTextField();
        searchButton = new JButton("Search");
        editButton = new JButton("Edit");
        editButton.setEnabled(false);
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        managerListModel = new DefaultListModel();
        managerList = new JList();
        managerList.setModel(managerListModel);
        managerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        titleLabel.setBounds(21,21,661,41);
        managerLabel.setBounds(151,121,401,21);
        managerField.setBounds(151,141,401,41);
        searchButton.setBounds(561,141,131,41);
        managerList.setBounds(151,201,401,241);
        editButton.setBounds(561,361,131,41);
        deleteButton.setBounds(561,401,131,41);
        
        add(titleLabel);
        add(managerLabel);
        add(managerField);
        add(managerList);
        add(searchButton);
        add(editButton);
        add(deleteButton);
        setVisible(true);
        
        searchButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent searchButtonEvent){
               SQLSearchManager(managerField.getText());
           }
        });
        
        editButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent editButtonEvent){
               appNavigator.managerEditFrame(currentManager);
           }
        });
        
        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent deleteButtonEvent){
                SQLDeleteManager();
            }
        });
        
        managerList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void changedValue(ListSelectionEvent managerListEvent){
                currentManager = managerList.getSelectedValue();
                if(currentManager == null){
                    editButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }else{
                    editButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
            }
        });
    }
    
    private void SQLManagerSearch(String managerName){
        Connection managerSearchSQLConnection;
        Statement managerSearchSQLInstruction;
        ResultSet managerSearchSQLOutput;
        
        try{
            managerSearchSQLConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            managerSearchSQLInstruction = managerSearchSQLConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            managerSearchSQLOutput = managerSearchSQLInstruction.executeQuery("SELECT * from registeredManagers WHERE managerName like '%" + managerName + "%' order by managerName asc");
            managerListModel.clear();
            
            while(managerSearchSQLOutput.next()){
                Manager newManager = new Manager();
                newManager.setManagerID(managerSearchSQLOutput.getInt("managerID"));
                newManager.setManagerFirstName(managerSearchSQLOutput.getString("managerFirstName"));
                newManager.setManagerLastName(managerSearchSQLOutput.getString("managerLastName"));
                newManager.setManagerBornDate(managerSearchSQLOutput.getString("managerBornDate"));
                newManager.setManagerEmail(managerSearchSQLOutput.getString("managerEmail"));
                if(managerSearchSQLOutput.getString("managerOccupation") != null){
                    newManager.setManagerOccupation(Integer.parseInt(managerSearchSQLOutput.getString("managerOccupation")));
                    newManager.setManagerSalary(Double.parseDouble(managerSearchSQLOutput.getString("managerSalary")));
                    managerListModel.addElement(newManager);
                };
            }
        }catch(SQLException managerSearchException){
            JOptionPane.showMessageDialog(null, "Error E-01! We encountered a problem during the manager search. Please, re-check the typed information to proceed.");
            Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, managerSearchException);
        }
    }
    
    private void SQLDeleteManager(){
        String deleteQuestion = "Are you sure you want to delete this register?" + currentManager.getName() + "?";
        int deleteConfirmation = JOptionPane.showConfirmDialog(null, deleteQuestion, "Delete", JOptionPane.YES_NO_OPTION);
        if(deleteConfirmation == JOptionPane.YES_OPTION){
            Connection SQLDeleteConnection;
            Statement SQLDeleteInstruction;
            ResultSet SQLDeleteOutput;
            
            try{
                SQLDeleteConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
                SQLDeleteInstruction = SQLDeleteConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                SQLDeleteInstruction.executeUpdate("DELETE registeredManager WHERE managerID = " + currentManager.getManagerID()+"");
                JOptionPane.showMessageDialog(null, "Manager register deleted successfully!");
                appNavigator.homeFrame();
            }catch(SQLException managerDeleteException){
                JOptionPane.showMessageDialog(null, "Error E-01! A problem was encountered during the register removal process. Please, re-check the inserted informations to proceed.");
                Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, managerDeleteException);
            }
        }
    }
}
