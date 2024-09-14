package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class WorkTimeController implements Initializable {

    @FXML
    private ComboBox<String> ChooseComboBox;
    @FXML
    private TableView<WorkingTime> table;
    @FXML
    private TableColumn<WorkingTime, String> NameColumn;
    @FXML
    private TableColumn<WorkingTime, String> idcolumn;
    @FXML
    private TableColumn<WorkingTime, String> timecolumn;
    @FXML
    private TableColumn<WorkingTime, String> zoneColumn;

    
    
    ObservableList <WorkingTime>AllWorkingTime = FXCollections.observableArrayList();
    WorkingTime pp = new WorkingTime();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         NameColumn.setCellValueFactory(new PropertyValueFactory<WorkingTime, String>("Name"));
         idcolumn.setCellValueFactory(new PropertyValueFactory<WorkingTime, String>("Id"));
         timecolumn.setCellValueFactory(new PropertyValueFactory<WorkingTime, String>("Time"));
         zoneColumn.setCellValueFactory(new PropertyValueFactory<WorkingTime, String>("Zone"));
         
        
         ChooseComboBox.getItems().addAll("Main Gate","Gate2"
                 );
         ChooseComboBox.setValue("Choose");
        // TODO
    } 
    
    

    @FXML
    private void BackButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HRscene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("HRScene");
        window.setScene(scene);
        window.show();
    }
    

    @FXML
    private void EnterButtonOnClick(ActionEvent event) throws IOException {
        
        table.getItems().clear();
        AllWorkingTime  = pp.sendWorkingTime(ChooseComboBox.getValue().toString());
        table.getItems().addAll(AllWorkingTime);
        //WorkingTime.sendWorkingTime();
    }
    
}
