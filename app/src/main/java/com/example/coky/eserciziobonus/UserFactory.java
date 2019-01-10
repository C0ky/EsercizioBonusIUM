package com.example.coky.eserciziobonus;

import java.util.ArrayList;

public class UserFactory {

    private static UserFactory instance;
    private ArrayList<User> userList = new ArrayList<>();

    /*
     * Constructor of the User Factory for the predetermined users
     */
    private UserFactory() {

        User user1 = new User();
        user1.setUsername("Coky");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUsername("Mauro");
        user2.setPassword("marziale");

        User user3 = new User();
        user3.setUsername("Lorenzo");
        user3.setPassword("mazinga123");

        /*
         * The newly created users will be put in a list used by the methods.
         */
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }


    public static UserFactory getInstance() {
        if (instance == null)
            instance = new UserFactory();
        return instance;
    }


    /*
     * Method that checks if both the username and password used in the login form
     * are correct, outputting a different boolean if the login is succesfull or not
     */
    public boolean login(String username, String password) {
        for (User user : userList)
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;

        return false;
    }

}
