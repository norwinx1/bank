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

    public boolean deposit(long amount) {
        // 1. positiver Betrag sonst false
        if (amount > 0) {
            balance += amount;
            // 2. Betrag einzahlen und true zurück
            return true;
        }
        // 2. Betrag nicht einbezahlt und false zurück
        return false;
    }

    public boolean withdraw(long amount) {
        // 1. positiver Betrag sonst false
        if (amount > 0) {
            balance -= amount;
            // 2. Betrag abheben und true zurück
            return true;
        }
        // Es konnte nicht abgehoben werden
        return false;
    }

}
