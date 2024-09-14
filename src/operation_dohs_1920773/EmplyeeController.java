package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmplyeeController implements Initializable {

    @FXML
    private TextField namefx;
    @FXML
    private TextField idfx;
    @FXML
    private TextField salaryfx;
    @FXML
    private TextField contractfx;
    @FXML
    private DatePicker dobpicker;
    @FXML
    private ComboBox<String> desigfx;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    
    
    @FXML
    private TableView<Emplyee> Tableview;
    @FXML
    private TableColumn<Emplyee, String> nameColumn;
    @FXML
    private TableColumn<Emplyee, String> idcolumn;
    @FXML
    private TableColumn<Emplyee, String> salarycolumn;
    @FXML
    private TableColumn<Emplyee, String> desigcolumn;
    @FXML
    private TableColumn<Emplyee, String> contractcolumn;
    @FXML
    private TableColumn<Emplyee, LocalDate> DOBcolumn;
    
    
    
    ObservableList<Emplyee> people = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        desigfx.getItems().addAll("Admin","Security","Manager");
        
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<Emplyee,String>("Name"));
        idcolumn.setCellValueFactory(new PropertyValueFactory<Emplyee,String>("ID"));
        salarycolumn.setCellValueFactory(new PropertyValueFactory<Emplyee,String>("Salary"));
        desigcolumn.setCellValueFactory(new PropertyValueFactory<Emplyee,String>("Desig"));
        contractcolumn.setCellValueFactory(new PropertyValueFactory<Emplyee,String>("Contract"));
        
        DOBcolumn.setCellValueFactory(new PropertyValueFactory<Emplyee,LocalDate>("Birthday"));
        
        //Tableview.setItems(());
        
       Tableview.setItems(people);
        
       Tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
      
    
        // TODO
    }    

    @FXML
    private void AddEmployeeButtonOnClick(ActionEvent event) {
        
        Emplyee newEmplyee = new Emplyee(namefx.getText(),
                idfx.getText(),
                salaryfx.getText(),
                contractfx.getText(),
                dobpicker.getValue()
        );

        Tableview.getItems().add(newEmplyee);

    }
  

    @FXML
    private void DesicomBoxUPDate(ActionEvent event) {
    }

    @FXML
    private void DeleteEmployeeButtonOnClick(ActionEvent event) {
        ObservableList<Emplyee> selectedRows, allPeople;
        allPeople = Tableview.getItems();
        selectedRows = Tableview.getSelectionModel().getSelectedItems();
        
        for(Emplyee p: selectedRows){
            allPeople.remove(p);
        }
    }

    @FXML
    private void promoteEmployeeButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void desicomboupdate(ActionEvent event) {
    }

    @FXML
    private void SaveAsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void BackButtonOnClick(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("HRscene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Employee");
        window.setScene(scene);
        window.show();
    }
    
}
