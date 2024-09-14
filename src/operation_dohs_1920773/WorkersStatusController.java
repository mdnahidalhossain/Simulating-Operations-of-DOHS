/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
 * @author T.Farhan
 */
public class WorkersStatusController implements Initializable {

    @FXML
    private TextArea workerstextField;
    @FXML
    private TextArea emergencyWorkerstextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vievWorkers(ActionEvent event) {
    }

    @FXML
    private void vievEmergencyWorkers(ActionEvent event) throws IOException {
        ObjectInputStream ois=null;
        try{
            EmergencyWorkers ew;
            ois = new ObjectInputStream(new FileInputStream("emergencyWorkers.bin"));
            
            emergencyWorkerstextField.setText(null);
             
            while(true){
                ew = (EmergencyWorkers) ois.readObject();
                emergencyWorkerstextField.appendText(ew.toString()+"\n");
                System.out.println(ew.toString());
            }
        }catch(Exception ex){
            try{
                if(ois!=null){
                    ois.close();
                }
            }catch(Exception Ex){
            }
        }

    }

    @FXML
    private void dashBoardOnClick(ActionEvent event) throws IOException {
        Parent mainpage = FXMLLoader.load(getClass().getResource("securityDashboard.fxml"));
        Scene mainScene = new Scene(mainpage);
        
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        st.setScene(mainScene);
        st.show();
    }
    
}
