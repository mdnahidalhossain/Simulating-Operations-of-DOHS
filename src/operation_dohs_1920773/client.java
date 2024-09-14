package operation_dohs_1920773;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class client {
    
    private String first_name;
    private String last_name;
    private String father_name;
    private String mather_name;
    private String contact;
    private String nationality;
    private String blood_group;
    private String prasent_address;
    private String parmanent_address;
    private String passport_number;
    private String email;
    private String combobox;
    

    public client() {
    }

   
    public client(String first_name, String last_name, String father_name, String mather_name, String contact, String nationality, String blood_group, String prasent_address, String parmanent_address, String passport_number, String email, String combobox) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.mather_name = mather_name;
        this.contact = contact;
        this.nationality = nationality;
        this.blood_group = blood_group;
        this.prasent_address = prasent_address;
        this.parmanent_address = parmanent_address;
        this.passport_number = passport_number;
        this.email = email;
        this.combobox = combobox;
    }

    public client(String first_name, String contact , String combobox  ) {
        this.first_name = first_name;
        this.contact = contact;
        this.combobox = combobox;
       
    }

    public client(String first_name, String nationality, String blood_group, String passport_number) {
        this.first_name = first_name;
        this.nationality = nationality;
        this.blood_group = blood_group;
        this.passport_number = passport_number;
    }

    client(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMather_name() {
        return mather_name;
    }

    public void setMather_name(String mather_name) {
        this.mather_name = mather_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getPrasent_address() {
        return prasent_address;
    }

    public void setPrasent_address(String prasent_address) {
        this.prasent_address = prasent_address;
    }

    public String getParmanent_address() {
        return parmanent_address;
    }

    public void setParmanent_address(String parmanent_address) {
        this.parmanent_address = parmanent_address;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCombobox() {
        return combobox;
    }

    public void setCombobox(String combobox) {
        this.combobox = combobox;
    }

    @Override
    public String toString() {
        return "\t\t\tApply Successfully" + "\n\nFirst Name=" + first_name + "      \t\tLast Name=" + last_name + "\nFather Name=" + father_name + "   \tMather Name=" + mather_name + "\nContact=" + contact + "        \tNationality=" + nationality + "\nBlood Group=" + blood_group + "\nPrasent Address=" + prasent_address + "   \tParmanent Address=" + parmanent_address + "\nPassport Number=" + passport_number + "   \tEmail=" + email + "\nVisa Type=" + combobox ;
    }

    

}