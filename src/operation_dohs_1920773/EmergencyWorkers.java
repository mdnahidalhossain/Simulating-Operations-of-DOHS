/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

/**
 *
 * @author T.Farhan
 */
public class EmergencyWorkers {
    private String firstName;
    private String lasstName;
    private String gender;
    private String phoneNumber;

    public EmergencyWorkers(String firstName, String lasstName, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    EmergencyWorkers(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasstName() {
        return lasstName;
    }

    public void setLasstName(String lasstName) {
        this.lasstName = lasstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "EmergencyWorkers{" + "firstName=" + firstName + ", lasstName=" + lasstName + ", gender=" + gender + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
