package ch.schule.accounts;

import ch.schule.Account;

public class SalaryAccount extends Account {
    private final int creditLimit;
    public SalaryAccount(String accountNumber, int creditLimit) {
        super(accountNumber);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(long amount) {
        if (amount > 0 || (balance-amount) < creditLimit) {
            balance -= amount;
        }
    }
}
