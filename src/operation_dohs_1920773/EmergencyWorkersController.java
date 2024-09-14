/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import static javafx.scene.web.WebEvent.ALERT;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author T.Farhan
 */
public class EmergencyWorkersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private EmergencyWorkers ew;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton femaleRadioButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashBoardButtonOnClick(ActionEvent event) throws IOException {
        Parent mainpage = FXMLLoader.load(getClass().getResource("securityDashboard.fxml"));
        Scene mainScene = new Scene(mainpage);
        
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        st.setScene(mainScene);
        st.show();
    }

    @FXML
    private void addWorkerButtonOnClick(ActionEvent event) throws IOException {
        
        EmergencyWorkers ew = new EmergencyWorkers(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                (maleRadioButton.isSelected()?"Male":"Female"),    
                phoneNumberTextField.getText()
        );
        File file = new File("emergencyWorkers.bin");
        ObjectOutputStream oos = null;
        
        try{
            if(file.exists()){
                FileOutputStream fos = new FileOutputStream("emergencyWorkers.bin",true);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(ew);
                oos.close();
            }
            else{
                FileOutputStream fos = new FileOutputStream("emergencyWorkers.bin");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(ew);
                oos.close();
            }
        }
        catch(Exception e){
        }
    }
    
}
