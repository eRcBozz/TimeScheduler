package com.example.timescheduler;

import com.example.timescheduler.function.RegisterFunction;
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

public class RegisterController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField usernameTXT, firstnameTXT, lastnameTXT, zipCodeTXT, cityTXT, adressTXT, emailTXT, phonenumberTXT;
    @FXML
    private PasswordField passwordTXT, confirmPasswordTXT;
    @FXML
    private Label errorUsername, errorFirstname, errorLastname, errorPassword, errorZipcode, errorCity, errorAdress, errorEmail, errorPhonenumber;

    /**
     * Create a public static TextField, PasswordField and Label to use it in RegisterFunction
     */
    public static TextField static_username, static_firstname, static_lastname, static_zipcode, static_city ,static_adress, static_email, static_phonenumber;
    public static PasswordField static_password, static_confirmpassword;
    public static Label static_errorUsername, static_errorFirstname, static_errorLastname, static_errorPassword, static_errorZipcode, static_errorCity, static_errorAdress, static_errorEmail, static_errorPhonenumber;

    /**
     * Initialize the private TextField, PasswordField and Label to the public static TextField, PasswordField and Label
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        static_username = usernameTXT;
        static_password = passwordTXT;
        static_confirmpassword = confirmPasswordTXT;
        static_firstname = firstnameTXT;
        static_lastname = lastnameTXT;
        static_zipcode = zipCodeTXT;
        static_city = cityTXT;
        static_adress = adressTXT;
        static_email = emailTXT;
        static_phonenumber = phonenumberTXT;
        static_errorUsername = errorUsername;
        static_errorFirstname = errorFirstname;
        static_errorLastname = errorLastname;
        static_errorPassword = errorPassword;
        static_errorZipcode = errorZipcode;
        static_errorCity = errorCity;
        static_errorAdress = errorAdress;
        static_errorEmail = errorEmail;
        static_errorPhonenumber = errorPhonenumber;
    }

    /**
     * Changes the Window/Scene back to Login-view
     */
    public void backButtonOnAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));

        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }

    /**
     * Open the RegisterFunktion class
     */
    public void registerButtonOnAction(ActionEvent event) throws Exception{
        RegisterFunction user = new RegisterFunction();
        user.checkValidating();
    }
}