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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import systemFiles.databaseConfiguration;
import systemParts.Professional;

public class professionalEditFrame extends JPanel {
    professionalName currentProfessionalName;
    professionalOccupation currentProfessionalOccupation;
    professionalSalary currentProfessionalSalary;
    JLabel titleLabel, professionalNameLabel, professionalOccupationLabel, professionalSalaryLabel;
    JTextField professionalNameField, professionalOccupationField, professionalSalaryField;
    JButton saveButton;
    
    public professionalEditFrame(professionalName professionalFirstName, professionalOccupation mainProfessionalOccupation, professionalSalary totalProfessionalSalary){
        currentProfessionalName = professionalFirstName;
        createItems();
        createEvents();
    }
    
    private void createItems(){
        setLayout(null);
        
        titleLabel = new JLabel("Triple S - Edit a registered professional", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN, 25));
        professionalNameLabel = new JLabel("Name: ");
        professionalNameField = new JTextField(currentProfessionalName.getName());
        professionalOccupationLabel = new JLabel("Occupation: ");
        professionalOccupationField = new JTextField(currentProfessionalOccupation.getOccupation());
        professionalSalaryLabel = new JLabel("Salary: ");
        professionalSalaryField = new JTextField(currentProfessionalSalary.getSalary());
        saveButton = new JButton("Save");
        
        titleLabel.setBounds(22,22,662,42);
        professionalNameLabel.setBounds(152, 122, 402, 22);
        professionalNameField.setBounds(152, 142, 402, 42);
        professionalOccupationLabel.setBounds(152,162,402,62);
        professionalOccupationField.setBounds(152,182,402,82);
        professionalSalaryLabel.setBounds(152, 202, 402, 102);
        professionalSalaryField.setBounds(152, 222, 402, 122);
        
        add(titleLabel);
        add(professionalNameLabel);
        add(professionalNameField);
        add(professionalOccupationLabel);
        add(professionalOccupationField);
        add(professionalSalaryLabel);
        add(professionalSalaryField);
        setVisible(true);
    }
    
    private void createEvents(){
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event01){
                currentProfessionalName.setName(professionalNameField.getText());
                currentProfessionalOccupation.setOccupation(professionalOccupationField.getText());
                currentProfessionalSalary.set.setSalary(professionalSalaryField.getText());
                SQLUpdateProfessional();
            }
        });
    }
    
    private void SQLUpdateProfessional(){
        if(currentProfessionalName.getText().length() <= 2){
            JOptionPane.showMessageDialog(null, "Error A-01! Invalid professional name. Please, re-insert the name to proceed.");
            return;
        }
        
        Connection SQLUpdateConnection;
        Statement SQLUpdateInstruction;
        ResultSet SQLUpdateOutput;
        
        try{
            SQLUpdateConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            SQLUpdateInstruction = SQLUpdateConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQLUpdateInstruction.executeUpdate("UPDATE registeredProfessionals set professionalName ='" + professionalNameField.getText() + "' WHERE professionalID = " + professionalNameField.getID() + "");
            SQLUpdateInstruction.executeUpdate("UPDATE registeredProfessionals set professionalOccupation = '" + professionalOccupationField.getText() + "'WHERE professionalID = " + professionalOccupationField.getID() + "");
            SQLUpdateInstruction.executeUpdate("UPDATE registeredProfessionals set professionalSalary = '" + professionalSalaryField.getText() + "'WHERE professionalID = " + professionalSalaryField.getID() + "");
            JOptionPane.showMessageDialog(null, "Professional update completed successfully!");
            SQLUpdateConnection.close();
        }catch(SQLException SQLError){
            JOptionPane.showMessageDialog(null, "Error B-01! An error has occurred during the update process. Please, re-check the information to proceed");
            Logger.getLogger(professionalFrame.class.getName()).log(Level.SEVERE, null, SQLError);
        }
    }
}
