package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class salary {
    private String name;
    private String ammount;
    
    public salary() {
    }

    public salary(String name, String ammount) {
        this.name = name;
        this.ammount = ammount;
    }
    
    salary(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }
    
    public String toString() {
        return  "Name=" + name + ",\nAmmount=" + ammount +"\n";
    }   
}
