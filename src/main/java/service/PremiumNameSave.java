package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.ControllerPremiumSub;
import exceptions.NoPasswordGiven;
import exceptions.NoUsernameGiven;
import exceptions.UsernameUsed;
import model.Customer;
import model.PremiumName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PremiumNameSave {
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
    public static void addPname(String username) throws UsernameUsed, NoUsernameGiven {
        loadPnames();
        checkExistingCustomer(username);
        checkExistingUsername(username);


        PremiumName ct = new PremiumName(username);
        Pnames.add(ct);
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("../HWA/src/main/resources/datastorage/premiumNames.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, Pnames);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkExistingCustomer(String username) throws UsernameUsed {

        for (PremiumName ct : Pnames) {
            if (Objects.equals(username, ct.getName()))
                throw new UsernameUsed(username);
        }
    }

    private static void checkExistingUsername(String username)throws NoUsernameGiven {

        if(Objects.equals(username, ""))
            throw new NoUsernameGiven(username);
    }


}
