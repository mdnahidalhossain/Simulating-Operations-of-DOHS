package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MeetingController implements Initializable {

    @FXML
    private ComboBox<String> MtypeComBox;
    @FXML
    private TextField locationTx;
    @FXML
    private TextArea outputtx;
    @FXML
    private TextField RoomTx;
    @FXML
    private TextField timeTx;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MtypeComBox.getItems().addAll("Committe meeting","All Department Meeting"," Manager Meeting");
        MtypeComBox.setValue("Select");
        // TODO
    }    

    @FXML
    private void SubmitButtonOnClick(ActionEvent event) {
        client cl = new client(RoomTx.getText(),locationTx.getText(), (String) MtypeComBox.getValue() );
        
        
        String outputl ="\t\t\t Meeting"+"\nRoom = "+cl.getFirst_name() + "\nLocation =" + cl.getContact() + "\nMeeting type = " + cl.getCombobox() + "\nDate: " + date.getValue();
        outputtx.setText(outputl);
        
    }

    @FXML
    private void BackButtonOnClick(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("comitteMember.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Meeting");
        window.setScene(scene);
        window.show();
        
    }
    
}
