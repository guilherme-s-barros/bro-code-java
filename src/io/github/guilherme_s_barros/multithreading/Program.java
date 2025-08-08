package io.github.guilherme_s_barros.multithreading;

public class Program {
    public static void main(String[] args) {
        System.out.println("Main thread start");

        var thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() +
                                   " says: Fetching user data...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +
                                   " says: User data fetched successfully.");
            } catch (InterruptedException e) {
                System.out.println(
                        Thread.currentThread().getName() + " was interrupted.");
            }
        });

        var thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() +
                                   " says: Writing file...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +
                                   " says: File written successfully.");
            } catch (InterruptedException e) {
                System.out.println(
                        Thread.currentThread().getName() + " was interrupted.");
            }
        });

        var thread3 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() +
                                   " says: Daemon thread start.");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() +
                                   " says: Daemon thread end.");
            } catch (InterruptedException e) {
                System.out.println(
                        Thread.currentThread().getName() + " was interrupted.");
            }
        });

        thread3.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Main thread end");
    }
}
