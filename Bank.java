import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

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

}
