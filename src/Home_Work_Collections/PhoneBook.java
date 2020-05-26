package src.Home_Work_Collections;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    HashMap<String, Integer> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, int phone) {
        phoneBook.put(name, phone);
    }

    public void get(String name) {
        System.out.println("Номер телефона: " + phoneBook.get(name));
    }
}




