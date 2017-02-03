package ua.artcode.dao;

import ua.artcode.model.Contact;

/**
 * Created by Alexander on 03.02.2017.
 */
public class ContactDao implements IContactDao {
    @Override
    public boolean saveContact(Contact contact) {
        return false;
    }

    @Override
    public boolean removeContact(Contact contact) {
        return false;
    }

    @Override
    public boolean searchName(String name) {
        return false;
    }
}
