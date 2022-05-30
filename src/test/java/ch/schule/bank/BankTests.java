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

        assertEquals("A-1000", b.createAccount().getId());
        assertEquals("S-1001", b.createSavingsAccount().getId());
        assertEquals("S-1002", b.createSavingsAccount().getId());
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

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        System.out.println("Top 5:");

        Bank b = new Bank();

        // 7 Konten erzeugen
        for (int i = 0; i < 7; ++i)
            b.createSalaryAccount(-100000000);

        // Einzahlungen
        b.deposit("P-1000", 100);
        b.deposit("P-1001", 500);
        b.deposit("P-1002", 300);
        b.deposit("P-1003", 700);
        b.deposit("P-1004", 200);
        b.deposit("P-1005", 400);
        b.deposit("P-1006", 600);

        // Ausgabe der Top 5
        b.writeAccountsSortedDescending(5);
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        System.out.println("Bottom 5:");

        Bank b = new Bank();

        // 7 Konten erzeugen
        for (int i = 0; i < 7; ++i)
            b.createSalaryAccount(-100000000);

        // Einzahlungen
        b.deposit("P-1000", 100);
        b.deposit("P-1001", 500);
        b.deposit("P-1002", 300);
        b.deposit("P-1003", 700);
        b.deposit("P-1004", 200);
        b.deposit("P-1005", 400);
        b.deposit("P-1006", 600);

        // Ausgabe der Bottom 5
        b.writeAccountsSortedAscending(5);
    }

}
