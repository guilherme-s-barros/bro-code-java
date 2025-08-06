package io.github.guilherme_s_barros.extract_username_and_domain;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Enter your e-mail: ");
        var email = scanner.nextLine();

        var atSignIndex = email.indexOf('@');

        if (atSignIndex == -1) {
            System.out.println("Invalid e-mail");
            return;
        }

        var username = email.substring(0, atSignIndex);
        var domain = email.substring(atSignIndex + 1);

        // Or:
        // if (!email.contains("@")) {
        //    System.out.println("Invalid e-mail");
        //    return;
        // }
        //
        // var username = email.split("@")[0];
        // var domain = email.split("@")[1];

        System.out.println("Your username is " + username);
        System.out.println("Your domain is " + domain);

        scanner.close();
    }
}
