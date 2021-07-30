package systemFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import systemFiles.databaseConfiguration;
import systemFiles.appNavigator;
import systemParts.Occupation;
import systemParts.Manager;

public class addNewManagerFrame extends JPanel{
    Manager registeredManager;
    JLabel titleLabel, firstNameLabel, lastNameLabel, emailLabel, bornDateLabel, occupationLabel, salaryLabel;
    JTextField firstNameField, lastNameField, emailField;
    JComboBox occupationComboBox;
    JButton saveButton, confirmButton, clearAllButton, exitButton;
    JFormattedTextField bornDateField, salaryField;
    
    public addNewManagerFrame(){
        createComponents();
        createEvents();
    }
    
    private void createComponents(){
        setLayout(null);
        titleLabel = new JLabel("Triple S - Add a new manager", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 22));
        firstNameLabel = new JLabel("First name: ", JLabel.LEFT);
        firstNameField = new JTextField();
        lastNameLabel = new JLabel("Last name: ",JLabel.LEFT);
        lastNameField = new JTextField();
        emailLabel = new JLabel("Email: ", JLabel.LEFT);
        emailField = new JTextField();
        bornDateLabel = new JLabel("Born date: ", JLabel.LEFT);
        bornDateField = new JFormattedTextField();
                
        try{
            MaskFormatter bornDateMask = new MaskFormatter("##/##/####");
            bornDateMask.install(bornDateField);
        }catch(ParseException addNewManagerException){
            Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, addNewManagerException);
        }
        
        occupationLabel = new JLabel("Occupation: ", JLabel.LEFT);
        occupationComboBox = new JComboBox();
        salaryLabel = new JLabel("Salary: ", JLabel.LEFT);
        DecimalFormat salaryFormatter = new DecimalFormat("###0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        salaryField = new JFormattedTextField(salaryFormatter);
        salaryField.setValue(0.00);
        saveButton = new JButton("Save");
        confirmButton = new JButton("Confirm");
        clearAllButton = new JButton("Clear all");
        exitButton = new JButton("Exit");
        
        titleLabel.setBounds(20,20,660,40);
        firstNameLabel.setBounds(150,80,400,20);
        firstNameField.setBounds(150,100,400,40);
        lastNameLabel.setBounds(150,140,400,20);
        lastNameField.setBounds(150,160,400,40);
        emailLabel.setBounds(150,200,400,20);
        emailField.setBounds(150,220,400,40);
        bornDateLabel.setBounds(150,260,400,20);
        bornDateField.setBounds(150,280,400,40);
        occupationLabel.setBounds(150, 320,400,20);
        occupationComboBox.setBounds(150, 340,400,40);
        salaryLabel.setBounds(150, 380,400,20);
        salaryField.setBounds(150, 400,400,40);
        saveButton.setBounds(560,400,130,40);
        confirmButton.setBounds(560, 420,130,40);
        clearAllButton.setBounds(560,440,130,40);
        exitButton.setBounds(560,460,130,40);
        
        add(titleLabel);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(emailLabel);
        add(emailField);
        add(bornDateLabel);
        add(bornDateField);
        add(occupationLabel);
        add(occupationComboBox);
        add(salaryLabel);
        add(salaryField);
        add(confirmButton);
        SQLLoadOccupations();
        setVisible(true);
    }
    
    private void createEvents(){
        saveButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent createEventsEvent){
               Manager newManager = new Manager();
               newManager.setFirstName(firstNameField.getText());
               newManager.setLastName(lastNameField.getText());
               newManager.setEmail(emailField.getText());
               newManager.setBornDate(bornDateField.getText());
               Occupation selectedOccupation = (Occupation) occupationCombobox.getSelectedItem();
               if(selectedOccupation != null){
                   newManager.setOccupation(selectedOccupation.getID());
               }
               newManager.setSalary(Double.valueOf(salaryField.getText().replace(",",".")));
               SQLInsertManager(newManager);
           }
        });
    }
    
    private void SQLLoadOccupations(){
       Connection occupationConnection;
       Statement occupationSQLInstruction;
       ResultSet occupationSQLOutput;
       
       try{
           occupationConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
           occupationSQLInstruction = occupationConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           occupationSQLOutput = occupationSQLInstruction.executeQuery("SELECT * from registeredOccupations order by name asc");
           occupationComboBox.removeAll();
           
           while(occupationSQLOutput.next()){
               Occupation registeredOccupation = new Occupation();
               registeredOccupation.setID(occupationSQLOutput.getInt("occupationID"));
               registeredOccupation.setName(occupationSQLOutput.getString("occupationName"));
               occupationComboBox.addItem(registeredOccupation);
           }
           occupationComboBox.updateUI();
           occupationConnection.close();
       }catch(SQLException occupationsLoadException){
           Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, occupationsLoadException);
       }
    }
    
    private void SQLInsertManager(Manager newManager){
        // First name validation
        if(firstNameField.getText().length() < 3){
            JOptionPane.showMessageDialog(null, "Error B-01! Invalid first name. Please, re-insert this information to proceed.");
            return;
        }
        
        // Last name validation
        if(lastNameField.getText().length() < 3){
            JOptionPane.showMessageDialog(null, "Error B-01 Invalid last name. Please, re-insert this information to proceed.");
        }
        
        // Email validation
        Boolean isEmailValid = false;
        String emailPattern = "^[a-zA-20-9.!#$%'*+/=?^_`{|}~-]+!((\\[[0-9]{1,3}\\.[0-9]{1,3\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern currentPattern = Pattern.compile(emailPattern);
        Matcher currentMatcher = currentPattern.matcher(emailField.getText());
        
        if(!isEmailValid){
            JOptionPane.showMessageDialog(null, "Error B-01! Invalid email. Please, re-insert this information to proceed.");
        }
        
        Connection newManagerConnection;
        PreparedStatement newManagerSQLInstruction;
        try{
            newManagerConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            String newManagerTemplate = "INSERT INTO registeredManagers (managerFirstName, managerLastName, managerEmail, managerBornDate, managerOccupation, managerSalary)";
            newManagerTemplate += " VALUES (?,?,?,?,?,?)";
            newManagerSLInstruction = newManagerConnection.prepareStatement(newManagerTemplate);
            newManagerSQLInstruction.setString(1, newManager.getFirstName());
            newManagerSQLInstruction.setString(2, newManager.getLastName());
            newManagerSQLInstruction.setString(3, newManager.getEmail());
            if(newManager.getOccupation() > 0){
                newManagerSQLInstruction.setInt(4, newManager.getOccupation());
            }else{
                newManagerSQLInstruction.setNull(5, java.sql.Types.INTEGER);
            }
            newManagerSQLInstruction.setString(6, Double.toString(newManager.getSalario()));
            newManagerSQLInstruction.executeUpdate();
            JOptionPane.showMessageDialog(null, "New manager added successfully!");
            appNavigator.homeFrame();
        }catch(SQLException newManagerSQLException){
            JOptionPane.showMessageDialog(null, "Error D-01! There was an error during the manager insertion. Please, re-check the informations and try again. (newManagerSQLException)");
            Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, newManagerSQLException);
        }
    }
}
