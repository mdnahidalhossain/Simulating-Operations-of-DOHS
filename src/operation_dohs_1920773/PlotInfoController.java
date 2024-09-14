package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PlotInfoController implements Initializable {

    @FXML
    private TextField plotnumText;
    @FXML
    private TextField Roadnofx;
    @FXML
    private TextField Areafx;
    
    
    @FXML
    private TableView<plot> Tableview;
    @FXML
    private TableColumn<plot, String> RoadNoColumn;
    @FXML
    private TableColumn<plot, String> PlotNoColumn;
    @FXML
    private TableColumn<plot, String> AreaColumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        RoadNoColumn.setCellValueFactory(new PropertyValueFactory<plot,String>("RoadNo"));
        PlotNoColumn.setCellValueFactory(new PropertyValueFactory<plot,String>("Plotno"));
        AreaColumn.setCellValueFactory(new PropertyValueFactory<plot,String>("Area"));
        
        
        Tableview.setItems(getPlot());
        
        Tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        // TODO
    }    

    @FXML
    private void AddPlotButtonClick(ActionEvent event) {
         plot newplot = new plot(plotnumText.getText(),
                Roadnofx.getText(),
                Areafx.getText()
                
        );

        Tableview.getItems().add(newplot);   
    }
    
    
    public ObservableList<plot> getPlot(){
        ObservableList<plot> plotinfo = FXCollections.observableArrayList();
        
        plotinfo.add(new plot("12C", "11B", "12SQ"));
       
        return plotinfo;
    }
    

    @FXML
    private void DeletePlotButtonClick(ActionEvent event) {
    }

    @FXML
    private void goBackButtonOnCLick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("comitteMember.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    
}
