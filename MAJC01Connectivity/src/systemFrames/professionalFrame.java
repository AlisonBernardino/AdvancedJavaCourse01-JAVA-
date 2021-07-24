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

public class professionalFrame extends JPanel{
    JLabel titleLabel, occupationLabel, salaryLabel, professionalNameLabel;
    JTextField professionalNameField, occupationField, salaryField;
    JButton confirmButton;
    
    public professionalFrame(){
        createComponents();
        createEvents();
    }
    
    private void createComponents(){
        setLayout(null);
        titleLabel = new JLabel("Professional register", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 25));
        professionalNameLabel = new JLabel("Name: ");
        professionalNameField = new JTextField();
        occupationLabel = new JLabel("Occupation title: ", JLabel.LEFT);
        occupationField = new JTextField();
        salaryLabel = new JLabel("Salary value (In US$): ", JLabel.LEFT);
        salaryField = new JTextField();
        confirmButton = new JButton("Confirm");
        
        titleLabel.setBounds(21,21,661,41);
        occupationLabel.setBounds(151,121,401,21);
        occupationField.setBounds(181,151,431,21);
        salaryLabel.setBounds(211,181,461,21);
        salaryField.setBounds(241,211,491,21);
        confirmButton.setBounds(271,241,521,21);
        
        add(titleLabel);
        add(professionalNameLabel);
        add(professionalNameField);
        add(occupationLabel);
        add(occupationField);
        add(salaryLabel);
        add(salaryField);
        add(confirmButton);
        
        setVisible(true);
    }
    
    private void createEvents(){
        confirmButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent message01){
               Occupation newOccupation = new Occupation();
               newOccupation.setName(occupationField.getText);
               
               sQLInsertOccupation(newOccupation);
           }
        });
    }
    
    private void sqlInsertOccupation(Occupation newOccupation){
        if(occupationField.getText().length() <= 4){
            JOptionPane.showMessageDialog(null, "Error C-01! Occupation unknown! Please, re-insert the occupation title");
            return;
        }
        
        Connection SQLConnection;
        Statement SQLCommand;
        ResultSet SQLOutput;
        
        try{
            SQLConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            SQLCommand = SQLConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQLCommand.executeUpdate("INSERT INTO registeredProfessionals VALUES ('" + newOccupation.getName() + "')");
            JOptionPane.showMessageDialog(null, "Occupation inserted succesfully!");
        }catch(SQLException SQLError){
            JOptionPane.showMessageDialog(null, "Error D-01! A problem was detected during occupation insertion.");
            Logger.getLogger(professionalFrame.class.getName()).log(Level.SEVERE, null, SQLError);
        }
    }
}
