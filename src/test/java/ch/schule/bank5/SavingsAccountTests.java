package ch.schule.bank5;

import ch.schule.accounts.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.0
 */
public class SavingsAccountTests {
    @Test
    public void test() {
        SavingsAccount a = new SavingsAccount("S-1000");

        a.deposit(1000);
        a.withdraw(1000);
        a.deposit(1000);
        a.withdraw(1001);
        assertEquals(19, a.getBalance());
    }
}
