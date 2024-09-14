/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class UserLandlordSceneController implements Initializable {

    //private ComboBox<String> apartmentComboBox;
//    @FXML
//    private Menu apartmentBar;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu apartmentBar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //apartmentComboBox.getItems().add("Post For Rent");
    }
    
//    public ObservableList<String> getPeople(){
//        ObservableList<String> list = FXCollections.observableArrayList();
//        return null;
//        
//    }


    @FXML
    private void postForNewApartmentButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("postForRentScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void checkForRentsBottunOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("checkForRentsScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void requestForRenovationButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("requestForRenovationScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void postForEmergencyButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("postForEmergencyScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void contactSecurityBottonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("contactSecurityScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void checkForMeetingButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("checkForMeetingScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void tenantRequestButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("tenantComplaintScene.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)menuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("logInScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
