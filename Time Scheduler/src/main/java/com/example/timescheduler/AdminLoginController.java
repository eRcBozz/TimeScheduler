package com.example.timescheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {

    @FXML
    Button logoutButton, exitButton;

    public void logoutButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));

        Stage window = (Stage) logoutButton.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }
}
