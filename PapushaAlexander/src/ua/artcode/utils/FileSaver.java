package ua.artcode.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.artcode.model.Contact;

import java.io.*;
import java.util.*;

/**
 * Created by Alexander on 03.02.2017.
 */
public class FileSaver {
    private String path;
    private Gson gson;

    public FileSaver(String path) {
        this.path = path;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private List<Contact> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<Contact> contacts = gson.fromJson(br, new TypeToken<List<Contact>>(){}.getType());
            if (contacts == null){
                contacts = new LinkedList<>();
            }
            return contacts;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void save(List<Contact> contacts){

        String json = gson.toJson(contacts);

        try (FileWriter writer = new FileWriter(path)){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Contact contact){
        List<Contact> contacts = read();

        if (!contacts.contains(contact)) {
            contacts.add(contact);
            save(contacts);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Contact contact){
        List<Contact> contacts = read();
        boolean res = contacts.remove(contact);
        save(contacts);
        return res;
    }

    public Contact searchByName(String name){

        List<Contact> contacts = read();
        return contacts.stream().filter(contact -> contact.getName().equals(name)).findFirst().get();

    }

}
