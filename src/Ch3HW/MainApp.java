/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3HW;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class MainApp extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentScreen.fxml"));
        Parent parent = loader.load();        
        Scene scene = new Scene(parent);        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Processing Screen");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
