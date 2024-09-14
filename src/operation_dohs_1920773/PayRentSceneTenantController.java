/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author nahid
 */
public class PayRentSceneTenantController implements Initializable {

    @FXML
    private TableView<Rent> payRentTableView;
    @FXML
    private TableColumn<Rent, String> tenantNameColumn;
    @FXML
    private TableColumn<Rent, String> buildingNoColumn;
    @FXML
    private TableColumn<Rent, String> flatNoColumn;
    @FXML
    private TableColumn<Rent, String> transactionIdColumn;
    @FXML
    private TableColumn<Rent, String> amountColumn;
    @FXML
    private TableColumn<Rent, String> paymentProcessColumn;
    //private TextField nameTextField;
    @FXML
    private TextField buildingNoTextField;
    @FXML
    private TextField flatNoTextField;
    @FXML
    private TextField transactionIdTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField paymentProcessTextField;
    @FXML
    private TextField tenantNameTextField;
   

    /**
     * Initializes the controller class.
     */
    
//    private void readBinary() throws IOException {
//        ObjectInputStream ois=null;
//         try {
//             Rent r;
//             //FileInputStream fis = new FileInputStream("stud2.bin");
//             //ois = new ObjectInputStream(fis);
//             ois = new ObjectInputStream(new FileInputStream("rentObject.bin"));
//             
//            
//            
//            //int[] arr={1,2,3};
//            //System.out.println(arr[3]);
//            while(true){
//                r = (Rent) ois.readObject();
//                payRentTableView.getItems().add(r);
//                //studArr.add((Student) ois.readObject());
//                //payRentTableView.appendText(r.toString()+"\n");
//                //outputTxtArea.appendText(s+"\n");
//            }
//            //ois.close();
//                       
//        } catch (Exception ex) {
//            try {
//                if(ois!=null)
//                    ois.close();
//            } catch (IOException ex1) {  }           
//        }
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tenantNameColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("tenantName"));
        buildingNoColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("buildingNo"));
        flatNoColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("flatNo"));
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("TransactId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("amount"));
        paymentProcessColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("paymentProcess"));

        File file = new File("RentObjects.bin");
        ObjectInputStream ois = null;
        Rent tx = null;
        try {
            if (!file.exists()) {
                System.out.println("Rent objects file doesn't exist.");
                // return;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                tx = (Rent)ois.readObject();
                payRentTableView.getItems().add(tx);
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
    private void postButtonOnClick(ActionEvent event) throws IOException {
        Rent newRent = new Rent(tenantNameTextField.getText(),
                                 buildingNoTextField.getText(),
                                 flatNoTextField.getText(),
                                 transactionIdTextField.getText(),
                                 amountTextField.getText(),
                                 paymentProcessTextField.getText()
                                );
        payRentTableView.getItems().add(newRent);
        newRent.createObjectfile();

    }
    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserTenantScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

//    private void viewDetailButtonOnClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("payRentDetails.fxml"));
//        Parent viewRentDetail = loader.load();
//        
//        //Parent viewRentDetail = FXMLLoader.load(getClass().getResource("payRentDetails.fxml"));
//        Scene rentDetailScene = new Scene(viewRentDetail);
//        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Stage newWindow  = new Stage();
//        
//        newWindow.setTitle("Rent Details Page");
//        newWindow.setScene(rentDetailScene);
//        newWindow.show();
//
//        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
//        //Scene rentDetailScene = new Scene(viewRentDetail);
//        
//        //access the controller
//        PayRentDetailsController controller = loader.getController();
//        
//        //controller = new PersonViewSceneController();
//        controller.initData(payRentTableView.getSelectionModel().getSelectedItem());
//        
//        
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        
////        window.setScene(rentDetailScene);
////        window.show();
//    }

    @FXML
    private void deletePostButtonOnClick(ActionEvent event) {
        ObservableList<Rent> selectedRows, allElement;
        allElement = payRentTableView.getItems();
        selectedRows = payRentTableView.getSelectionModel().getSelectedItems();
        
        for(Rent r: selectedRows){
            allElement.remove(r);
        }
    }

    
    
}
