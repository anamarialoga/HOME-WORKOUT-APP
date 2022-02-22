package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NoPasswordGiven;
import exceptions.NoUsernameGiven;
import exceptions.UsernameUsed;
import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerReg {

    private static List<Customer> customers=new ArrayList<Customer>();

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
    public static void addCustomer(String username, String password) throws UsernameUsed, NoPasswordGiven, NoUsernameGiven{
        loadCustomers();
        checkExistingCustomer(username);
        checkExistingUsername(username);
        checkExistingPassword(password);

        Customer ct = new Customer(username,  password);
        customers.add(ct);
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("../HWA/src/main/resources/datastorage/customers.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, customers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkExistingCustomer(String username) throws UsernameUsed {

        for (Customer ct : customers) {
            if (Objects.equals(username, ct.getUsername()))
                throw new UsernameUsed(username);
        }
    }

    private static void checkExistingUsername(String username)throws NoUsernameGiven {

        if(Objects.equals(username, ""))
            throw new NoUsernameGiven(username);
    }

    private static void checkExistingPassword(String password)throws NoPasswordGiven {

        if(Objects.equals(password,""))
            throw new NoPasswordGiven(password);
    }


}

