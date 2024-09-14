/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import operation_dohs_1920773.components.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class TenantComplaintSceneController implements Initializable {

    //private TableView<Complaint> complaintTableView;
    @FXML
    private TableColumn<Complaint, String> complaintTitleColumn;
    @FXML
    private TableColumn<Complaint, String> nameColumn;
    @FXML
    private TableColumn<Complaint, String> buildingNoColumn;
    @FXML
    private TableColumn<Complaint, String> flatNoColumn;
    @FXML
    private TableColumn<Complaint, String> complaintDetailColumn;
    @FXML
    private TableView<Complaint> requestTableView;
    
    private Complaint r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        complaintTitleColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("ComplaintTitle"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("Name"));
        buildingNoColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("BuildingNo"));
        flatNoColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("FlatNo"));
        complaintDetailColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("ComplaintDetail"));
        
        File file = new File("ComplaintObjects.bin");
        ObjectInputStream ois = null;
        Complaint com = null;
        try {
            if (!file.exists()) {
                System.out.println("Complaint objects file doesn't exist.");
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                com = (Complaint)ois.readObject();
                requestTableView.getItems().add(com);
            }

        } catch (Exception ex) {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
            }
        }
    }   
    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserLandlordScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewDetailButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("complaintDetailScene.fxml"));
        Parent viewComplaintDetail = loader.load();

        Scene complaintDetailScene = new Scene(viewComplaintDetail);
        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Request Details Page");
        newWindow.setScene(complaintDetailScene);
        newWindow.show();

        ComplaintDetailSceneController controller = loader.getController();
        controller.initData(requestTableView.getSelectionModel().getSelectedItem());
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private void saveRequestsTxTButtonOnClick(ActionEvent event) throws IOException { 
        ObservableList<Complaint> selectedRows, allElement;
        allElement = requestTableView.getItems();
        selectedRows = requestTableView.getSelectionModel().getSelectedItems();
            try {
                File f = new File("Complaint.txt");
                FileWriter fw;
                
                if(f.exists())
                    fw = new FileWriter(f,true);
                else 
                    fw = new FileWriter(f);
                String str="";
                for(Complaint s: selectedRows){
                    str += "Complaint Title: " + s.getComplaintTitle()+"\n"
                            +"Tenant Name: "+s.getName()+"\n"
                            +"Building No: "+s.getBuildingNo()+"\n"
                            +"Flat No: "+s.getComplaintDetail()+"\n";
                }
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
            }
    }

    @FXML
    private void clearRequestButtonOnClick(ActionEvent event) {
        ObservableList<Complaint> selectedRows, allElement;
        allElement = requestTableView.getItems();
        selectedRows = requestTableView.getSelectionModel().getSelectedItems();
        
        for(Complaint r: selectedRows){
            allElement.remove(r);
        }
    }
    
}
