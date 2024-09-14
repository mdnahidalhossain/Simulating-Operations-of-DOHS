package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class CheckDailyUpdatesController implements Initializable {

    @FXML
    private ComboBox<?> ObserveComboBox;
    @FXML
    private TextArea ObservationOutputText;
    @FXML
    private TextArea FeedbackOutputText;
    @FXML
    private TextArea Notification;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ObserveComboBoxOnAction(ActionEvent event) {
    }

    @FXML
    private void FeedbackButtonOnClick(ActionEvent event) {
    }
    
}
