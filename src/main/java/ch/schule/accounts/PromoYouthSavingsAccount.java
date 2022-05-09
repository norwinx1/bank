package ch.schule.accounts;

import ch.schule.Account;

public class PromoYouthSavingsAccount extends Account {
    public PromoYouthSavingsAccount(String accountNumber) {
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
