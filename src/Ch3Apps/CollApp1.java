/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Apps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class CollApp1 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] arr = {"Ahmad", "Basma", "Maher", "Sami", "Ahmad"};
        List<String> listNames = new ArrayList<>(
                Arrays.asList(arr)
        );
        Collections.sort(listNames);
        Set<String> setNames = new HashSet<>(
                Arrays.asList(arr)
        );
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(setNames);
        VBox vBox = new VBox(listView);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        Scene scene = new Scene(vBox, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Collection App");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
