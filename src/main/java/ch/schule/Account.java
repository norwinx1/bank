package ch.schule;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Account {

    protected long balance = 0;
    protected String id;
    private final Map<Instant, Booking> bookings;

    public Account(String accountNumber) {
        this.id = accountNumber;
        bookings = new HashMap<>();
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
            Booking booking = new Booking(amount);
            bookings.put(booking.getInstant(), booking);
        }
    }

    public void withdraw(long amount) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
            Booking booking = new Booking(-amount);
            bookings.put(booking.getInstant(), booking);
        }
    }

}
