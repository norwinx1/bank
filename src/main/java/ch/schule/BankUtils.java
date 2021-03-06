package ch.schule;

import java.text.DecimalFormat;
import java.time.Instant;

public class BankUtils {
    /**
     * Formatiere f�r zweistellige Zahlen.
     */
    public static final DecimalFormat TWO_DIGIT_FORMAT
            = new DecimalFormat("00");

    /**
     * Formatierer f�r Betr�ge.
     */
    public static final DecimalFormat AMOUNT_FORMAT
            = new DecimalFormat("#,##0.00");

    /**
     * Formatiert ein Banktag-Datum.
     *
     * @param date das zu formatierende Datum
     * @return String das formatierte Datum
     */
    public static String formatBankDate(int date) {
        int year = 1970 + date / 360;

        date %= 360;

        int month = 1 + date / 30;
        int day = 1 + date % 30;

        return TWO_DIGIT_FORMAT.format(day) + "."
                + TWO_DIGIT_FORMAT.format(month) + "."
                + year;
    }

    /**
     * Formatiert einen Betrag
     *
     * @param amount der zu formatierende Betrag in Millirappen
     * @return String der formatierte Betrag
     */
    public static String formatAmount(long amount) {
        String s = AMOUNT_FORMAT.format(amount / 100000.0);

        while (s.length() < 10)
            s = " " + s;

        return s;
    }

    public static boolean compareInstantForMonthAndYear(Instant instantMonthYear, Instant timestamp) {
        String[] split = timestamp.toString().split("-");
        Instant instantMonthYearGenerated = Instant.parse(split[0] + "-" + split[1] + "-01T00:00:00Z");
        return instantMonthYearGenerated.equals(instantMonthYear);
    }
}
