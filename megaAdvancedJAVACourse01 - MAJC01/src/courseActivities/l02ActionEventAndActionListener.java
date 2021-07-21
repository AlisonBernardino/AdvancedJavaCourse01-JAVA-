package courseActivities;
// New imports = "ActionEvent" and "ActionListener" from "AWT"

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// "Joystick" class
public class l02ActionEventAndActionListener {

    public static void main(String[] args) {
        JFrame joystickFrame = new JFrame("Joystick frame");
        joystickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        joystickFrame.setSize(420, 320);
        joystickFrame.setLayout(null);

        JButton joystickButton = new JButton("Joystick button");
        joystickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pushButton) {
                JOptionPane.showMessageDialog(null, "Button pushed!");
            }
        });
        joystickButton.setBounds(25,135,365,45);
        joystickFrame.add(joystickButton);
        joystickFrame.setVisible(true);
    }
}
