package ch.schule.bank;

import ch.schule.Account;
import ch.schule.accounts.SalaryAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse Account.
 * mit JUnit v 4
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */

public class AccountsTests {

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @BeforeEach
    public void init() {
        Account a = new Account("A-1000");
        assertEquals("A-1000", a.getId());
        assertEquals(0, a.getBalance());
    }

    @Test
    public void testDeposit() {
        Account a = new Account("A-1000");

        // CHF 1.-- einzahlen
        a.deposit(100000);
        // Saldo muss 1.-- sein
        assertEquals(100000, a.getBalance());

        // CHF 2.00 einzahlen
        a.deposit(200000);
        // Saldo muss 3.-- sein
        assertEquals(300000, a.getBalance());

        // Versuch, negativen Betrag einzuzahlen
        // darf nicht gehen. Saldo muss unverändert
        // bleiben
        a.deposit(-50000);
        assertEquals(300000, a.getBalance());
    }

    @Test
    public void testWithdraw() {
        Account a = new SalaryAccount("A-1000");

        // CHF 1.-- abheben
        a.withdraw(100000);
        // Saldo muss -1.-- sein
        assertEquals(-100000, a.getBalance());

        // CHF 2.00 abheben
        a.withdraw(200000);
        // Saldo muss -3.-- sein
        assertEquals(-300000, a.getBalance());

        // Versuch, negativen Betrag abzuheben
        // darf nicht gehen. Saldo muss unverändert
        // bleiben
        a.withdraw(-50000);
        assertEquals(-300000, a.getBalance());
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        System.out.println("--- Gesamtauszüge ---");
        Account a = new Account("A-1000");

        a.deposit(1000000);
        a.withdraw(200000);
        a.withdraw(200000);
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        System.out.println("--- Monatsauszüge ---");

        Account a = new Account("A-1000");

        a.deposit(1000000);
        a.withdraw(200000);
        a.withdraw(200000);
    }


}
