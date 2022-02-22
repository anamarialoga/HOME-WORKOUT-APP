package controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.fasterxml.jackson.core.type.TypeReference;
import jdk.nashorn.internal.parser.JSONParser;
import model.PremiumName;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ControllerViewCustomers {
    @FXML
    private Text show;
    public void goBackk(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("view/trainerMenu.fxml"));
        Scene newwindow=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newwindow);
        window.show();
    }

    public void send(ActionEvent event) {


        try {
            String aux="";
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("../HWA/src/main/resources/datastorage/premiumNames.json"));
            TypeReference<List<PremiumName>> typeReference = new TypeReference<List<PremiumName>>() {};
            List<PremiumName> names = mapper.readValue(inputStream,typeReference);
            for(PremiumName n : names){
                System.out.println("name " + n.getName());
                aux=aux+n.getName();
                aux=aux+"\n";
            }
            show.setText("" + aux);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
