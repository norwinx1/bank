package ch.schule;

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
        List<Account> collect = accounts.values().stream().sorted(Comparator.comparingLong(Account::getBalance)).collect(Collectors.toList());
        System.out.println("\nAccounts sorted ascending");
        collect.forEach(it -> System.out.println("\nAccount-id:" + it.id + "\t Balance:" + it.balance));
    }

    public void writeAccountsSortedDescending() {
        List<Account> collect = accounts.values().stream().sorted(Comparator.comparingLong(Account::getBalance).reversed()).collect(Collectors.toList());
        System.out.println("\nAccounts sorted descending");
        collect.forEach(it -> System.out.println("\nAccount-id:" + it.id + "\t Balance:" + it.balance));
    }
}
