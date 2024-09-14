/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class FileComplaintSceneTenantController implements Initializable {

    @FXML
    private TableView<Complaint> complaintTableView;
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
    private TextField complaintTitleTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField buildingNoTextField;
    @FXML
    private TextField flatNoTextField;
    @FXML
    private TextField complainDetailTextField;
    

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
                complaintTableView.getItems().add(com);
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
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserTenantScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void postButtonOnClick(ActionEvent event) {
        Complaint newComplaint = new Complaint(complaintTitleTextField.getText(),
                                 nameTextField.getText(),
                                 buildingNoTextField.getText(),
                                 flatNoTextField.getText(),
                                 complainDetailTextField.getText()
                                );
        complaintTableView.getItems().add(newComplaint);
        newComplaint.createObjectfile();
    }

    @FXML
    private void deletePostButtonOnClick(ActionEvent event) {
        ObservableList<Complaint> selectedRows, allElement;
        allElement = complaintTableView.getItems();
        selectedRows = complaintTableView.getSelectionModel().getSelectedItems();
        
        for(Complaint r: selectedRows){
            allElement.remove(r);
        }
    }
    
}
