
import java.util.Scanner;

public class Temperature {

    public static void main(String[] args) {
      
        double celsius;
       Scanner in = new Scanner(System.in); 
        
        System.out.print("Enter a temperature in Celsius: ");
        celsius = in.nextDouble();
        
        double gradosF = ((celsius*9/5) +32);
        double fahren = gradosF;
        
       System.out.printf("%.1f C = %.1f F", celsius, fahren);
    }
}

