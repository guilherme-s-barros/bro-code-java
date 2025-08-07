package io.github.guilherme_s_barros.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class Program {
    public static void main(String[] args) {
        var timer = new Timer();

        var task = new TimerTask() {
            int count = 3;

            @Override
            public void run() {
                System.out.println("Hello!");
                count--;

                if (count <= 0) {
                    System.out.println("TASK COMPLETE!");
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 0, 1000);
    }
}
