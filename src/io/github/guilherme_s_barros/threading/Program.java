package io.github.guilherme_s_barros.threading;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var countdownRunnable = new CountdownRunnable();
        var countdownThread = new Thread(countdownRunnable);
        countdownThread.setDaemon(true);

        System.out.println("You have 10 seconds to enter your name.");
        countdownThread.start();

        System.out.print("Enter your name: ");
        var name = scanner.nextLine();

        System.out.println("Hello, " + name);

        scanner.close();
    }
}
