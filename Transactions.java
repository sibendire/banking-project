import java.util.Date;

public class Transactions {
    private double amount;
    private Date timeOfTransaction;
    private String statement;
    private Account inAccount;

    // This is called overloading contractors
    public Transactions(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timeOfTransaction = new Date();
        this.statement = "";
    }

    public Transactions(double amount, String statement, Account inAccount) {
        this(amount, inAccount);
        this.statement = statement;
    }
}
