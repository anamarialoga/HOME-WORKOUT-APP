package controller;

import exceptions.NoUsernameGiven;
import exceptions.UsernameOrPasswordIncorrect;
import exceptions.UsernameUsed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.PremiumName;
import service.CustomerLogin;
import service.PremiumNameCheck;
import service.PremiumNameSave;

import java.io.IOException;

public class ControllerPremiumSub {

    @FXML
    private TextField nameField;
    @FXML
    private TextField checkName;
    @FXML
    private  Text messageField;
    @FXML
    private CheckBox agree;



    public void goBackk(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/customerMenu.fxml"));
        Scene root2 = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(root2);
        window.show();
    }

    public void makePayment(ActionEvent event) throws IOException{
        try{
            if(agree.isSelected()==true){
                PremiumNameSave.addPname(nameField.getText());
               messageField.setText("Payment done successfully and data has been registered!");}
            else messageField.setText("You must agree to the terms and conditions!");
        } catch ( NoUsernameGiven | UsernameUsed e) {

            messageField.setText(e.getMessage());
            Alert alert=new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }

    }

    public void goToPremiumWindow(ActionEvent event) {
        try {
            PremiumNameCheck.checkName(checkName.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Great! You are a member", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK)
                alert.close();

            Parent view = FXMLLoader.load(getClass().getClassLoader().getResource("view/PremiumAccepted.fxml"));
            Scene view2 = new Scene(view);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(view2);
            window.show();

        }catch(UsernameOrPasswordIncorrect | IOException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }
}
