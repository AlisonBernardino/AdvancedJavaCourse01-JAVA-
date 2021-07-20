package courseActivities;
import javax.swing.JFrame;
import javax.swing.JList;

// "Turtle" class
public class l02JList {
    public static void main(String[] args){
        JFrame turtleFrame = new JFrame("Turtle frame");
        turtleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        turtleFrame.setSize(405,305);
        turtleFrame.setLayout(null);
        
        String[] turtles = {"Jaba","Ninja","Leonard","Michel"};
        JList turtlesList = new JList(turtles);
        
        turtlesList.setBounds(55,135,365,75);
        turtleFrame.add(turtlesList);
        turtleFrame.setVisible(true);
    }
}
