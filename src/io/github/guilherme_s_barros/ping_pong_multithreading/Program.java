package io.github.guilherme_s_barros.ping_pong_multithreading;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        var pingThread = new Thread(new PingPongRunnable("PING"));
        var pongThread = new Thread(new PingPongRunnable("PONG"));

        System.out.println("GAME START!");

        pingThread.start();
        pongThread.start();

        pingThread.join();
        pongThread.join();

        System.out.println("GAME OVER!");
    }
}
