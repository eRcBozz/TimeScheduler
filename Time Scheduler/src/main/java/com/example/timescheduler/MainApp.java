package com.example.timescheduler;

import com.example.timescheduler.database.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static Stage stg;
    public static DatabaseConnection connectNow = new DatabaseConnection();

    /**
     * Main Class for the Application
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("Time Scheduler EMEF");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Function to change the Scene
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    /**
     * Function to open a new Scene
     */
    public void newScene(String fxml) throws IOException {
        Stage stage = new Stage();
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle("Successfully");
        stage.setScene(new Scene(pane,260,100));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}