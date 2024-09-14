/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class ApartmentViewDetailSceneController implements Initializable {

    @FXML
    private Label addressLabel;
    @FXML
    private Label buildingNoLabel;
    @FXML
    private Label flatNoLabel;
    @FXML
    private Label apartmentDetailLabel;
    @FXML
    private Label rentalCostLabel;
    @FXML
    private Label phoneNoLabel;
    
    private Apartment selectedRow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void initData(Apartment a) {
        selectedRow = a;
        addressLabel.setText(a.getAddress());
        buildingNoLabel.setText(a.getBuildingNo());
        flatNoLabel.setText(a.getFlatNo());
        apartmentDetailLabel.setText(a.getApartmentDetail());
        phoneNoLabel.setText(a.getPhoneNo());
    }
    
}
