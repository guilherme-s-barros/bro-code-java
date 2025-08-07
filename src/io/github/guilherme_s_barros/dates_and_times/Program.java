package io.github.guilherme_s_barros.dates_and_times;

import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        var date1 = LocalDateTime.of(2025, 1, 1, 0, 0);
        var date2 = LocalDateTime.of(2025, 1, 5, 0, 0);

        System.out.println(
                "Difference between dates (2025-01-01 - 2025-01-05): " +
                FormatDatesDifference.between(date1, date2));

        System.out.println(
                "Difference between dates string (2025-01-05 - 2025-01-01): " +
                FormatDatesDifference.between("2025-01-05T00:00",
                                              "2025-01-01T00:00"));

        var past = LocalDateTime.of(2025, 1, 1, 0, 0);

        System.out.println("Difference relative to now (past): " +
                           FormatDatesDifference.relativeToNow(past));

        var future = LocalDateTime.of(2026, 1, 1, 0, 0);

        System.out.println("Difference relative to now (future): " +
                           FormatDatesDifference.relativeToNow(future));
    }
}
