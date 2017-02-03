package ua.artcode.dao;

import ua.artcode.model.Contact;

/**
 * Created by Alexander on 03.02.2017.
 */
public interface IContactDao {

    boolean saveContact(Contact contact);
    boolean removeContact(Contact contact);
    boolean searchName(String name);
}
