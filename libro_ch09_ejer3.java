import java.math.BigInteger;
import java.util.Scanner;

public class libro_ch09_ejer3 {
    
    public static BigInteger pow(int x, int n) {
        if (n == 0) 
        return BigInteger.ONE;      //==BigInteger result = new BigInteger("1");  
        
        BigInteger t = pow(x, n / 2);            // find x to the n/2 recursively > t es la potencia de x elevado a la mitad del exponente n.
        
        if (n % 2 == 0) {           // if n is even, the result is t squared
            return t.multiply(t);
        } else {                         // if n is odd, the result is t squared times x
            return t.multiply(t).multiply(BigInteger.valueOf(x));
        }
    }

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);    

    System.out.println("Insert a number for base:");    
    System.out.print("Base: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Base: ");
    }
    int base = in.nextInt();

    System.out.println("Insert a number for exponent:");    
    System.out.print("Base: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Exponent: ");
    }
    int exponent = in.nextInt();
    
    BigInteger result = pow(base, exponent);

    System.out.println(base + " elevado a la potencia de " + exponent + " es: " + result);
}
}
