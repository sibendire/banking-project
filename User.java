import java.util.ArrayList;

public class User {
    private String firstname;
    private String lastname;
    private String uuid;
    private byte pinHash[];
    private ArrayList<User> users;
    public User(String firstname, String lastname,byte[] pinHash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pinHash = pinHash;
    }
}
