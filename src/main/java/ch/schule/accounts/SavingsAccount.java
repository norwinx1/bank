package ch.schule.accounts;

import ch.schule.Account;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void deposit(long amount) {
        if (amount > 0) {
            double bonus = amount * 0.01;
            balance += amount + bonus;
        }
    }
}
