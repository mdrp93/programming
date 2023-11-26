import java.util.Scanner;

public class libro_ch05_ejer6_quadratic {
    public static void main(String[] args) {
        // Prompt the user to input values for a, b, and c
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            return;
        }

        int a = in.nextInt();

        System.out.print("Enter the value of b: ");
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            return;}
            
        int b = in.nextInt();

        System.out.print("Enter the value of c: ");
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            return;
        }
        int c = in.nextInt();

        // Compute the discriminant
        int d = (b * b) - (4 * a * c);

      
        if (d < 0) {
            System.out.println("The equation has no real roots.");
        }
        // Check if the equation has one solution
        else if (d== 0) {
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