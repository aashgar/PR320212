/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class JpaApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane jpaPane = FXMLLoader.load(getClass().getResource("JpaPane.fxml"));
        Scene scene = new Scene(jpaPane);
        primaryStage.setTitle("JPA App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
