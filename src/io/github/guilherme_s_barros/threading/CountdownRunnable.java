package io.github.guilherme_s_barros.threading;

public class CountdownRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                System.out.println("Thread was interrupted.");
            }

            if (i == 10) {
                System.out.println("Times's up!");
                System.exit(0);
            }
        }
    }
}
