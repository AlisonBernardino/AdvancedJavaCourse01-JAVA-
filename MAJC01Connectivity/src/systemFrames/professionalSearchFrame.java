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
import systemFiles.databaseConfiguration;
import systemParts.Professional;

public class professionalSearchFrame extends JPanel {

    professionalName registeredProfessionalName;
    JLabel titleLabel, professionalNameLabel;
    JTextField professionalNameField;
    JButton searchButton, editButton, deleteButton;
    DefaultListModel<professionalName> professionalNameListModel = new DefaultListModel();
    JList<professionalName> professionalNameList;

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
        professionalNameListModel = new DefaultListModel();
        professionalNameList = new JList();
        professionalNameList.setModel(professionalNameListModel);
        professionalNameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_sELECTION);

        titleLabel.setBounds(21, 21, 661, 41);
        professionalNameLabel.setBounds(151, 121, 401, 21);
        professionalNameField.setBounds(151, 141, 401, 41);
        searchButton.setBounds(561, 141, 131, 41);
        professionalNameList.setBounds(151, 201, 401, 241);
        editButton.setBounds(561, 361, 131, 41);
        deleteButton.setBounds(561, 401, 131, 41);
        add(titleLabel);
        add(professionalNameLabel);
        add(professionalNameField);
        add(professionalNameList);
        add(searchButton);
        add(editButton);
        add(deleteButton);

        setVisible(true);
    }

    private void createEvents() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event01) {
                SQLProfessionalNameSearch(professionalNameField.getText());
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event01){
                
            }
        });
        deleteButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent event01){
               SQLDeleteProfessionalName();
           }
        });
    }
}
