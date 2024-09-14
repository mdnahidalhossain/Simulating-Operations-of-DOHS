/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation_dohs_1920773;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
//import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import org.controlsfx.control.Notifications;
//import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
//import javax.management.Notification;

/**
 * FXML Controller class
 *
 * @author nahid
 */
public class PostForRentSceneController implements Initializable {

    @FXML
    private TableView<Apartment> apartmentTableView;
    @FXML
    private TableColumn<Apartment, String> addressColumn;
    @FXML
    private TableColumn<Apartment, String> buildingNoColumn;
    @FXML
    private TableColumn<Apartment, String> flatNoColumn;
    @FXML
    private TableColumn<Apartment, String> apartmentDetailColumn;
    @FXML
    private TableColumn<Apartment, String> rentalCostColumn;
    @FXML
    private TableColumn<Apartment, String> phoneNumberColumn;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField buildingNoTextField;
    @FXML
    private TextField flatNoTextField;
    @FXML
    private TextField apartmentDetailTextField;
    @FXML
    private TextField rentalCostTextField;
    @FXML
    private TextField phoneNoTextField;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        addressColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("Address"));
        buildingNoColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("BuildingNo"));
        flatNoColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("FlatNo"));
        apartmentDetailColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("ApartmentDetail"));
        rentalCostColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("RentalCost"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("PhoneNo"));
        
        File file = new File("ApartmentObjects.bin");
        ObjectInputStream ois = null;
        Apartment tx = null;
        try {
            if (!file.exists()) {
                System.out.println("Apartment objects file doesn't exist.");
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                tx = (Apartment)ois.readObject();
                apartmentTableView.getItems().add(tx);
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
    private void goBackButtonClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserLandlordScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

//    @FXML
//    private void postButtonOnClick(ActionEvent event) {
//        Notifications notify = Notifications.create()
//                .title("Post successfull")
//                //.graphic(new ImageView(img))
//                //.graphic(null);
//                .hideAfter(Duration.seconds(3))
//                .position(Pos.TOP_RIGHT);
//                notify.showConfirm();
//                notify.show();
//        notify.showConfirm();

    @FXML
    private void postButtonOnClick(ActionEvent event) throws IOException {
        Apartment newApart = new Apartment(addressTextField.getText(),
                                 buildingNoTextField.getText(),
                                 flatNoTextField.getText(),
                                 apartmentDetailTextField.getText(),
                                 rentalCostTextField.getText(),
                                 phoneNoTextField.getText()
                                );
        apartmentTableView.getItems().add(newApart);
        newApart.createObjectfile();
        
//        Notifications notify = Notifications.create()
//                .title("Post successfull")
//                //.graphic(new ImageView(img))
//                //.graphic(null);
//                .hideAfter(Duration.ofSeconds(long 3))
//                .position(Pos.TOP_RIGHT);
//                notify.showConfirm();
//                notify.show();
//        notify.showConfirm();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("apartmentViewDetailScene.fxml"));
        Parent viewApartmentDetail = loader.load();
        
        //Parent viewRentDetail = FXMLLoader.load(getClass().getResource("payRentDetails.fxml"));
        Scene apartmentDetailScene = new Scene(viewApartmentDetail);
        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Apartment Details Page");
        newWindow.setScene(apartmentDetailScene);
        newWindow.show();

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        //Scene rentDetailScene = new Scene(viewRentDetail);
        
        //access the controller
        ApartmentViewDetailSceneController controller = loader.getController();
        
        //controller = new PersonViewSceneController();
        controller.initData(apartmentTableView.getSelectionModel().getSelectedItem());
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private void deletePostButtonOnClick(ActionEvent event) {
        ObservableList<Apartment> selectedRows, allElement;
        allElement = apartmentTableView.getItems();
        selectedRows = apartmentTableView.getSelectionModel().getSelectedItems();
        
        for(Apartment r: selectedRows){
            allElement.remove(r);
        }
    }
}
    
