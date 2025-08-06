package io.github.guilherme_s_barros.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        final var filePath = "test.txt";

        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Could not locate file location.");
        } catch (IOException exception) {
            System.out.println("Could not read the file.");
        }
    }
}
