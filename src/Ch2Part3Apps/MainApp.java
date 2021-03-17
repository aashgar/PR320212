/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch2Part3Apps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class MainApp extends Application{
//     @FXML
//    private TextField textFieldLoginName;
//
//    @FXML
//    private Button buttonCancel;
//
//    @FXML
//    private PasswordField passwordField;
//
//    @FXML
//    private Label labelError;
//
//    @FXML
//    private Button buttonSubmit;
//
//    @FXML
//    void handleButtonSubmit(ActionEvent event) {
//          if(textFieldLoginName.getText().equals("aashgar") && 
//                  passwordField.getText().equals("123456"))
//              labelError.setText("Valid User");
//          else
//              labelError.setText("Invalid User");
//    }
//
//    @FXML
//    void handleButtonCancel(ActionEvent event) {
//
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        //loader.setController(this);
        //FlowPane flowPane = loader.load();
        Parent parent = loader.load();
        
        Scene scene = new Scene(parent);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Creating JavaFX using Scene Builder");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
