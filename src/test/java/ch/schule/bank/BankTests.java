package ch.schule.bank;

import ch.schule.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse 'Bank'.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BankTests {

    private Bank bank = Bank.getInstance();

    @BeforeEach
    public void setup() {
        bank.clearAccounts();
    }

    @Test
    public void testCreate() {
        assertEquals("A-1000", bank.createAccount().getId());
        assertEquals("S-1001", bank.createSavingsAccount().getId());
        assertEquals("S-1002", bank.createSavingsAccount().getId());
    }

    @Test
    public void testDeposit() {
        bank.createAccount();
        bank.createAccount();
        bank.createAccount();

        bank.deposit("A-1000", 100000);
        assertEquals(100000, bank.getBalance("A-1000"));
        assertEquals(0, bank.getBalance("A-1001"));

        bank.deposit("A-1001", 200000);
        assertEquals(100000, bank.getBalance("A-1000"));
        assertEquals(200000, bank.getBalance("A-1001"));

        bank.deposit("A-1002", 0);
        assertEquals(100000, bank.getBalance("A-1000"));
        assertEquals(200000, bank.getBalance("A-1001"));
    }

    @Test
    public void testWithdraw() {
        bank.createAccount();
        bank.createAccount();
        bank.createAccount();

        bank.withdraw("A-1000", 0);
        assertEquals(0,
                bank.getBalance("A-1000"));
        assertEquals(0, bank.getBalance("A-1001"));

        bank.withdraw("A-1001", 0);
        assertEquals(0, bank.getBalance("A-1000"));
        assertEquals(0, bank.getBalance("A-1001"));

        bank.withdraw("A-1002", 0);
        assertEquals(0, bank.getBalance("A-1000"));
        assertEquals(0, bank.getBalance("A-1001"));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        System.out.println("-- Gesamtauszüge --");

        bank.createAccount();
        bank.createAccount();

        bank.deposit("A-1000", 1);
        bank.deposit("A-1001", 2);
        bank.withdraw("A-1000", 3);
        bank.withdraw("A-1001", 4);
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        System.out.println("Top 5:");

        // 7 Konten erzeugen
        for (int i = 0; i < 7; ++i)
            bank.createSalaryAccount(-100000000);

        // Einzahlungen
        bank.deposit("P-1000", 100);
        bank.deposit("P-1001", 500);
        bank.deposit("P-1002", 300);
        bank.deposit("P-1003", 700);
        bank.deposit("P-1004", 200);
        bank.deposit("P-1005", 400);
        bank.deposit("P-1006", 600);

        // Ausgabe der Top 5
        bank.writeAccountsSortedDescending(5);
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        System.out.println("Bottom 5:");

        // 7 Konten erzeugen
        for (int i = 0; i < 7; ++i)
            bank.createSalaryAccount(-100000000);

        // Einzahlungen
        bank.deposit("P-1000", 100);
        bank.deposit("P-1001", 500);
        bank.deposit("P-1002", 300);
        bank.deposit("P-1003", 700);
        bank.deposit("P-1004", 200);
        bank.deposit("P-1005", 400);
        bank.deposit("P-1006", 600);

        // Ausgabe der Bottom 5
        bank.writeAccountsSortedAscending(5);
    }

}
