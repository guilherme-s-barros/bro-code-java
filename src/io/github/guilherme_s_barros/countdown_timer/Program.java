package io.github.guilherme_s_barros.countdown_timer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Program {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var timer = new Timer();

        System.out.print("Enter the # of seconds to countdown from: ");
        var response = scanner.nextInt();

        var task = new TimerTask() {
            int countdownInSeconds = response;

            @Override
            public void run() {
                if (countdownInSeconds <= 0) {
                    System.out.println("COUNTDOWN FINISHED!");
                    timer.cancel();
                }

                System.out.println(countdownInSeconds);
                countdownInSeconds--;
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

        scanner.close();
    }
}
