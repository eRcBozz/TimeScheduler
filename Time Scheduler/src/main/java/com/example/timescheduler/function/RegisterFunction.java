package com.example.timescheduler.function;

import com.example.timescheduler.MainApp;
import com.example.timescheduler.RegisterController;
import com.example.timescheduler.database.DatabaseFunction;
import org.apache.commons.validator.EmailValidator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.timescheduler.MainApp.connectNow;

public class RegisterFunction extends RegisterController {

    /**
     * Open the Check Methods
     */
    public void checkValidating() throws Exception {
        checkUsername();
        checkPassword();
        checkFirstname();
        checkLastname();
        checkZipcode();
        checkCity();
        checkAdress();
        checkPhonenumber();
        checkEmail(static_email.getText());
        register();
    }

    /**
     * Cheked if the User exist in the Database
     */
    public boolean checkUsername() throws Exception {
        if (static_username.getText().isBlank() == false) {
            DatabaseFunction user = new DatabaseFunction();
            Connection connectDB = connectNow.getConnection();

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(user.checkUser());

            while (queryResult.next()) {
                static_errorUsername.setText("");
                if (queryResult.getInt(1) == 1) {
                    static_errorUsername.setText("Username already exists");

                }else if (static_username.getText().length() > 2 && static_username.getText().length() < 10) {
                    static_errorUsername.setText("");
                    return true;
                } else {
                    static_errorUsername.setText("Username must be between 3 and 9 characters");
                    return false;
                }
            }
        }
        else {
            static_errorUsername.setText("Please enter a Username");
            return false;
        }
        return false;
    }

    /**
     * Check the Password is it over 7 digits and the password matches
     */
    public boolean checkPassword() {
        if(static_password.getText().length() > 7) {
            static_password.setStyle("-fx-text-fill: black;");
            static_confirmpassword.setStyle("-fx-text-fill: black;");
            static_errorPassword.setText("");
            if(static_password.getText().equals(static_confirmpassword.getText())) {
                static_password.setStyle("-fx-text-fill: black;");
                static_confirmpassword.setStyle("-fx-text-fill: black;");
                static_errorPassword.setText("");
                return true;
            }
            else {
                static_password.setStyle("-fx-text-fill: red;");
                static_confirmpassword.setStyle("-fx-text-fill: red;");
                static_errorPassword.setText("Password does not match");
                return false;
            }
        }
        else {
            static_password.setStyle("-fx-text-fill: red;");
            static_confirmpassword.setStyle("-fx-text-fill: red;");
            static_errorPassword.setText("Password too short");
            return false;
        }
    }

    /**
     * Cheked firstname that is not blank
     */
    public boolean checkFirstname() {
        if(static_firstname.getText().isBlank() == false) {
            static_errorFirstname.setText("");
            return true;
        }
        else {
            static_errorFirstname.setText("Please enter a Firstname");
            return false;
        }
    }

    /**
     * Cheked lastname that is not blank
     */
    public boolean checkLastname() {
        if(static_lastname.getText().isBlank() == false) {
            static_errorLastname.setText("");
            return true;
        }
        else {
            static_errorLastname.setText("Please enter a Lastname");
            return false;
        }
    }

    /**
     * Checked that the Zipcode is exactly 5 digits
     */
    public boolean checkZipcode() {
        if(static_zipcode.getText().length() == 5) {
            static_errorZipcode.setText("");
            return true;
        }
        else {
            static_errorZipcode.setText("Invalid format");
            return false;
        }
    }

    /**
     * Checked city that is not blank
     */
    public boolean checkCity() {
        if(static_city.getText().isBlank() == false) {
            static_errorCity.setText("");
            return true;
        }
        else {
            static_errorCity.setText("Please enter a City");
            return false;
        }
    }

    /**
     * Checked adress that is not blank
     */
    public boolean checkAdress() {
        if(static_adress.getText().isBlank() == false) {
            static_errorAdress.setText("");
            return true;
        }
        else {
            static_errorAdress.setText("Please enter a Adress");
            return false;
        }
    }

    /**
     * Checked Phonenumber with the exactly format
     */
    public boolean checkPhonenumber() {
        if(static_phonenumber.getText().matches("[+]{1}[4]{1}[9]{1}[1]{1}[0-9]{9}")) {
            static_errorPhonenumber.setText("");
            return true;
        }
        else {
            static_errorPhonenumber.setText("Invalid format");
            return false;
        }
    }

    /**
     * Checked Email with the exactly format
     */
    public boolean checkEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();

        if(validator.isValid(email)){
            static_errorEmail.setText("");
            return true;
        }
        else {
            static_errorEmail.setText("Invalid format");
            return false;
        }
    }

    /**
     * If all the Check methods return a true value, create a new user in the Database
     */
    public void register() throws Exception {
        if (checkUsername() == true && checkPassword() == true && checkFirstname() == true && checkLastname() == true && checkZipcode() == true && checkCity() == true &&
                checkAdress() == true && checkPhonenumber() == true && checkEmail(static_email.getText()) == true) {
            Connection connectDB = connectNow.getConnection();
            DatabaseFunction user = new DatabaseFunction();
            MainApp window = new MainApp();

            Statement statement = connectDB.createStatement();
            statement.execute(user.insert());
            window.newScene("Register-info.fxml");
        }
    }
}