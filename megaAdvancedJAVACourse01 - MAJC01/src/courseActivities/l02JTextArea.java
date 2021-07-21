package courseActivities;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// "Giraffe" frame
public class l02JTextArea {    
    public static void main(String[] args){
        JFrame giraffeFrame = new JFrame("Giraffe frame");
        giraffeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        giraffeFrame.setSize(405,305);
        giraffeFrame.setLayout(null);
        
        JTextArea giraffeTextArea = new JTextArea();
        giraffeTextArea.setBounds(30,140,370,130);
        giraffeFrame.add(giraffeTextArea);
        giraffeFrame.setVisible(true);        
    }
}
