module com.example.sceen_switch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sceen_switch to javafx.fxml;
    exports com.example.sceen_switch;
}