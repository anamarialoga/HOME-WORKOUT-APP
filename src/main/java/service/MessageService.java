package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.BlankSpace;
import exceptions.NoUsernameGiven;
import exceptions.UsernameUsed;
import model.Customer;
import model.Message;
import model.PremiumName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageService {
    private static List<Message> messages=new ArrayList<Message>();
    public static void loadMessages() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("../HWA/src/main/resources/datastorage/chat.json"));
            TypeReference<List<Message>> typeReference = new TypeReference<List<Message>>() {
            };
            messages = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addMessage(String username) throws BlankSpace {
        loadMessages();
        checkBlankSpace(username);
        Message ct = new Message(username);
        messages.add(ct);
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("../HWA/src/main/resources/datastorage/chat.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, messages);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkBlankSpace(String username) throws BlankSpace {

        for (Message m : messages) {
            if (Objects.equals(username, m.getMessage()))
                throw new BlankSpace(username);
        }
    }
}