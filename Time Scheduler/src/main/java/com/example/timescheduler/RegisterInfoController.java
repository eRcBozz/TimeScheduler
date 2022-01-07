package com.example.timescheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterInfoController {
    @FXML
    private Button okButton;

    /**
     * Event for close the Window/Scene
     */
    public void okButtonOnAction(ActionEvent event) {
        Stage window = (Stage) okButton.getScene().getWindow();
        window.close();
    }
}
