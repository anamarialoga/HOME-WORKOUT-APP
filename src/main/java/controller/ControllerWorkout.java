package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerWorkout {
    public void goBackk(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/customerMenu.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }

    public void goToFatBurning(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/FatBurn.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();


        window.setScene(newwindow);
        window.show();
    }




    public void goToStrengthBuilding(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/Strength.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();


        window.setScene(newwindow);
        window.show();
    }

    public void goToBodyBuilding(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/BodyBuilding.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }
}
