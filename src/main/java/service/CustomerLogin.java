package service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.UsernameOrPasswordIncorrect;
import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerLogin {

    private static List<Customer> customers = new ArrayList<Customer>();

    public static void loadCustomers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("../HWA/src/main/resources/datastorage/customers.json"));
            TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
            };
            customers = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkCustomer(String username, String password) throws UsernameOrPasswordIncorrect{
        loadCustomers();
        checkAccount(username, password);
    }
    public static void checkAccount(String username, String password) throws UsernameOrPasswordIncorrect {

        int us = 0, pas = 0;
        for (Customer customer : customers) {
            if (Objects.equals(username, customer.getUsername()))
                us = 1;
            if (Objects.equals(password, customer.getPassword()))
                pas = 1;
        }
        if (us != 1 || pas != 1)
            throw new UsernameOrPasswordIncorrect();
    }

}

