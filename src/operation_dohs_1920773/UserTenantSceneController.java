/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class UserTenantSceneController implements Initializable {

    @FXML
    private MenuBar tenantMenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void payRentButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("payRentSceneTenant.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)tenantMenuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void fileComplaintButtonClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("fileComplaintSceneTenant.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)tenantMenuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }

    @FXML
    private void newApartmentButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("newApartmentSceneTenant.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)tenantMenuBar.getScene().getWindow();
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

    @FXML
    private void contactButtonOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("landlordContactSceneTenant.fxml"));
        Scene nextScene = new Scene(p);
        Stage stg = (Stage)tenantMenuBar.getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }
    
}
