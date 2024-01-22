import java.util.Scanner;

public class libro_ch08_ejer5 {


    public static double power(double x, int n) {
        if (n == 0) {
            // Caso base, cualquier valor elevado a la potencia cero es 1
            return 1.0;
        } else if (n < 0) {
            // Si n es negativo, calcula el recíproco y niega la potencia para n positivo
            return 1.0 / power(x, -n);
        } else if (n % 2 == 0) {
            //Si n es par, utiliza la optimización x^n = (x^(n/2))^2
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else {
            //Si n es impar, utiliza la definición recursiva x^n = x * x^(n-1)
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);       
    
    System.out.println("Insert a number for base x:");    
    System.out.print("Value x: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Insert a number for x: ");
    }
    double base = in.nextInt();

    System.out.println("Insert a number for exponent n: ");    
    System.out.print("Value n: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Insert a number for n: ");
    }
    int exponent = in.nextInt();

        double result = power(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
    }
