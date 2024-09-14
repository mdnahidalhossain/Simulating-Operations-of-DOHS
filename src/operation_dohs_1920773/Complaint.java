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
public class Complaint implements Serializable {
    private String complaintTitle, name, buildingNo, flatNo, complaintDetail;

    public Complaint(String complaintTitle, String name, String buildingNo, String flatNo, String complaintDetail) {
        this.complaintTitle = complaintTitle;
        this.name = name;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
        this.complaintDetail = complaintDetail;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public String getName() {
        return name;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
    }
    
    public void createObjectfile(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Complaint" + "Objects.bin");
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
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
            }
        }     
    }
    
//    @Override
//    public String toString(){
//        //return id+","+name+","+cgpa+"\n";
//        //return "Id="+id+"; Name="+name+"; Cgpa="+cgpa;
//        return "ID of "+name+" is ";//+id+" and cgpa is "+cgpa;
//    }
    
    
}
