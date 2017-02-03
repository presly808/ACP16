package ua.artcode.view;

import ua.artcode.controller.Action;
import ua.artcode.model.Contact;
import ua.artcode.model.Gender;

import java.util.Scanner;

/**
 * Created by Alexander on 03.02.2017.
 */
public class View {
    private Action action;
    private Scanner sc;

    public View(Action action) {
        this.action = action;
        sc = new Scanner(System.in);
        while(true) run();
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

    public void addContact(){
        action.addContact(inputName(), inputPhone(), inputGender());
    }

    public void removeContactByName(){
        action.removeContactByName(inputName());
    }

    public void searchContactByName(){
        Contact contact = action.searchContactByName(inputName());
        System.out.println(contact);
    }

}
