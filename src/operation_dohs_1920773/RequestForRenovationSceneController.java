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
//import java.time.LocalDate;
//import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class RequestForRenovationSceneController implements Initializable {

    @FXML
    private TableView<Request> renovationRequestTableView;
    @FXML
    private TextField buildingNoTextField;
    @FXML
    private TextField floorTextField;
    @FXML
    private TextField flatNoTextField;
    @FXML
    private TextField enterNameTextField;
    @FXML
    private TextField queryTextField;
    @FXML
    private TableColumn<Request, String> buildingNoColumn;
    @FXML
    private TableColumn<Request, String> floorColumn;
    @FXML
    private TableColumn<Request, String> flatNoColumn;
    @FXML
    private TableColumn<Request, String> nameColumn;
    @FXML
    private TableColumn<Request, String> queryColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        buildingNoColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("buildingNo"));
        floorColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("floor"));
        flatNoColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("flatNo"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("name"));
        queryColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("query"));
        
        File file = new File("RequestObjects.bin");
        ObjectInputStream ois = null;
        Request tx = null;
        try {
            if (!file.exists()) {
                System.out.println("Request objects file doesn't exist.");
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                tx = (Request)ois.readObject();
                renovationRequestTableView.getItems().add(tx);
            }

        } catch (Exception ex) {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
            }
        }
    }

//    public ObservableList<Request> getPeople(){
//        ObservableList<Request> request = FXCollections.observableArrayList();
//        
//        request.add(new Request("247", "04", "A03", "Hasan", "Electrical issues"));
//  
//        return request;
//    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserLandlordScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitRequestButtonOnClick(ActionEvent event) {
        Request newRequest = new Request(buildingNoTextField.getText(),
                                         floorTextField.getText(),
                                         flatNoTextField.getText(),
                                         enterNameTextField.getText(),
                                         queryTextField.getText()
                                        );
        renovationRequestTableView.getItems().add(newRequest);
        newRequest.createObjectfile();
    }

    @FXML
    private void removeRequestButtonOnClick(ActionEvent event) {
        ObservableList<Request> selectedRows, allRequest;
        allRequest = renovationRequestTableView.getItems();
        selectedRows = renovationRequestTableView.getSelectionModel().getSelectedItems();
        
        for(Request p: selectedRows){
            allRequest.remove(p);
        }
    }
    
}
