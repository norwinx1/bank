package ch.schule.accounts;

import ch.schule.Account;

public class SalaryAccount extends Account {
    public SalaryAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(long amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }
}
