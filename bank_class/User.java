package bank_class;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String firstname;
    private String lastname;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin) {

    }

    public User(String firstname, String lastname, String pin, Bank theBank) {
        this.firstname = firstname;
        this.lastname = lastname;
        // stores the pin MDS hash, rather than the original for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (Exception exception) {
            System.err.println("Exception");
            exception.printStackTrace();
            System.exit(1);
        }
        // get a new unique universal id for the user
        this.uuid = theBank.getNewUserUUID();
        // create empty list of accounts
        this.accounts = new ArrayList<Account>();
        // print the log Message
        System.out.printf("New user %s, %s wit id %s created.\n",
                firstname, lastname, this.uuid);

    }

    // add an account for the user
    public void addAccount(Account account) {
        this.accounts.add(account);


    }

    public String getUUID() {
        return this.uuid;
    }

    public boolean validatePin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(pin.getBytes()),this.pinHash);
        } catch (Exception exception) {
            System.err.println("invalid user or password");
            exception.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    public static class ATM {
        public static void main(String[] args) {
            System.out.println("Welcome to Centenary Bank");
        }
        Scanner scanner = new Scanner(System.in);
        Bank theBank = new Bank("Mappera Head Office");
        User user = theBank.addUser("Mumbere","Harbet","1234");
        // add checking account to the user
        Account newAccount = new Account("Savings",user,theBank);
//        user.addAccount(newAccount);
//        theBank.addAccount(newAccount);
    }
}
