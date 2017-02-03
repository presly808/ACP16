package ua.artcode.controller;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import ua.artcode.dao.ContactDao;
import ua.artcode.model.Contact;
import ua.artcode.model.Gender;


/**
 * Created by Alexander on 03.02.2017.
 */
public class TestAction {

    static ContactDao dao;
    static Action action;

    @BeforeClass
    public static void before_data(){
        dao = mock(ContactDao.class);
        action = new Action(dao);
        when(dao.addContact(new Contact("a", 12, Gender.MAN))).thenReturn(true);
        when(dao.removeContact(new Contact("a", 12, Gender.MAN))).thenReturn(true);
        when(dao.searchName("a")).thenReturn(new Contact("a", 12, Gender.MAN));
    }

    @Test
    public void add_new_contact_test(){
        Assert.assertTrue(action.addContact("a", 12, Gender.MAN));
    }

    @Test
    public void delete_contact_test(){
        Assert.assertTrue(action.removeContactByName("a"));
    }

    @Test
    public void search_contact_by_name_test(){
        Contact contact = new Contact("a", 12, Gender.MAN);
        assertEquals(contact, action.searchContactByName("a"));
    }

}
