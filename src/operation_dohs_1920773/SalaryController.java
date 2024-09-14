package operation_dohs_1920773;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalaryController implements Initializable {

    @FXML
    private TextField Namefx;
    @FXML
    private TextField Amountfx;
    @FXML
    private ComboBox Comboboxpick;
    @FXML
    private TextArea ViewSalary;
    @FXML
    private TextArea GenerateSalaryTXt;
    
    ArrayList<salary>acclist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acclist = new ArrayList<salary>();
        
        
        Comboboxpick.getItems().addAll("OFFICER","STAFF","SECURITY GUARD","CLEANER");
        Comboboxpick.setValue("Select ");
        // TODO
    }    

    @FXML
    private void SubmitButton(ActionEvent event) {
        
        acclist.add(
                new salary(
                        Namefx.getText(),
                        Amountfx.getText()
                )
                
        );
        
        ViewSalary.setText("Emplyoee Name = "+Namefx.getText()+"\nOccupetion ="+Comboboxpick.getValue()+"\nAmmount ="+Amountfx.getText());
        Namefx.clear();
        Amountfx.clear();
    }

    @FXML
    private void ViewSalary(ActionEvent event) {
         String str = "";
        for(salary am: acclist){
            str = str + am.toString();
        }
        GenerateSalaryTXt.setText(str);
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HRscene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Accountant Page");
        window.setScene(scene);
        window.show();
    }
    
}
