package courseActivities;
import java.io.File;
import javax.swing.JFileChooser;

// "Courier" class
public class l02JFileChooser {
    public static void main(String[] args){
        JFileChooser courierFileChooser = new JFileChooser();
        int answer = courierFileChooser.showOpenDialog(null);
        if(answer == JFileChooser.APPROVE_OPTION){
            File file01 = courierFileChooser.getSelectedFile();
            System.out.println(file01.toString());
        }else{
            System.out.println("No file chosen. Please, select a file.");
        }
    }
}
