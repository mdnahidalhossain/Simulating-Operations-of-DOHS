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
public class Request implements Serializable {
    private String buildingNo, floor, flatNo, name, query;

    public Request(String buildingNo, String floor, String flatNo, String name, String query) {
        this.buildingNo = buildingNo;
        this.floor = floor;
        this.flatNo = flatNo;
        this.name = name;
        this.query = query;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getFloor() {
        return floor;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getName() {
        return name;
    }

    public String getQuery() {
        return query;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void createObjectfile(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Request" + "Objects.bin");
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
 
}
