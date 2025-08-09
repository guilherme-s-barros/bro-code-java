package io.github.guilherme_s_barros.alarm_clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:MM): ");
                alarmTime = LocalTime.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException exception) {
                System.out.println("Invalid format. Please use HH:MM");
            }
        }

        System.out.println("Alarm set for " + alarmTime);
        var alarm = new Thread(new AlarmClock(alarmTime, "alarm.wav", scanner));

        alarm.start();
    }
}
