import java.security.MessageDigest;
import java.util.ArrayList;

public class User {
    private String firstname;
    private String lastname;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;
    public User(){

    }
    public User(String firstname, String lastname,String pin,Bank theBank) {
        this.firstname = firstname;
        this.lastname = lastname;
        // stores the pin MDS hash, rather than the original for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md .digest(pin.getBytes());
        }catch (Exception exception){
            System.err.println("Exception");
        exception.printStackTrace();
        System.exit(1);
        }
        // get a new unique universal id for the user
        this.uuid = theBank.getNewUserUUID();
        // create empty list of account
        this.accounts = new ArrayList<Account>();
        // print the log Message
        System.out.printf("New user %s, %s wit id %s created.\n",
                firstname,lastname, this.uuid);

    }
}
