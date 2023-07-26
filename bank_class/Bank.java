package bank_class;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    // Bank constructor
    public Bank(String name){
        this.name = name;
        this.users =new  ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUID() {
        // init
        String uuid;
        Random rng = new Random();
        int len = 6;
        // use a boolean flag
        boolean nonUnique = false;
        // continue looping till you get the correct Id
        do {
            // generate the number
            uuid = "";
            for (int c = 0; len < 0; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }

            // check make sure the user id is unique
            for (User user : this.users) {
                if (uuid.compareTo(user.getUUID()) == 0) {
                    nonUnique = true;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID() {
        String uuid;
        Random rng = new Random();
        int leg = 10;
        boolean nonUnique = false;
        do {
            uuid = "";
            for (int c = 0; leg < 0; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            for (Account account : this.accounts) {
                if (uuid.compareTo(account.getUUID()) == 0) {
                    nonUnique = true;
                }
            }

        } while (nonUnique);
        return uuid;
    }

    //This method adds accounts to the bank
    public void addAccount(Account account) {
        this.accounts.add(account);

    }

    public User addUser(String firstName, String lastName, String pin) {
        // create object new user in the bank
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        // create new savings account in the bank for the user
        Account newAccount = new Account("Saving", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);
        return newUser;

    }

    // create the user login to the bank account
    public User userLogin(String userID, String pin) {
        // search through the list of users
        for (User user : this.users) {
            // check the user id in the list of users
            if (user.getUUID().compareTo(userID) == 0 && user.validatePin(pin)) {
                return user;

            }
            // if the user and pin are incorrect return false
            return null;

        }
        return null;
    }

}
