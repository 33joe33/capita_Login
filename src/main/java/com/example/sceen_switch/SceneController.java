//---------------------------------SceneController.java---------------------------------------
package com.example.sceen_switch;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField NewUsername;
    @FXML
    private TextField NewPassword;
    @FXML
    private TextField CNewPassword;
    @FXML
    private Label error;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
@FXML
private Label NewUserErr;
    @FXML
    protected void onButtonClick() throws InterruptedException {

        int counter = functions_for_auth.counter.get();
        functions_for_auth.counter.inc();
        functions_for_auth.user admin = new functions_for_auth.user("admin", "Password1234");


        String inputName = Username.getText().toLowerCase(Locale.ROOT);
        ;
        String inputPassword = Password.getText();
        System.out.println(inputName);
        boolean correct = admin.name().equals(inputName) && (admin.password().equals(inputPassword));
        String answer = (correct) ? "Correct Password" : "Incorrect Login";
        if (inputName.length()<1) {answer ="please enter a username";
        functions_for_auth.counter.inc_();

        }
        error.setText(answer);
        if (!correct) {
            if (counter >=2) {
                error.setText("you are locked out for " + Integer.toString(counter) + " minutes");
                wait(600000 * counter);
            }
            Username.setText("");
            Password.setText("");
        }
    }

    ;


    public void AddUser(ActionEvent event) throws IOException {
        String NUsername = NewUsername.getText();
        String NPassword =NewPassword.getText();
        String CNPassword=CNewPassword.getText();
        String User =(NUsername.length()<1)?"please enter a username\r\n":"";
        String answer  = (NPassword.matches(".*\\d.*")? "":"Your password needs at least one number\r\n");
        String answer0 =  (NPassword.matches("^.*[^a-zA-Z0-9 ].*$"))? "":"Your password requires at least one non alpha numeric character\r\n";
        String answer1 =(CNPassword.equals(NPassword))? "":"Your Passwords do not match\r\n";
        String answer2 =(NPassword.length()<8)?"your password must be at least 8 characters long\n":"";
        String answer3 =NPassword.equals(NPassword.toLowerCase(Locale.ROOT))? "your password must contain at least one upper case Letter":"";
        String err =User+answer+answer0+answer1+answer2+answer3;
        NewUserErr.setText(err);

        if (err.equals("")) {
            functions_for_auth.user NewUser =new functions_for_auth.user(NUsername,NPassword);


            root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void Register(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

