package systemFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginFrame extends JPanel {

    JLabel userLabel;
    JTextField userField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JButton loginButton;

    public loginFrame() {
        createComponents();
        createEvents();
    }

    private void createComponents() {
        setLayout(null);

        JLabel titleLabel = new JLabel("Welcome to Triple S - Supermarket Smart System", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 16));

        userLabel = new JLabel("User", JLabel.LEFT);
        userField = new JTextField();
        passwordLabel = new JLabel("Password", JLabel.LEFT);
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        titleLabel.setBounds(20, 100, 660, 40);
        userLabel.setBounds(250, 220, 200, 20);
        userField.setBounds(250, 240, 200, 40);
        passwordLabel.setBounds(250, 280, 200, 20);
        passwordField.setBounds(250, 300, 200, 40);
        loginButton.setBounds(250, 350, 200, 40);

        add(titleLabel);
        add(userLabel);
        add(userField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        setVisible(true);
    }

    private void createEvents() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action01) {

            }
        });
    }
}
