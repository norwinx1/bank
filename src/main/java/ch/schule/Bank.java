package ch.schule;

import java.util.*;

public class Bank {

    private final Map<String, Account> accounts;
    private int accountNumberIncrement;

    public Bank() {
        accounts = new TreeMap<>();
        accountNumberIncrement = 1000;
    }

    public void createAccount() {
        String accountNumber = "A-" + accountNumberIncrement++;
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
    }

    public Account getAccount(String accountNumber) {
        return searchAccount(accountNumber);
    }

    public void deleteAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public void deposit(String accountNumber, long amount) {
        searchAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, long amount) {
        searchAccount(accountNumber).withdraw(amount);
    }

    public void triggerBooking(String accountNumber, Booking booking) {
        if (booking.getAmount() < 0) {
            searchAccount(accountNumber).withdraw(booking.getAmount() * (-1));
        } else {
            searchAccount(accountNumber).deposit(booking.getAmount());
        }
    }

    private Account searchAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public long getBalance(String s) {
        return searchAccount(s).getBalance();
    }
}
