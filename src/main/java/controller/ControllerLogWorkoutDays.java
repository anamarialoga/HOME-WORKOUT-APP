package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogWorkoutDays {
    @FXML
    private Text text, text1, text11, text111, text1111, text11111, text111111;

    @FXML
    private CheckBox cb1, cb2, cb3, cb4,cb5 ,cb6, cb7;

    public void Reminder(ActionEvent event) throws IOException {
        if(cb1.isSelected()==true)
            text.setText("Each Monday you will get on-screen reminders to workout!");
        if(cb2.isSelected()==true)
            text1.setText("Each Tuesday you will get on-screen reminders to workout!");
        if(cb3.isSelected()==true)
            text11.setText("Each Wednesday you will get on-screen reminders to workout!");
        if(cb4.isSelected()==true)
            text111.setText("Each Thursday you will get on-screen reminders to workout!");
        if(cb5.isSelected()==true)
            text1111.setText("Each Friday you will get on-screen reminders to workout!");
        if(cb6.isSelected()==true)
            text11111.setText("Each Saturday you will get on-screen reminders to workout!");
        if(cb7.isSelected()==true)
            text111111.setText("Each Sunday you will get on-screen reminders to workout!");

    }

    public void goBackk(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/customerMenu.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }
}
