package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.*;
import model.Trainer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrainerLogin {

    private static List<Trainer> trainers = new ArrayList<Trainer>();

    public static void loadTrainer() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("../HWA/src/main/resources/datastorage/trainers.json"));
            TypeReference<List<Trainer>> typeReference = new TypeReference<List<Trainer>>() {
            };
            trainers = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void checkTrainer(String username, String password) throws UsernameOrPasswordIncorrect{
        loadTrainer();
        checkAccount(username, password);
    }

    private static void checkAccount(String username, String password) throws UsernameOrPasswordIncorrect {
        int us = 0, pas = 0;
        for (Trainer tr : trainers) {
            if(Objects.equals(username, tr.getUsername()))
                us=1;
            if(Objects.equals(password, tr.getPassword()))
                pas=1;
        }
        if(us != 1 || pas != 1)
            throw new UsernameOrPasswordIncorrect();
    }

}
