package com.example.timescheduler.database;

import static com.example.timescheduler.LoginController.*;
import static com.example.timescheduler.RegisterController.*;

public class DatabaseFunction {

    /**
     * SQL Commands
     */
    public String loginVerify() {
        String verifyLogin = "SELECT count(1) FROM account WHERE username = '" + static_usernameLogin.getText() +
                "' AND password = '" + static_passwordLogin.getText() + "'";
        return verifyLogin;
    }

    public String roleVerify() {
        String role = "SELECT count(1) FROM account WHERE username = '" + static_usernameLogin.getText() +
                "' AND role = 'Admin'";
        return role;
    }

    public String checkUser() {
        String user = "SELECT count(1) FROM account WHERE username = '" + static_username.getText() + "'";
        return user;
    }

    public String insert(){
        String register = "INSERT INTO account (username, password, firstname, lastname, zipcode, city, adress, email, phonenumber) values ('" +
                static_username.getText() + "','" + static_password.getText() + "','" + static_firstname.getText() + "','" + static_lastname.getText() + "'," + static_zipcode.getText() + ",'" +
                static_city.getText() + "','" + static_adress.getText() + "','" + static_email.getText() + "'," + static_phonenumber.getText() + ")";
        return register;
    }
}
