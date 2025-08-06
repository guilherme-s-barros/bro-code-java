package io.github.guilherme_s_barros.compound_interest_calculator;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Compound interest calculator\n");

        System.out.print("Enter the principal amount: ");
        var principalAmount = scanner.nextDouble();

        System.out.print("Enter the interest rate (in %): ");
        var interestRate = scanner.nextDouble();

        // Convert percentage to decimal
        var interestRateInDecimal = interestRate / 100;

        System.out.print("Enter the # of times compounded per years: ");
        var timesCompounded = scanner.nextInt();

        System.out.print("Enter the # of years: ");
        var years = scanner.nextInt();

        // A = P(1 + r/n)^(nt)
        var amount = principalAmount *
                     Math.pow(1 + interestRateInDecimal / timesCompounded,
                              timesCompounded * years);

        System.out.printf("The amount after %d years is $%,.2f", years, amount);

        scanner.close();
    }
}
