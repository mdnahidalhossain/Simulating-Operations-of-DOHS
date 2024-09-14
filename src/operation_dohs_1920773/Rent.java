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
import javafx.scene.control.Alert;
import operation_dohs_1920773.components.AppendableObjectOutputStream;


/**
 *
 * @author nahid
 */
public class Rent implements Serializable {
    private String tenantName, buildingNo, flatNo, transactionId, amount, paymentProcess;

    public Rent(String tenantName, String buildingNo, String flatNo, String transactionId, String amount, String paymentProcess) {
        this.tenantName = tenantName;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentProcess = paymentProcess;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getTransactId() {
        return transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentProcess() {
        return paymentProcess;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setTransactId(String transactId) {
        this.transactionId = transactId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPaymentProcess(String paymentProcess) {
        this.paymentProcess = paymentProcess;
    }
    
    public void createObjectfile(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Rent" + "Objects.bin");
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
