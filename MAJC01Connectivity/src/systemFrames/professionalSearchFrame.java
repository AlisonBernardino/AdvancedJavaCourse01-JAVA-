// Instead of "occupations", this list is used to show
// professionals attributes by name
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
import systemFiles.appNavigator;
import systemFiles.databaseConfiguration;
import systemParts.Professional;

public class professionalSearchFrame extends JPanel {

    Professional registeredProfessional;
    JLabel titleLabel, professionalNameLabel;
    JTextField professionalNameField;
    JButton searchButton, editButton, deleteButton;
    DefaultListModel<Professional> professionalListModel = new DefaultListModel();
    JList<Professional> professionalList;

    public professionalSearchFrame() {
        createItems();
        createEvents();
    }

    private void createItems() {
        setLayout(null);

        titleLabel = new JLabel("Professionals - Search by name", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 25));
        professionalNameLabel = new JLabel("Professional name: ", JLabel.LEFT);
        professionalNameField = new JTextField();
        searchButton = new JButton("Search name");
        editButton = new JButton("Edit name");
        editButton.setEnabled(false);
        deleteButton = new JButton("Erase name");
        deleteButton.setEnabled(false);
        professionalListModel = new DefaultListModel();
        professionalList = new JList();
        professionalList.setModel(professionalListModel);
        professionalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        titleLabel.setBounds(21, 21, 661, 41);
        professionalNameLabel.setBounds(151, 121, 401, 21);
        professionalNameField.setBounds(151, 141, 401, 41);
        searchButton.setBounds(561, 141, 131, 41);
        professionalList.setBounds(151, 201, 401, 241);
        editButton.setBounds(561, 361, 131, 41);
        deleteButton.setBounds(561, 401, 131, 41);
        add(titleLabel);
        add(professionalNameLabel);
        add(professionalNameField);
        add(professionalList);
        add(searchButton);
        add(editButton);
        add(deleteButton);

        setVisible(true);
    }
    
    private void createEvents() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event01) {
                SQLProfessionalSearch(professionalNameField.getText());
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event01){
                appNavigator.professionalEdit(registeredProfessional);
            }
        });
        deleteButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent event01){
               SQLDeleteProfessional();
           }
        });
        professionalList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void changedValue(ListSelectionEvent event01){
                registeredProfessional = professionalList.getSelectedValue();
                if(registeredProfessional == null){
                    editButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }else{
                    editButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
            }
        });
    }
    
    private void SQLProfessionalSearch(String professionalName){
        
        Connection searchConnection;
        Statement SQLSearchInstruction;
        ResultSet SQLSearchOutputData;
        
        try{
            searchConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            SQLSearchInstruction = searchConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQLSearchOutputData = SQLSearchInstruction.executeQuery("SELECT * FROM registeredProfessionals WHERE professionalFirstName like " + professionalName + "%'");
            
            professionalListModel.clear();
            
            while(SQLSearchOutputData.next()){
                Professional newProfessional = new Professional();
                newProfessional.setProfessionalID(SQLSearchOutputData.getInt("professionalID"));
                newProfessional.setProfessionalName(SQLSearchOutputData.getString("professionalName"));
                
                professionalListModel.addElement(newProfessional);
            }
        }catch(SQLException SQLError){
            JOptionPane.showMessageDialog(null, "Error D-01! There was a problem during names search. Please, review the inserted information");
            Logger.getLogger(professionalSearchFrame.class.getName()).log(Level.SEVERE, null, SQLError);
        }
    }
    
    private void SQLProfessionalDelete(){
        int deleteConfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete the " + registeredProfessional.getName() + " register?", "Delete", JOptionPane.YES_NO_OPTION);
        if(deleteConfirmation == JOptionPane.YES_OPTION){
            Connection SQLDeleteConnection;
            Statement SQLDeleteInstruction;
            ResultSet SQLDeleteOutputData;
            
            try{
                SQLDeleteConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
                SQLDeleteInstruction = SQLDeleteConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                SQLDeleteInstruction.executeUpdate("DELETE registeredProfessionals WHERE professionalID = " + registeredProfessional.getID() + "");
                JOptionPane.showMessageDialog(null, "Professional register deleted successfully!");
            }catch(SQLException SQLError){
                JOptionPane.showMessageDialog(null, "Error E-01! An error was identified during the register removal process. Please, re-check the inserted information and try again.");
                Logger.getLogger(professionalSearchFrame.class.getName()).log(Level.SEVERE, null, SQLError);
            }
        }
    }
}
