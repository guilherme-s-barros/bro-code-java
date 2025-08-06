package io.github.guilherme_s_barros.weight_convertion;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Weight Conversion Program\n");

        System.out.println("1: Convert lbs to kgs");
        System.out.println("2: Convert kgs to lbs\n");

        System.out.print("Choose an option: ");
        var userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1 -> {
                System.out.print("Enter the weight in lbs: ");
                var weight = scanner.nextDouble();

                var weightConvertedToKgs = weight / 2.205;

                System.out.printf("The weight in kgs is %,.2f\n",
                                  weightConvertedToKgs);
            }

            case 2 -> {
                System.out.print("Enter the weight in kgs: ");
                var weight = scanner.nextDouble();

                var weightConvertedToLbs = weight * 2.205;

                System.out.printf("The weight in lbs is %,.2f\n",
                                  weightConvertedToLbs);
            }

            default -> System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
