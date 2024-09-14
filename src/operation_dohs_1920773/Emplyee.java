package operation_dohs_1920773;



import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public class Emplyee implements Serializable {
    private String Name, ID, salary,contract;
    private LocalDate birthday;

    public Emplyee(String Name, String ID, String salary, String contract, LocalDate birthday) {
        this.Name = Name;
        this.ID = ID;
        this.salary = salary;
        this.contract = contract;
        this.birthday = birthday;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    
    
    
    
}