package io.github.guilherme_s_barros.hangman_game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        var file = Program.class.getResourceAsStream("words.txt");
        var words = new ArrayList<String>();

        try {
            assert file != null;
            try (var reader = new BufferedReader(new InputStreamReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    words.add(line.trim());
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Could not find file.");
        } catch (IOException exception) {
            System.out.println("Something went wrong.");
        }

        var random = new Random();
        var word = words.get(random.nextInt(words.size()));

        var wordState = new char[word.length()];
        var guesses = new ArrayList<Character>();
        var wrongGuesses = 0;
        var won = false;
        var scanner = new Scanner(System.in);

        Arrays.fill(wordState, '_');

        System.out.println("****************************");
        System.out.println("Welcome to Java Hangman Game");
        System.out.println("****************************");

        while (wrongGuesses < 6 && !won) {
            printHangmanArt(wrongGuesses);

            if (!guesses.isEmpty()) {
                System.out.print("Your guesses: ");
                System.out.println(guesses.stream().map(String::valueOf)
                                          .collect(Collectors.joining(", ")));
                System.out.println();
            }

            System.out.print("Word: ");

            for (char c : wordState) {
                System.out.print(c + " ");
            }

            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (guesses.contains(guess)) {
                System.out.println("This letter has already been guessed!");
                continue;
            }

            guesses.add(guess);

            var matches = 0;

            for (int i = 0; i < wordState.length; i++) {
                if (guess == word.charAt(i)) {
                    wordState[i] = guess;
                    matches++;
                }
            }

            if (matches > 0) {
                System.out.println("Correct guess!");

                if (!String.valueOf(wordState).contains("_")) {
                    won = true;
                }
            } else {
                System.out.println("Wrong guess!");
                wrongGuesses++;
            }
        }

        printHangmanArt(wrongGuesses);
        System.out.println("GAME OVER!");

        if (won) {
            System.out.println("You win! The word was: " + word);
        } else {
            System.out.println("You lose! The word was: " + word);
        }

        scanner.close();
    }

    static void printHangmanArt(int wrongGuesses) {
        switch (wrongGuesses) {
            case 0 -> System.out.println("""
                                         
                                         
                                         
                                         """);

            case 1 -> System.out.println("""
                                          o
                                         
                                         
                                         """);

            case 2 -> System.out.println("""
                                          o
                                          |
                                         
                                         """);

            case 3 -> System.out.println("""
                                          o
                                         /|
                                         
                                         """);

            case 4 -> System.out.println("""
                                          o
                                         /|\\
                                         
                                         """);

            case 5 -> System.out.println("""
                                          o
                                         /|\\
                                         /
                                         """);

            case 6 -> System.out.println("""
                                          o
                                         /|\\
                                         / \\
                                         """);

            default -> System.out.println("Invalid input");
        }
        ;
    }
}
