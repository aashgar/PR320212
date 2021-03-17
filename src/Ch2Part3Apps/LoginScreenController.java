/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch2Part3Apps;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField textFieldLoginName;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label labelError;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonSubmit(ActionEvent event) {
        
        if (textFieldLoginName.getText().equals("aashgar")
                && passwordField.getText().equals("123456"))
            labelError.setText("Valid User");
        else
            labelError.setText("Invalid User");
    }

    @FXML
    private void handleButtonCancel(ActionEvent event) {
    }
    
}
