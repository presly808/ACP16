package ua.artcode.controller;

import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.model.Gender;
import ua.artcode.utils.FileSaver;

import java.util.Scanner;

/**
 * Created by Alexander on 03.02.2017.
 */
public class Action {

    private IContactDao dao;
    private FileSaver fileSaver;
    private Scanner sc;

    public Action(IContactDao dao, FileSaver fileSaver) {
        this.dao = dao;
        this.fileSaver = fileSaver;
        sc = new Scanner(System.in);
        while (true) run();
    }

    private void run(){
        System.out.println("Hello\nIt's catalog\nChoices action\n" +
                "1. Add new contact\n" +
                "2. Delete contact by name\n" +
                "3. Search contact by name\n" +
                "4. Exit");

        switch (sc.nextInt()){
            case 1:
                addContact();
                break;
            case 2:
                removeContactByName();
                break;
            case 3:
                searchContactByName();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice!");
        }
    }

    private String inputName(){
        System.out.println("Input name contact");
        String name = sc.next();
        return name;
    }

    private int inputPhone(){
        System.out.println("Input phone");
        int phone = sc.nextInt();
        return phone;
    }

    private Gender inputGender(){

        System.out.println("Input gender:\n1. Man\n2. Woman");

        int choice = sc.nextInt();
        Gender gender;

        if (choice == 1 || choice == 2){

            if (choice == 1)
                gender = Gender.MAN;
            else
                gender = Gender.WOMAN;

        } else {
            System.out.println("Wrong choice!");
            gender = inputGender();
        }

        return gender;
    }

    public boolean addContact(){
        String name = inputName();
        int phone = inputPhone();
        Gender gender = inputGender();
        Contact contact = new Contact(name, phone, gender);
        System.out.println(contact);
        return dao.addContact(contact);

    }

    public boolean removeContactByName(){

        return dao.removeContact(dao.searchName(inputName()));

    }

    public void searchContactByName(){
        Contact contact = dao.searchName(inputName());
        System.out.println(contact);
    }


}
