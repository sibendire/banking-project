import java.util.ArrayList;

public class Account {
    private String accountName;
    private double balance;
    private String uuid;
    private User holder;
    private ArrayList<Transactions> transactions;

    public Account(String accountName, User holder,Bank theBank) {
        this.accountName = accountName;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();
        // initial Transaction
        this.transactions = new ArrayList<Transactions>();
        // add the list to the bank and the holder
        holder.addAccount(this);
        theBank.addAccount(this);

    }
    public String getUUID(){
        return this.uuid;
    }
}
