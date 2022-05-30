package ch.schule;

import java.time.Instant;
import ch.schule.accounts.PromoYouthSavingsAccount;
import ch.schule.accounts.SalaryAccount;
import ch.schule.accounts.SavingsAccount;

import java.util.*;
import java.util.stream.Collectors;

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

    public void createSavingsAccount() {
        String accountNumber = "S-" + accountNumberIncrement++;
        SavingsAccount account = new SavingsAccount(accountNumber);
        accounts.put(accountNumber, account);
    }

    public void createPromoYouthSavingsAccount() {
        String accountNumber = "Y-" + accountNumberIncrement++;
        PromoYouthSavingsAccount account = new PromoYouthSavingsAccount(accountNumber);
        accounts.put(accountNumber, account);
    }

    public void createSalaryAccount(int creditLimit) {
        String accountNumber = "P-" + accountNumberIncrement++;
        SalaryAccount account = new SalaryAccount(accountNumber, creditLimit);
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
