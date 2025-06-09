import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculate area of rectangle\n");

        System.out.print("Enter width of rectangle (meters): ");
        var width = scanner.nextDouble();

        System.out.print("Enter height of rectangle (meters): ");
        var height = scanner.nextDouble();

        var area = width * height;

        System.out.println("Area of rectangle is: " + area + "m^2");

        scanner.close();
    }
}
