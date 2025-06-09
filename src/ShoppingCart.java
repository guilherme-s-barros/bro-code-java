import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        String item;
        double price, total;
        int quantity;

        System.out.println("Shopping cart\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("What item would you like to buy?\n> ");
        item = scanner.nextLine();

        System.out.print("What is the price for each?\n> ");
        price = scanner.nextDouble();

        System.out.print("How many would you like?\n> ");
        quantity = scanner.nextInt();

        total = price * quantity;

        System.out.println("You have bought " + quantity + " " + item + "/s");
        System.out.println("Your total is $" + total);

        scanner.close();
    }
}
