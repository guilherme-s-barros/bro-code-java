import java.util.Scanner;

public class BankingProgram {
    private static double balance = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var isRunning = true;

        while (isRunning) {
            System.out.println("***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");
            System.out.print("Enter your choice (1-4): ");
            var choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("***************************");
        System.out.println("Thank you! Have a nice day!");
        System.out.println("***************************");

        scanner.close();
    }

    public static void showBalance() {
        System.out.printf("Your balance: $%.2f\n", balance);
    }

    public static void deposit() {
        System.out.print("Enter an amount to be deposited: ");
        var amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Amount can't be negative.");
        } else {
            balance += amount;
        }
    }

    public static void withdraw() {
        System.out.print("Enter an amount to be withdrawn: ");
        var amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("INSUFFICIENT FUNDS.");
        } else if (amount < 0) {
            System.out.println("Amount can't be negative.");
        } else {
            balance -= amount;
        }
    }
}
