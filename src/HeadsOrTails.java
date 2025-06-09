import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeadsOrTails {
    public static void main(String[] args) {
        var random = new Random();
        var scanner = new Scanner(System.in);

        String[] validOptions = {"heads", "tails"};

        System.out.println("Heads or Tails\n");

        System.out.print("Enter your choice between heads or tails: ");
        var userChoice = scanner.nextLine().trim();

        var didUserChooseAnInvalidOption = Arrays.stream(validOptions)
                                                 .noneMatch(
                                                         option -> option.equals(
                                                                 userChoice));

        if (didUserChooseAnInvalidOption) {
            System.out.println("Invalid choice!");
            return;
        }

        var isHeads = random.nextBoolean();
        var correctChoice = isHeads ? "heads" : "tails";

        System.out.println("Is " + correctChoice);

        if (userChoice.equals(correctChoice)) {
            System.out.println("Congratulations, you have chosen right!");
            return;
        }

        System.out.println("You have chosen wrong! Better luck next time.");

        scanner.close();
    }
}
