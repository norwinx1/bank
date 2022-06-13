package ch.schule;

import java.time.Instant;
import ch.schule.accounts.PromoYouthSavingsAccount;
import ch.schule.accounts.SalaryAccount;
import ch.schule.accounts.SavingsAccount;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {

    private static final Bank instance = new Bank();

    private Map<String, Account> accounts;
    private int accountNumberIncrement;

    private Bank() {
        accounts = new TreeMap<>();
        accountNumberIncrement = 1000;
    }

    public static Bank getInstance() {
        return instance;
    }

    public void clearAccounts() {
        accounts = new TreeMap<>();
        accountNumberIncrement = 1000;
    }

    public Account createAccount() {
        Account account = Factory.createAccount(accountNumberIncrement++);
        accounts.put(account.id, account);
        return account;
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount account = Factory.createSavingsAccount(accountNumberIncrement++);
        accounts.put(account.id, account);
        return account;
    }

    public PromoYouthSavingsAccount createPromoYouthSavingsAccount() {
        PromoYouthSavingsAccount account = Factory.createPromoYouthSavingsAccount(accountNumberIncrement++);
        accounts.put(account.id, account);
        return account;
    }

    public SalaryAccount createSalaryAccount(int creditLimit) {
        SalaryAccount account = Factory.createSalaryAccount(creditLimit, accountNumberIncrement++);
        accounts.put(account.id, account);
        return account;
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

    private Account searchAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public long getBalance(String s) {
        return searchAccount(s).getBalance();
    }

    public void writeAccountsSortedAscending() {
        List<Account> collect = getAccountsSortedAscending();
        System.out.println("\nAccounts sorted ascending");
        printBooking(collect);
    }

    public void writeAccountsSortedDescending() {
        List<Account> collect = getAccountsSortedDescending();
        System.out.println("\nAccounts sorted descending");
        printBooking(collect);
    }

    public void writeAccountsSortedAscending(int limit) {
        List<Account> collect = getAccountsSortedAscending().stream().limit(limit).collect(Collectors.toList());
        System.out.println("\nAccounts sorted ascending");
        printBooking(collect);
    }

    public void writeAccountsSortedDescending(int limit) {
        List<Account> collect = getAccountsSortedDescending().stream().limit(limit).collect(Collectors.toList());
        System.out.println("\nAccounts sorted descending");
        printBooking(collect);
    }

    private List<Account> getAccountsSortedAscending() {
        return accounts.values().stream().sorted(Comparator.comparingLong(Account::getBalance)).collect(Collectors.toList());
    }

    private List<Account> getAccountsSortedDescending() {
        return accounts.values().stream().sorted(Comparator.comparingLong(Account::getBalance).reversed()).collect(Collectors.toList());
    }

    private void printBooking(List<Account> collect) {
        collect.forEach(it -> System.out.println("\nAccount-id:" + it.id + "\t Balance:" + it.balance));
    }

    public void printAccount(String id) {
        Account account = accounts.get(id);
        account.print();
    }

    public void printAccount(String id, int year, int month) {
        Account account = accounts.get(id);
        String m = "" + month;
        if (month < 10) {
            m = "0" + month;
        }
        account.print(Instant.parse("" + year + "-" + m + "-01T00:00:00Z"));
    }
}
