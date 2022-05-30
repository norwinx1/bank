package ch.schule.bank;

import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

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
        Booking b = new Booking(Instant.parse("1970-01-01T00:00:00Z"), 1000);
        assertEquals(Instant.ofEpochMilli(0), b.getInstant());
        assertEquals(1000, b.getAmount());
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Booking b;
        b = new Booking(100000);
        b.print();
        b = new Booking(1000000000);
        b.print();
    }
}
