package ua.artcode.dao;

import ua.artcode.model.Contact;

/**
 * Created by Alexander on 03.02.2017.
 */
public interface IContactDao {

    boolean addContact(Contact contact);
    boolean removeContact(Contact contact);
    Contact searchName(String name);
}
