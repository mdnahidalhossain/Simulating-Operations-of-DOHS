/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.Serializable;

/**
 *
 * @author T.Farhan
 */
public class SecurityWorkers implements Serializable{
    
    private String firstName;
    private String lasstName;
    private String gender;
    private String phoneNumber;
    private float salary;

    public SecurityWorkers(String firstName, String lasstName, String gender, String phoneNumber, float salary) {
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public String toString() {
        return "First Name: "+firstName+
                "Last Name: "+lasstName+
                "Gender: "+gender+
                "Phone number: "+phoneNumber;
    }
} 
