/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3HW;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class StudentScreenController implements Initializable {

    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldMajor;
    @FXML
    private TextField textFieldGrade;
    @FXML
    private ListView<String> listViewStudents;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonClear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // This is just a intitial data
        listViewStudents.getItems()
                .add(String.format("%-5s %-10s %-7s %8.2f", "111", "Ahmad", "CS", 93.2));
        listViewStudents.getItems()
                .add(String.format("%-5s %-10s %-7s %8.2f","123", "Marwa", "EDUC", 87.9));
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
    }


    @FXML
    private void buttonClearHandle(ActionEvent event) {
    }
    
}
