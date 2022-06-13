package ch.schule;

import ch.schule.accounts.PromoYouthSavingsAccount;
import ch.schule.accounts.SalaryAccount;
import ch.schule.accounts.SavingsAccount;

public class Factory {
    public synchronized static Account createAccount(int accountNumberIncrement) {
        String accountNumber = "A-" + accountNumberIncrement;
        return new Account(accountNumber);
    }

    public synchronized static SavingsAccount createSavingsAccount(int accountNumberIncrement) {
        String accountNumber = "S-" + accountNumberIncrement;
        return new SavingsAccount(accountNumber);
    }

    public synchronized static PromoYouthSavingsAccount createPromoYouthSavingsAccount(int accountNumberIncrement) {
        String accountNumber = "Y-" + accountNumberIncrement;
        return new PromoYouthSavingsAccount(accountNumber);
    }

    public synchronized static SalaryAccount createSalaryAccount(int creditLimit, int accountNumberIncrement) {
        String accountNumber = "P-" + accountNumberIncrement;
        return new SalaryAccount(accountNumber, creditLimit);
    }
}
