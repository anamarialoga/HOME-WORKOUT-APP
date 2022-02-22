package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.Exercise;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerStrength implements Initializable {

    @FXML
    private TableView<Exercise> tableView;

    @FXML private TableColumn<Object, String> Column1;
    @FXML private TableColumn<Object, String> Column2;
    @FXML private TableColumn<Object, String> Column3;
    @FXML private TableColumn<Object, String> Column4;
    @FXML private TableColumn<Object, String> Column5;
    @FXML private TableColumn<Object, String> Column6;
    @FXML private TableColumn<Object, String> Column7;


    @FXML private TextField field1;
    @FXML private TextField field2;
    @FXML private TextField field3;
    @FXML private TextField field4;
    @FXML private TextField field5;
    @FXML private TextField field6;
    @FXML private TextField field7;

    static ArrayList<String> f1 = new ArrayList<>();
    static ArrayList<String> f2 = new ArrayList<>();
    static ArrayList<String> f3 = new ArrayList<>();
    static ArrayList<String> f4 = new ArrayList<>();
    static ArrayList<String> f5 = new ArrayList<>();
    static ArrayList<String> f6 = new ArrayList<>();
    static ArrayList<String> f7 = new ArrayList<>();
    public int aux2=0;

    public void newExercise(ActionEvent event) {
        if(Controller.ok==0) {
            Exercise newExercise = new Exercise(field1.getText(), field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText(), field7.getText());
            tableView.getItems().add(newExercise);
            f1.add(field1.getText());
            f2.add(field2.getText());
            f3.add(field3.getText());
            f4.add(field4.getText());
            f5.add(field5.getText());
            f6.add(field6.getText());
            f7.add(field7.getText());
            aux2=1;
            ControllerMenuTrainer.ct2=aux2;
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING, "You're not allowed to make changes!", ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }

    public void deleteExercise(ActionEvent event) {
        if(Controller.ok ==0) {
            ObservableList<Exercise> selectedRows, allEx;
            allEx = tableView.getItems();

            selectedRows = tableView.getSelectionModel().getSelectedItems();
            for (Exercise exercise : selectedRows) {
                allEx.remove(exercise);
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING, "You're not allowed to make changes!", ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK)
                alert.close();
        }
    }

    public void goBackk(ActionEvent event) throws IOException {
        if(Controller.ok == 1) {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Workout.fxml"));
            Scene newwindow = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(newwindow);
            window.show();
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/WorkoutT.fxml"));
            Scene newwindow = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(newwindow);
            window.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Column1.setCellValueFactory(new PropertyValueFactory<Object, String>("monday"));
        Column2.setCellValueFactory(new PropertyValueFactory<Object, String>("firstName"));
        Column3.setCellValueFactory(new PropertyValueFactory<Object, String>("lastName"));
        Column4.setCellValueFactory(new PropertyValueFactory<Object, String>("thursday"));
        Column5.setCellValueFactory(new PropertyValueFactory<Object, String>("friday"));
        Column6.setCellValueFactory(new PropertyValueFactory<Object, String>("saturday"));
        Column7.setCellValueFactory(new PropertyValueFactory<Object, String>("sunday"));

        tableView.setItems(getEx());

        tableView.setEditable(true);
        Column1.setCellFactory(TextFieldTableCell.forTableColumn());
        Column2.setCellFactory(TextFieldTableCell.forTableColumn());
        Column3.setCellFactory(TextFieldTableCell.forTableColumn());
        Column4.setCellFactory(TextFieldTableCell.forTableColumn());
        Column5.setCellFactory(TextFieldTableCell.forTableColumn());
        Column6.setCellFactory(TextFieldTableCell.forTableColumn());
        Column7.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public ObservableList<Exercise>  getEx() {
        ObservableList<Exercise> data = FXCollections.observableArrayList();

        data.add(new Exercise("Plank",     "Break", "Decline Push-up", "Break", "Pull-Ups", "Break", "Muscle Up"));
        data.add(new Exercise("Roussian Twist", "",      "Side-Plank", "", "UpAndDown Plank", "", "Box Jumps"));
        data.add(new Exercise("Push-Ups",       "",      "Boat Hold", "", "Wall Sit", "", "Side-Plank"));
        data.add(new Exercise("Box Jumps",       "",      "UpAndDown Plank", "", "Roussian Twist", "", "Butterflies"));
        data.add(new Exercise("Wall Sit",       "",      "BUtterflies", "", "Muscle Up", "", "Push-ups"));
        System.out.println(ControllerMenuTrainer.ct2);
        if(ControllerMenuTrainer.ct2==1){
            for(int i=0;i<f1.size();i++){
                data.add(new Exercise(f1.get(i),f2.get(i),f3.get(i),f4.get(i),f5.get(i),f6.get(i),f6.get(i)));
            }
        }
        return data;
    }
}
