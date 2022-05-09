package ch.schule.bank5;

import ch.schule.accounts.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class SalaryAccountTests {
    /**
     * Der Test.
     */
    @Test
    public void test() {
        SalaryAccount a = new SalaryAccount("C-1000");
        a.withdraw(1000);
        assertEquals(-1000, a.getBalance());

        a.deposit(100);
        assertEquals(-900, a.getBalance());

        a.withdraw(1000);
        assertEquals(-1900, a.getBalance());

        a.deposit(1900);
        assertEquals(0, a.getBalance());
    }
}
