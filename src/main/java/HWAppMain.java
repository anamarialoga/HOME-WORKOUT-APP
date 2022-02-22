import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HWAppMain extends Application {
    private Stage primaryStage;

    public HWAppMain() {
    }

    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("HomeWorkoutApp");
        Parent root = (Parent)FXMLLoader.load(HWAppMain.class.getResource("view/sample.fxml"));
        primaryStage.setScene(new Scene(root, 590.0D, 603.0D));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
