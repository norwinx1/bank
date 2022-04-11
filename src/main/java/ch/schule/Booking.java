package ch.schule;

import java.time.LocalDate;

public class Booking {
    private LocalDate date;
    private long amount;

    public Booking(LocalDate date, long amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void print() {
        System.out.println(date);
        System.out.println(amount);
    }
}
