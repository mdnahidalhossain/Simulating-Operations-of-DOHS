package operation_dohs_1920773;


import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class WorkingTime implements Serializable {
    private String name;
    private String id;
    private String Time;
    private String Zone;

    public WorkingTime(String name, String id, String Time, String Zone) {
        this.name = name;
        this.id = id;
        this.Time = Time;
        this.Zone = Zone;
    }
    public WorkingTime(){
        
    }
    
    ObservableList sendWorkingTime(String name) {
         
         ObservableList<WorkingTime> AllWorkingTime = FXCollections.observableArrayList(
                 
                 
                 
         new WorkingTime("MD Josim","2033","8.00AM-4.00PM","DOHS Main Gate"), 
         new WorkingTime("MD ISLAM","1233","4.00pm-11.59pm","DOHS Main Gate"),  
         new WorkingTime("MD Muskam","12421","12.00am-8.00am","DOHS Main Gate"),
         new WorkingTime("Kamal","James bond Island","couple","DOHS Main Gate"),
         
         new WorkingTime("MD Josim","2033","8.00AM-4.00PM","DOHS Main Gate"), 
         new WorkingTime("MD ISLAM","1233","4.00pm-11.59pm","DOHS Main Gate"),  
         new WorkingTime("MD Muskam","12421","12.00am-8.00am","90000"),
         new WorkingTime("Kamal","24587","5.00am-9.00pm","750000")
        
         );
         
         ObservableList<WorkingTime> AllWorkingTime2 = FXCollections.observableArrayList();
         
         for(WorkingTime vr : AllWorkingTime){
             if(vr.name.equals(name)==true){
                 AllWorkingTime2.add(vr);
             }
         }
        
         
         return AllWorkingTime2;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String Zone) {
        this.Zone = Zone;
    }
 
   @Override
    public String toString() {
        return "WorkingTime{" + "name=" + name + ", id=" + id + ", Time=" + Time + ", Zone=" + Zone + '}';
    }
    
    
}
