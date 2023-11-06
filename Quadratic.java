import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        // Prompt the user to input values for a, b, and c
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();

        // Compute the discriminant
        int d = (b * b) - (4 * a * c);

      
        if (d < 0) {
            System.out.println("The equation has no real roots.");
        }
        // Check if the equation has one solution
        else if (d == 0) {
            double x = -b / (2.0 * a);
            System.out.println("The equation has one root: " + x);
        }
        // Compute and display the two solutions if the equation has two solutions
        else {
            double x1 = (-b + Math.sqrt(d)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(d)) / (2.0 * a);
            System.out.println("The equation has two roots: " + x1 + " and " + x2);
        }
    }
}