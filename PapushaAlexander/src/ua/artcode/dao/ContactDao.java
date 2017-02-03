package ua.artcode.dao;

import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;

/**
 * Created by Alexander on 03.02.2017.
 */
public class ContactDao implements IContactDao {
    private FileSaver fileSaver;

    public ContactDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public boolean addContact(Contact contact) {
        return fileSaver.add(contact);
    }

    @Override
    public boolean removeContact(Contact contact) {
        return fileSaver.delete(contact);
    }

    @Override
    public Contact searchName(String name) {
        return fileSaver.searchByName(name);
    }
}
