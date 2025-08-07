package io.github.guilherme_s_barros.dates_and_times;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class FormatDatesDifference {
    static String between(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            return formatFuture(to, from);
        }

        return formatPast(from, to);
    }

    static String between(String from, String to) {
        var fromDate = LocalDateTime.parse(from);
        var toDate = LocalDateTime.parse(to);

        if (fromDate.isAfter(toDate)) {
            return formatFuture(toDate, fromDate);
        }

        return formatPast(fromDate, toDate);
    }

    static String relativeToNow(LocalDateTime dateToCompare) {
        var now = LocalDateTime.now();

        if (dateToCompare.isAfter(now)) {
            return formatFuture(now, dateToCompare);
        }

        return formatPast(dateToCompare, now);
    }

    private static String formatPast(LocalDateTime from, LocalDateTime to) {
        var years = ChronoUnit.YEARS.between(from, to);

        if (years > 0) {
            return years == 1 ? "Ano passado" : (years + " anos atrás");
        }

        var months = ChronoUnit.MONTHS.between(from, to);

        if (months > 0) {
            return months == 1 ? "Mês passado" : (months + " meses atrás");
        }

        var days = ChronoUnit.DAYS.between(from, to);

        if (days > 0) {
            return days == 1 ? "Ontem"
                             : days == 2 ? "Anteontem" : (days + " dias atrás");
        }

        var hours = ChronoUnit.HOURS.between(from, to);

        if (hours > 0) {
            return hours + "h atrás";
        }

        var minutes = ChronoUnit.MINUTES.between(from, to);

        if (minutes > 0) {
            return minutes + "min atrás";
        }

        return "Agora mesmo";
    }

    private static String formatFuture(LocalDateTime from, LocalDateTime to) {
        var years = ChronoUnit.YEARS.between(from, to);

        if (years > 0) {
            return years == 1 ? "No próximo ano" : ("Em " + years + " anos");
        }

        var month = ChronoUnit.MONTHS.between(from, to);

        if (month > 0) {
            return month == 1 ? "No próximo mês" : ("Em " + month + " meses");
        }

        var days = ChronoUnit.DAYS.between(from, to);

        if (days > 0) {
            return days == 1 ? "Amanhã" : days == 2 ? "Depois de amanhã"
                                                    : ("Em " + days + " dias");
        }

        var hours = ChronoUnit.HOURS.between(from, to);

        if (hours > 0) {
            return "Em " + hours + "h";
        }

        var minutes = ChronoUnit.MINUTES.between(from, to);

        if (minutes > 0) {
            return "Em " + minutes + "min";
        }

        return "Daqui a pouco";
    }
}
