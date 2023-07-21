public class Account {
    private String accountName;
    private double balance;
    private String uuid;
    private User holder;

    public Account(String accountName, User holder) {
        this.accountName = accountName;
        this.holder = holder;
    }
}
