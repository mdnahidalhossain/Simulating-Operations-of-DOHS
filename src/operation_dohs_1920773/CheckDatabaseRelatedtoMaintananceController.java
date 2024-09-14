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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abrarul Karim Adib
 */
public class CheckDatabaseRelatedtoMaintananceController implements Initializable {

    @FXML
    private TextArea DatabaseTextArea;
    @FXML
    private TextArea ComboboxText;
    @FXML
    private TextArea MakeCorrectionTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DatabaseButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void ComboBoxButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void MakeCorrectionButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MaintananceOfficer.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene);
        window.show();
    }
    
}
