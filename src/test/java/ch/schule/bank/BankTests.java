package ch.schule.bank;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse 'Bank'.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BankTests {
    @Test
    public void testCreate() {
        Bank b = new Bank();

        b.createAccount();
        b.createAccount();

        assertEquals(b.getAccount("A-1000").getId(), "A-1000");
    }

    @Test
    public void testDeposit() {
        Bank b = new Bank();
        b.createAccount();
        b.createAccount();
        b.createAccount();

        b.deposit("A-1000", 100000);
        assertEquals(100000, b.getBalance("A-1000"));
        assertEquals(0, b.getBalance("A-1001"));

        b.deposit("A-1001", 200000);
        assertEquals(100000, b.getBalance("A-1000"));
        assertEquals(200000, b.getBalance("A-1001"));

        b.deposit("A-1002", 0);
        assertEquals(100000, b.getBalance("A-1000"));
        assertEquals(200000, b.getBalance("A-1001"));
    }

    @Test
    public void testWithdraw() {
        Bank b = new Bank();
        b.createAccount();
        b.createAccount();
        b.createAccount();

        b.withdraw("A-1000", 0);
        assertEquals(0,
                b.getBalance("A-1000"));
        assertEquals(0, b.getBalance("A-1001"));

        b.withdraw("A-1001", 0);
        assertEquals(0, b.getBalance("A-1000"));
        assertEquals(0, b.getBalance("A-1001"));

        b.withdraw("A-1002", 0);
        assertEquals(0, b.getBalance("A-1000"));
        assertEquals(0, b.getBalance("A-1001"));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        System.out.println("-- Gesamtauszüge --");
        Bank b = new Bank();

        b.createAccount();
        b.createAccount();

        b.deposit("A-1000", 1);
        b.deposit("A-1001", 2);
        b.withdraw("A-1000", 3);
        b.withdraw("A-1001", 4);
    }


}
