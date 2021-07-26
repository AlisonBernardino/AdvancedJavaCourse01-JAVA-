package systemParts;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class Manager {
    String firstName;
    String lastName;
    String email;
    JFormattedTextField bornDate;
    JComboBox occupation;
    double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JFormattedTextField getBornDate() {
        return bornDate;
    }

    public void setBornDate(JFormattedTextField bornDate) {
        this.bornDate = bornDate;
    }

    public JComboBox getOccupation() {
        return occupation;
    }

    public void setOccupation(JComboBox occupation) {
        this.occupation = occupation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
