package ua.artcode.controller;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import ua.artcode.dao.ContactDao;
import ua.artcode.utils.FileSaver;

/**
 * Created by Alexander on 03.02.2017.
 */
public class TestAction {

    FileSaver fileSaver;
    ContactDao dao;

    public void add_new_contact_test(){
        Mockito.mock(FileSaver.class);
    }

}
