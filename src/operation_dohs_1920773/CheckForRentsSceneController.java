/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class CheckForRentsSceneController implements Initializable {

    @FXML
    private TableView<Rent> checkRentTableView;
    @FXML
    private TableColumn<Rent, String> tenantNameColumn;
    @FXML
    private TableColumn<Rent, String> buildingNoColumn;
    @FXML
    private TableColumn<Rent, String> flatNoColumn;
    @FXML
    private TableColumn<Rent, String> transactionIdColumn;
    @FXML
    private TableColumn<Rent, String> amountPaidColumn;
    @FXML
    private TableColumn<Rent, String> paymentProcessColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tenantNameColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("tenantName"));
        buildingNoColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("buildingNo"));
        flatNoColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("flatNo"));
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("TransactId"));
        amountPaidColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("amount"));
        paymentProcessColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("paymentProcess"));

        File file = new File("RentObjects.bin");
        ObjectInputStream ois = null;
        Rent tx = null;
        try {
            if (!file.exists()) {
                System.out.println("Rent objects file doesn't exist.");
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                tx = (Rent)ois.readObject();
                System.out.println(tx.getTransactId());
                checkRentTableView.getItems().add(tx);
            }

        } catch (Exception ex) {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
            }
        }
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserLandlordScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }



    @FXML
    private void viewDetailButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("payRentDetails.fxml"));
        Parent viewRentDetail = loader.load();
        
        Scene rentDetailScene = new Scene(viewRentDetail);
        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Rent Details Page");
        newWindow.setScene(rentDetailScene);
        newWindow.show();

        PayRentDetailsController controller = loader.getController();
        controller.initData(checkRentTableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    }
    
    @FXML
    private void deletePostButtonOnClick(ActionEvent event) {
        ObservableList<Rent> selectedRows, allElement;
        allElement = checkRentTableView.getItems();
        selectedRows = checkRentTableView.getSelectionModel().getSelectedItems();
        
        for(Rent r: selectedRows){
            allElement.remove(r);
        }
    }

    @FXML
    private void saveRentDetailsTXTButtonOnClick(ActionEvent event) {
        ObservableList<Rent> selectedRows, allElement;
        allElement = checkRentTableView.getItems();
        selectedRows = checkRentTableView.getSelectionModel().getSelectedItems();
            try {
                File f = new File("Rent Details.txt");
                FileWriter fw;
                if(f.exists())
                    fw = new FileWriter(f,true);
                else 
                    fw = new FileWriter(f);
                String str="";
                for(Rent s: selectedRows){
                    str += "\n"+"Tenant Name: " + s.getTenantName()+"\n"
                            +"Building No: "+s.getBuildingNo()+"\n"
                            +"Flat No: "+s.getFlatNo()+"\n"
                            +"Transaction Id: "+s.getTransactId()+"\n"
                            +"Amount Paid: "+s.getAmount()+"\n"
                            +"Payment Method: "+s.getPaymentProcess()+"\n";
                }
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
            }
    }
}
