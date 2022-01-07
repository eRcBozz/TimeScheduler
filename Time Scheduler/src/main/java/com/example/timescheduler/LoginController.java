package com.example.timescheduler;

import com.example.timescheduler.function.LoginFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button exitButton, registerButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label loginMessageLabel;

    /**
     * Create a public static Textfield,PasswordField and Label to use it in LoginFunction
     */
    public static TextField static_usernameLogin;
    public static PasswordField static_passwordLogin;
    public static Label static_loginMessageLabel;

    /**
     * Initialize the private TextField,PasswordField and Label to the public static TextField, PasswordField and Label
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        static_usernameLogin = usernameTextField;
        static_passwordLogin = passwordPasswordField;
        static_loginMessageLabel = loginMessageLabel;
    }

    /**
     * Exit Button close the Window/Scene
     */
    public void exitButtonOnAction(ActionEvent event) {
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }

    /**
     * Register Button changed the Scene to Register-view.fxml
     */
    public void registerButtonOnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Register-view.fxml"));

        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root,600,700));
    }

    /**
     * Login Button open the LoginFuntion class
     */
    public void loginButtonOnAction(ActionEvent event) throws Exception {
        LoginFunction user = new LoginFunction();
        user.checkValidate();
    }
}