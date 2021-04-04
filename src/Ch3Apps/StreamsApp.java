/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Apps;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class StreamsApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTextArea = FXMLLoader.load(getClass().getResource("TextAreaPane.fxml"));
        Pane paneListView = FXMLLoader.load(getClass().getResource("ListViewPane.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("textArea", paneTextArea);
        mapPanes.put("listView", paneListView);
        Scene scene = new Scene(mapPanes.get("textArea"));
        primaryStage.setTitle("Streams App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
