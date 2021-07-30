package systemParts;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class Manager {
    int managerID;
    String managerFirstName;
    String managerLastName;
    String managerEmail;
    JFormattedTextField managerBornDate;
    JComboBox managerOccupation;
    double managerSalary;

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public JFormattedTextField getManagerBornDate() {
        return managerBornDate;
    }

    public void setManagerBornDate(JFormattedTextField managerBornDate) {
        this.managerBornDate = managerBornDate;
    }

    public JComboBox getManagerOccupation() {
        return managerOccupation;
    }

    public void setManagerOccupation(JComboBox managerOccupation) {
        this.managerOccupation = managerOccupation;
    }

    public double getManagerSalary() {
        return managerSalary;
    }

    public void setManagerSalary(double managerSalary) {
        this.managerSalary = managerSalary;
    } 
}
