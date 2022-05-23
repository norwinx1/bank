package ch.schule;

import java.time.Instant;

public class Booking {
    private Instant instant;
    private long amount;

    public Booking(long amount) {
        this.instant = Instant.now();
        this.amount = amount;
    }

    public Booking(Instant instant, long amount) {
        this.instant = instant;
        this.amount = amount;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void print() {
        System.out.println(instant);
        System.out.println(amount);
    }
}
