package ch.schule;

public class Account {

    protected long balance = 0;
    protected String id;

    public Account(String accountNumber) {
        this.id = accountNumber;
    }

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
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
        }
    }

}
