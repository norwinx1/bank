package ch.schule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Bank {

    private final ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber) {
        Account account = new Account();
        account.setId(accountNumber);
        accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
		return searchAccount(accountNumber);
    }

    public void deleteAccount(String accountNumber) {
		accounts.removeIf(account -> account.getId().equals(accountNumber));
    }

    public void deposit(String accountNumber, long amount) {
		searchAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, long amount) {
		searchAccount(accountNumber).withdraw(amount);
    }

	private Account searchAccount(String accountNumber) {
		Optional<Account> foundAccount = accounts.stream().filter(account -> account.getId().equals(accountNumber)).findFirst();
		return foundAccount.orElseThrow();
	}

}
