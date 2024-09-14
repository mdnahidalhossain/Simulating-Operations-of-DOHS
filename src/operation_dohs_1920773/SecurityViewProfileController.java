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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author T.Farhan
 */
public class SecurityViewProfileController implements Initializable {

    @FXML
    private Label idTextField;
    @FXML
    private Label addressTextField;
    @FXML
    private Label salaryTextField;
    @FXML
    private Label nameTextField;
    @FXML
    private Label mailTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idTextField.setText("3030037");
        addressTextField.setText("SND");
        salaryTextField.setText("0.00");
        nameTextField.setText("Farhan Tanvir");
        mailTextField.setText("3030037@iub.edu.bd");
        // TODO
    }    

    @FXML
    private void DashBoardButtinOnClick(ActionEvent event) throws IOException {
        Parent mainpage = FXMLLoader.load(getClass().getResource("securityDashboard.fxml"));
        Scene mainScene = new Scene(mainpage);
        
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        st.setScene(mainScene);
        st.show();
    }
    
}
