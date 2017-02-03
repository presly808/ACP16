package ua.artcode;

import ua.artcode.controller.Action;
import ua.artcode.dao.ContactDao;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.View;

/**
 * Created by Alexander on 03.02.2017.
 */
public class Run {
    public static void main(String[] args) {
        FileSaver fileSaver = new FileSaver("C:\\Users\\Alexander\\IdeaProjects\\ACP16\\PapushaAlexander\\src\\ua\\artcode\\db\\db.json");
        ContactDao dao = new ContactDao(fileSaver);
        Action action = new Action(dao);
        View view = new View(action);

    }
}
