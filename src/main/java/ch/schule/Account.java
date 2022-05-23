package ch.schule;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static ch.schule.BankUtils.compareInstantForMonthAndYear;

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

    public void print() {
        print(bookings.values());
    }

    public void print(Instant instant) {
        List<Booking> filteredBookings = new LinkedList<>();
        bookings.values().forEach(booking -> {
            if (compareInstantForMonthAndYear(instant, booking.getInstant()))
                filteredBookings.add(booking);
        });
        print(filteredBookings);
    }

    private void print(Collection<Booking> bookings) {
        System.out.println("\n Account");
        System.out.println("\tId: " + id);
        System.out.println("\tBalance: " + balance);
        System.out.println("\tBookings: ");
        bookings.forEach(booking -> {
            System.out.println("\t\tDate: " + booking.getInstant().toString());
            System.out.println("\t\tAmount: " + booking.getAmount());
        });
    }
}
