package ch.schule.bank;

import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi cavuoti
 * @version 1.1
 */
public class BookingTests {
    /**
     * Tests für die Erzeugung von Buchungen.
     */
    @BeforeEach
    public void testInitialization() {
        Booking b = new Booking(LocalDate.of(1970, 1, 1), 1000);
        assertEquals(LocalDate.of(1970, 1, 1), b.getDate());
        assertEquals(1000, b.getAmount());
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Booking b;
        b = new Booking(LocalDate.of(1970, 1, 1), 100000);
        b.print();
        b = new Booking(LocalDate.of(2000, 1, 1), 1000000000);
        b.print();
    }
}
