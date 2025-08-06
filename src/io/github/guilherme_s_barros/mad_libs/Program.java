package io.github.guilherme_s_barros.mad_libs;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String adjective1, noun1, adjective2, verb1, adjective3;

        System.out.println("Mad libs game\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an adjective (description of something): ");
        adjective1 = scanner.nextLine();

        System.out.print("Enter a noun (something): ");
        noun1 = scanner.nextLine();

        System.out.print("Enter another adjective: ");
        adjective2 = scanner.nextLine();


        System.out.print("Enter a verb end with -ing (action of something): ");
        verb1 = scanner.nextLine();

        System.out.print("Enter another adjective: ");
        adjective3 = scanner.nextLine();

        System.out.println("\nToday I went to a " + adjective1 + " zoo.");
        System.out.println("In an exhibit, I saw a " + noun1 + ".");
        System.out.println(
                noun1 + " was " + adjective2 + " and " + verb1 + "!");
        System.out.println("I was " + adjective3 + "!");

        scanner.close();
    }
}
