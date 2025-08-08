package io.github.guilherme_s_barros.enums;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Enter a day of the week: ");
            var response = scanner.nextLine().toUpperCase();

            var day = Day.valueOf(response);

            switch (day) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY ->
                        System.out.println("It is a weekday");
                case SATURDAY, SUNDAY ->
                        System.out.println("It is the weekend");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Please enter a valid day.");
        }
    }
}
