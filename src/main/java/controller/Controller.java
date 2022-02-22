package controller;

import exceptions.UsernameOrPasswordIncorrect;
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
import javafx.stage.Stage;
import service.CustomerLogin;
import service.TrainerLogin;

import java.io.IOException;


public class Controller {

    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public void goToReg(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/register-1.fxml"));
        Scene root2 = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(root2);
        window.show();
    }

    public static int ok=0;

    @FXML
    public void loginCustomer(ActionEvent event) throws IOException {
        try {
            CustomerLogin.checkCustomer(usernameField.getText(), passwordField.getText());
            ok=1;

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Logged in successfuly!", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK)
                alert.close();

            Parent view = FXMLLoader.load(getClass().getClassLoader().getResource("view/customerMenu.fxml"));
            Scene view2 = new Scene(view);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(view2);
            window.show();

        }catch(UsernameOrPasswordIncorrect e) {
            Alert alert=new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }


    @FXML
    public void loginTrainer(ActionEvent event) throws IOException{
        try {
            ok=0;
            TrainerLogin.checkTrainer(usernameField.getText(), passwordField.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Logged in successfuly!", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK)
                alert.close();

            Parent view = FXMLLoader.load(getClass().getClassLoader().getResource("view/trainerMenu.fxml"));
            Scene view2 = new Scene(view);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(view2);
            window.show();

        }catch(UsernameOrPasswordIncorrect e) {
            Alert alert=new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }
}
