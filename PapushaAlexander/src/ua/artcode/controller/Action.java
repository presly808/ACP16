package ua.artcode.controller;

import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.model.Gender;

/**
 * Created by Alexander on 03.02.2017.
 */
public class Action {

    private IContactDao dao;

    public Action(IContactDao dao) {
        this.dao = dao;
    }

    public boolean addContact(String name, int phone, Gender gender){
        exceptionName(name);
        exceptionPhone(phone);
        return dao.addContact(new Contact(name, phone, gender));
    }

    public boolean removeContactByName(String name){
        exceptionName(name);
        return dao.removeContact(dao.searchName(name));
    }

    public Contact searchContactByName(String name){
        exceptionName(name);
        Contact contact = dao.searchName(name);
        return contact;
    }

    private void exceptionName(String name){
        if (name.equals("")) try {
            throw new Exception("invalid data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void exceptionPhone(int phone){
        if (phone == 0) try {
            throw new Exception("invalid data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
