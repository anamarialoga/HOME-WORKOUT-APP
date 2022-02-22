package controller;

import exceptions.NoPasswordGiven;
import exceptions.NoUsernameGiven;
import exceptions.UsernameUsed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.TrainerReg;

import java.io.IOException;

public class ControllerReg2_2 {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text messageField;

    public void goBackk(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/register-1.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }

    public void registerButton(ActionEvent event) {
        try {

            TrainerReg.addTrainer(usernameField.getText(), passwordField.getText());
            messageField.setText("Account created successfully!");
        } catch (NoPasswordGiven | NoUsernameGiven | UsernameUsed e) {

            messageField.setText(e.getMessage());
            Alert alert=new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }
}
