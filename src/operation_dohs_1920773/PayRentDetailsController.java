/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import operation_dohs_1920773.Rent;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class PayRentDetailsController implements Initializable {
    
    
    @FXML
    private Label tenantNameLabel;
    @FXML
    private Label buildingNoLabel;
    @FXML
    private Label flatNoLabel;
    @FXML
    private Label transactionIdLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label paymentMethodLabel;
    
    private Rent selectedRow;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initData(Rent r) {
        selectedRow = r;
        tenantNameLabel.setText(r.getTenantName());
        buildingNoLabel.setText(r.getBuildingNo());
        flatNoLabel.setText(r.getFlatNo());
        transactionIdLabel.setText(r.getTransactId());
        amountLabel.setText("$ " + (r.getAmount()));
        paymentMethodLabel.setText(r.getPaymentProcess());
    }
    
}
