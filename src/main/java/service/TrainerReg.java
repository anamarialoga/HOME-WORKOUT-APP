package service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NoPasswordGiven;
import exceptions.NoUsernameGiven;
import exceptions.UsernameUsed;
import model.Trainer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrainerReg {

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

    public static void addTrainer(String username, String password) throws UsernameUsed, NoPasswordGiven, NoUsernameGiven {

        loadTrainer();
        checkExistingTrainer(username);
        checkExistingUsername(username);
        checkExistingPassword(password);


        Trainer tr = new Trainer(username,  password);
        trainers.add(tr);

        try {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("../HWA/src/main/resources/datastorage/trainers.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, trainers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void checkExistingTrainer(String username) throws UsernameUsed, NullPointerException{

        for (Trainer tr : trainers) {
            if (Objects.equals(username, tr.getUsername()))
                throw new UsernameUsed(username);
        }
    }

    static void checkExistingUsername(String username)throws NoUsernameGiven {

        if(Objects.equals(username, ""))
            throw new NoUsernameGiven(username);
    }


    private static void checkExistingPassword(String password) throws NoPasswordGiven {

        if(Objects.equals(password,""))
            throw new NoPasswordGiven(password);
    }

}
