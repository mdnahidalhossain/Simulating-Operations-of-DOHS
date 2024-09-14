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
public class ComplaintDetailSceneController implements Initializable {

    @FXML
    private Label complaintTitleLabel;
    @FXML
    private Label tenantNameLabel;
    @FXML
    private Label buildingNoLabel;
    @FXML
    private Label flatNoLabel;
    @FXML
    private Label complaintDetailLabel;
    
    private Complaint selectedRow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public void initData(Complaint r) {
        selectedRow = r;
        complaintTitleLabel.setText(r.getComplaintTitle());
        tenantNameLabel.setText(r.getName());
        buildingNoLabel.setText(r.getBuildingNo());
        flatNoLabel.setText(r.getFlatNo());
        complaintDetailLabel.setText(r.getComplaintDetail());
    }
    
}
