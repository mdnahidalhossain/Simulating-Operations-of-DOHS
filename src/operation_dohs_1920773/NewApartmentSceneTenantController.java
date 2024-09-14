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
public class NewApartmentSceneTenantController implements Initializable {

    @FXML
    private TableView<Apartment> newApartmentTableView;
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
    private TableColumn<Apartment, String> phoneNoColumn;

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
        phoneNoColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("PhoneNo"));
        
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
                newApartmentTableView.getItems().add(tx);
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
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserTenantScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("apartmentViewDetailScene.fxml"));
        Parent viewApartmentDetail = loader.load();
        
        Scene apartmentDetailScene = new Scene(viewApartmentDetail);
        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Apartment Details Page");
        newWindow.setScene(apartmentDetailScene);
        newWindow.show();

        ApartmentViewDetailSceneController controller = loader.getController();
        controller.initData(newApartmentTableView.getSelectionModel().getSelectedItem());
  
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private void saveDetailsTXTButtonOnClick(ActionEvent event) {
        ObservableList<Apartment> selectedRows, allElement;
        allElement = newApartmentTableView.getItems();
        selectedRows = newApartmentTableView.getSelectionModel().getSelectedItems();
            try {
                File f = new File("Apartment Details.txt");
                FileWriter fw;
                if(f.exists())
                    fw = new FileWriter(f,true);
                else 
                    fw = new FileWriter(f);
                String str="";
                for(Apartment s: selectedRows){
                    str += "\n"+"Complaint Title: " + s.getAddress()+"\n"
                            +"Tenant Name: "+s.getBuildingNo()+"\n"
                            +"Building No: "+s.getFlatNo()+"\n"
                            +"Apartment Details: "+s.getApartmentDetail()+"\n"
                            +"Rental Cost: "+s.getRentalCost()+"\n"
                            +"Phone No: "+s.getPhoneNo()+"\n";
                }
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
            }
    }
    
}
