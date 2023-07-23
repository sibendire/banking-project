import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    public String getNewUserUUID(){
    // init
        String uuid;
        Random rng = new Random();
        int len= 6;
        boolean nonUnique;
        // continue looping till you get the correct Id
        do {
            uuid = "";
            for (int c =0; len<0; c++){
                uuid += ((Integer)rng.nextInt(10)) .toString();
            }
        }
    }
    public String getNewAccountUUID(){

    }
    //This method adds accounts to the user
    public void addAccount(Account account){
        this.accounts.add(account);

    }

}
