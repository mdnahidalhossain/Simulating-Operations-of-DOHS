/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation_dohs_1920773;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import operation_dohs_1920773.components.AppendableObjectOutputStream;

/**
 *
 * @author nahid
 */
public class Apartment implements Serializable{
    private String address, buildingNo, flatNo, apartmentDetail, rentalCost, phoneNo;

    public Apartment(String address, String buildingNo, String flatNo, String apartmentDetail, String rentalCost, String phoneNo) {
        this.address = address;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
        this.apartmentDetail = apartmentDetail;
        this.rentalCost = rentalCost;
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getApartmentDetail() {
        return apartmentDetail;
    }

    public String getRentalCost() {
        return rentalCost;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setApartmentDetail(String apartmentDetail) {
        this.apartmentDetail = apartmentDetail;
    }

    public void setRentalCost(String rentalCost) {
        this.rentalCost = rentalCost;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    

    public void createObjectfile(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Apartment" + "Objects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }

            oos.writeObject(this);

        } catch (IOException ex) {
            // Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                // Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }
    
}

