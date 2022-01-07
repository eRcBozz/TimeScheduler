module com.example.timescheduler.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires commons.validator;
    requires java.desktop;


    opens com.example.timescheduler to javafx.fxml;
    exports com.example.timescheduler;
    exports com.example.timescheduler.database;
    opens com.example.timescheduler.database to javafx.fxml;
    exports com.example.timescheduler.function;
    opens com.example.timescheduler.function to javafx.fxml;
}