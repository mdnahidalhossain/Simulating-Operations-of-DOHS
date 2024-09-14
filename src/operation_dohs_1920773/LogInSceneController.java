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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class LogInSceneController implements Initializable {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private Label alertLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        
        if(userNameTextField.getText().equals("Landlord") && passwordField.getText().equals("landlord123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("UserLandlordScene.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("Tenant") && passwordField.getText().equals("tenant123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("UserTenantScene.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("Accountant") && passwordField.getText().equals("accountant123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("AccountantDashBoard.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("Security") && passwordField.getText().equals("security123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("securityDashboard.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("DOHS Manager") && passwordField.getText().equals("manager123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("DOHSManagerDashboardScene.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("Maintenance Officer") && passwordField.getText().equals("maintenance123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("MaintananceOfficer.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("HR Manager") && passwordField.getText().equals("hr123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("HRscene.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        else if(userNameTextField.getText().equals("Committee Member") && passwordField.getText().equals("committee123")){
        Parent twoViewParent = FXMLLoader.load(getClass().getResource("comitteMember.fxml"));
        Scene twoViewScene = new Scene(twoViewParent);
        
        Stage two = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        two.setScene(twoViewScene);
        two.show();
        }
        
        
        else{
            alertLabel.setText("Incorrect User Name or Password");
            }
    }
    
}
