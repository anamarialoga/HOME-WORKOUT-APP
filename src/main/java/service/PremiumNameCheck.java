package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.UsernameOrPasswordIncorrect;
import model.Customer;
import model.PremiumName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PremiumNameCheck {
    private static List<PremiumName> Pnames=new ArrayList<PremiumName>();
    public static void loadPnames() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("../HWA/src/main/resources/datastorage/premiumNames.json"));
            TypeReference<List<PremiumName>> typeReference = new TypeReference<List<PremiumName>>() {
            };
            Pnames = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void checkName(String username) throws UsernameOrPasswordIncorrect {
        loadPnames();
        checkN(username);
    }
    public static void checkN(String username) throws UsernameOrPasswordIncorrect {

        int us = 0, pas = 0;
        for (PremiumName customer : Pnames) {
            if (Objects.equals(username, customer.getName()))
                us = 1;

        }
        if (us != 1 )
            throw new UsernameOrPasswordIncorrect();
    }
}
