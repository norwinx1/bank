package ch.schule;

public class Account {

    private long balance = 0;
    private String id;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(long amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }

}
