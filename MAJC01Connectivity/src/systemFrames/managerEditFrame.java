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

public class managerEditFrame extends JPanel{
    Manager currentManager;
    JLabel titleLabel, managerFirstNameLabel, managerLastNameLabel, managerBornDateLabel, managerOccupationLabel, managerEmailLabel, managerSalaryLabel;
    JTextField managerFirstNameField, managerLastNameField, managerBornDateField, managerEmailField, managerSalaryField;
    JComboBox managerOccupationComboBox;
    JButton saveButton, clearAllButton, exitButton;
    
    public managerEditFrame(){
        createManagerEditItems();
        createManagerEditEvents();        
    }
    
    public void createManagerEditItems(){
        setLayout(null);
        String textLabel = "Triple S - Edit " + currentManager.getManagerLastName() + ", " + currentManager.getManagerFirstName() + " manager";
        titleLabel = new JLabel(textLabel, JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
        managerFirstNameLabel = new JLabel("First name:", JLabel.LEFT);
        managerFirstNameField = new JTextField(currentManager.getManagerFirstName());
        managerLastNameLabel = new JLabel("Last name: ", JLabel.LEFT);
        managerLastNameField = new JTextField(currentManager.getManagerLastName());
        managerBornDateLabel = new JLabel("Born date: ", JLabel.LEFT);
        managerBornDateField = new JFormattedTextField(currentManager.getManagerBornDate());
        try{
            MaskFormatter managerBornDateMask = new MaskFormatter("##/##/####");
        }catch(ParseException managerEditParseException){
            Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, managerEditParseException);
        }
        managerOccupationLabel = new JLabel("Occupation: ", JLabel.LEFT);
        managerOccupationComboBox = new JComboBox();
        managerEmailLabel = new JLabel("Email: ",JLabel.LEFT);
        managerEmailField = new JTextField(currentManager.getManagerEmail());
        managerSalaryLabel = new JLabel("Salary: ", JLabel.LEFT);
        DecimalFormat managerSalaryFormatter = new DecimalFormat("###0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        managerSalaryField = new JFormattedTextField(managerSalaryFormatter);
        managerSalaryField.setValue(currentManager.getManagerSalary());
        saveButton = new JButton("Save");
        clearAllButton = new JButton("Clear all");
        exitButton = new JButton("Exit");
        
        titleLabel.setBounds(21,21,661,41);
        managerFirstNameLabel.setBounds(151,81,401,21);
        managerFirstNameField.setBounds(151,101,401,41);
        managerLastNameLabel.setBounds(151,141,401,21);
        managerLastNameField.setBounds(151,161,401,41);
        managerBornDateLabel.setBounds(151,201,401,21);
        managerBornDateField.setBounds(151,221,401,41);
        managerOccupationLabel.setBounds(151,321,401,21);
        managerOccupationComboBox.setBounds(151,341,401,41);
        managerEmailLabel.setBounds(151,261,401,21);
        managerEmailField.setBounds(151,281,401,41);
        managerSalaryLabel.setBounds(151,381,401,21);
        managerSalaryField.setBounds(151,401,401,41);
        saveButton.setBounds(561,401,131,41);
        clearAllButton.setBounds(561,421,131,41);
        exitButton.setBounds(561,441,131,41);
        
        add(titleLabel);
        add(managerFirstNameLabel);
        add(managerFirstNameField);
        add(managerLastNameLabel);
        add(managerLastNameField);
        add(managerBornDateLabel);
        add(managerBornDateField);
        add(managerOccupationLabel);
        add(managerOccupationComboBox);
        add(managerEmailLabel);
        add(managerEmailField);
        add(managerSalaryLabel);
        add(managerSalaryField);
        add(saveButton);
        add(clearAllButton);
        add(exitButton);
        
        SQLLoadOccupations(currentManager.getManagerOccupation());
        setVisible(true);
    }
    
    private void createManagerEditEvents(){
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent managerEditEventAction){
                currentManager.setManagerFirstName(managerFirstNameField.getText());
                currentManager.setManagerLastName(managerLastNameField.getText());
                currentManager.setManagerBornDate(managerBornDateField.getText());
                Occupation selectedOccupation = (Occupation) managerOccupationComboBox.getSelectedItem();
                if(selectedOccupation != null){
                    currentManager.setManagerOccupation(selectedOccupation.getID());
                }
                currentManager.setManagerEmail(managerEmailField.getText());
                currentManager.setManagerSalary(Double.valueOf(managerSalaryField.getText().replace(",", ".")));
                SQLUpdateManager();
            }
        });
    }
    
    private void SQLUpdateManager(int currentOccupation){
        Connection managerUpdateSQLConnection;
        Statement managerUpdateSQLInstruction;
        ResultSet managerUpdateSQLOutput;
        try{
            managerUpdateSQLConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            managerUpdateSQLInstruction = managerUpdateSQLConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            managerUpdateSQLOutput = managerUpdateSQLInstruction.executeQuery("SELECT * FROM availableOccupations order by occupationName asc");
            managerOccupationComboBox.removeAll();
            while(managerUpdateSQLOutput.next()){
                Occupation selectedOccupation = new Occupation();
                Occupation.setOccupationID(managerUpdateSQLOutput.getInt("occupationID"));
                Occupation.setOccupationName(managerUpdateSQLOutput.getString("occupationName"));
                managerOccupationComboBox.addItem(selectedOccupation);
                if(currentOccupation == selectedOccupation){
                    
                }
            }
        }catch(SQLException managerUpdateException){
            JOptionPane.showMessageDialog(null, "Error E-01! An error occurred during the manager update. Please, re-check the typed information to proceed. (managerUpdateException)");
            Logger.getLogger(addNewManagerFrame.class.getName()).log(Level.SEVERE, null, managerUpdateException);
        }
    }
    
    private void SQLUpdateManager(){
        if(managerFirstNameField.getText().length() <= 2){
            JOptionPane.showMessageDialog(null, "Error A-01! Please, re-insert the manager first name");
            return;
        }
        
        if(managerLastNameField.getText().length() <= 2){
            JOptionPane.showMessageDialog(null, "Error A-02! Please, re-insert the manager last name");
            return;
        }
        
        Boolean isEmailValid = false;
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3]\\.emailPattern[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern compiledPattern = Pattern.compile(emailPattern);
        Matcher patternMatcher = compiledPattern.matcher(managerEmailField.getText());
        isEmailValid = patternMatcher.matches();
        
        if(!isEmailValid){
            JOptionPane.showMessageDialog(null, "Error A-03! Invalid email. Please, re-check the inserted email to proceed.");
            return;
        }
        
        Connection managerEditSQLUpdateConnection;
        PreparedStatement managerEditSQLInstruction;
        ResultSet managerEditSQLOutput;
        
        try{
            managerEditSQLUpdateConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            String updateTemplate = "UPDATE availableManagers set managerFirstName=?, managerLastName=?, managerBornDate=?, managerOccupation=?, managerEmail=?, managerSalary=?";
            updateTemplate += "WHERE managerID =" + currentManager.getManagerID();
            managerEditSQLInstruction = managerEditSQLUpdateConnection.prepareStatement(updateTemplate);
            managerEditSQLInstruction.setString(1, managerFirstNameField.getText());
            managerEditSQLInstruction.setString(2, managerLastNameField.getText());
            managerEditSQLInstruction.setString(3, managerBornDateField.getText());
            Occupation selectedOccupation = (Occupation) managerOccupationComboBox.getSelectedItem();
            if(selectedOccupation != null){
                managerEditSQLInstruction.setInt(4, selectedOccupation.getOccupationID());
            }else{
                managerEditSQLInstruction.setNull(4, java.sql.Types.INTEGER);
            }
            managerEditSQLInstruction.setString(5, managerEmailField.getText());
        }catch(){
            
        }
    }
}
