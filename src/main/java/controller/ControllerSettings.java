package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.text.Text;
import java.io.IOException;

public class ControllerSettings {
    @FXML
    private Text messageField;

    public void goBackk(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/customerMenu.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }

    @FXML
    public void ShowMessage(ActionEvent event) throws IOException {
        messageField.setText("Your personal data has been registered");
    }
}
