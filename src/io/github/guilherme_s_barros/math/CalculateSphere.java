package io.github.guilherme_s_barros.math;

import java.util.Scanner;

public class CalculateSphere {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        var radius = scanner.nextDouble();

        var circumference = 2 * Math.PI * radius;
        var area = Math.PI * Math.pow(radius, 2);
        var volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        System.out.printf("The circumference is: %.2fcm\n", circumference);
        System.out.printf("The area is: %.2fcm²\n", area);
        System.out.printf("The volume is: %.2fcm³\n", volume);

        scanner.close();
    }
}
