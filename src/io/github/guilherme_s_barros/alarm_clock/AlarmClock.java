package io.github.guilherme_s_barros.alarm_clock;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    private final String alarmAudioPath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String alarmAudioPath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.alarmAudioPath = alarmAudioPath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        LocalTime now;

        while ((now = LocalTime.now()).isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                System.out.printf("\r%02d:%02d", now.getHour(),
                                  now.getMinute());
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }

        playAudio();
    }

    private void playAudio() {
        var audioURL = Program.class.getResource(alarmAudioPath);

        try {
            assert audioURL != null;
            try (var audioStream = AudioSystem.getAudioInputStream(audioURL);
                 var clip = AudioSystem.getClip()) {
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

                System.out.print("Press *ENTER* to stop the alarm");
                scanner.nextLine();
                clip.stop();
            }
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file format is not supported.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio is unavailable.");
        } catch (IOException e) {
            System.out.println("Error reading audio file.");
        } finally {
            scanner.close();
        }
    }
}
