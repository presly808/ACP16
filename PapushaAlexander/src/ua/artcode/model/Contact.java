package ua.artcode.model;

/**
 * Created by Alexander on 03.02.2017.
 */
public class Contact {

    private String name;
    private int phone;
    private Gender gender;



    public Contact(String name, int phone, Gender gender) {

        this.name = name;
        this.phone = phone;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {

        return "Contact{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (phone != contact.phone) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        return gender == contact.gender;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + phone;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
