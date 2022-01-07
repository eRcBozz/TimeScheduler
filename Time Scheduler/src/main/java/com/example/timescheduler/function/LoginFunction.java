package com.example.timescheduler.function;

import com.example.timescheduler.LoginController;
import com.example.timescheduler.MainApp;
import com.example.timescheduler.database.DatabaseFunction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.timescheduler.MainApp.connectNow;

public class LoginFunction extends LoginController {

    /**
     * Checks if the TextField is blank or not
     */
    public void checkValidate() throws Exception {
        if(static_usernameLogin.getText().isBlank() == false && static_passwordLogin.getText().isBlank() == false) {
            validateLogin();
        } else {
            static_loginMessageLabel.setText("Please enter username and password");
        }
    }

    /**
     * Checks if the User exist and as Admin role or Normal User
     */
    public void validateLogin() throws Exception {
        MainApp window = new MainApp();
        DatabaseFunction verify = new DatabaseFunction();
        Connection connectDB = connectNow.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verify.loginVerify());

            Statement statement1 = connectDB.createStatement();
            ResultSet queryResult1 = statement1.executeQuery(verify.roleVerify());

            while (queryResult.next() && queryResult1.next()) { //next() ?????
                if(queryResult.getInt(1) == 1 && queryResult1.getInt(1) == 1) {
                    window.changeScene("AdminLogin-view.fxml");
                } else if(queryResult.getInt(1) == 1) {
                    window.changeScene("UserLogin-view.fxml");
                }
                else {
                    static_loginMessageLabel.setText("Wrong username or password");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
