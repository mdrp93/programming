/**
* @author Maria drp
*/
import java.util.Scanner;

public class libro_ch04_ejer6_multadd {


public static double multadd(double a, double b, double c){
System.out.println(a*b+c);
return 0.0;}

public static void expSum(double x) {
    double a = x;                   //a is equal x to resolve the problem
    double b = Math.exp(-x);            // b is equal to exponent:  -x
    double c = Math.sqrt(1.0 - b); //c is equal to the square root of (1-b)
    multadd(a, b, c);                   // to resolve this equation [xe^(-x) + sqrt(1 - e^(-x))] we can used the other method multadd (a*b+c)
}



public static void main(String[] args) {
        System.out.print("Result to (1*2+3)= ");
        multadd (1.0, 2.0, 3.0) ;
        System.out.println(" ");
      
        double a1 = Math.cos(Math.PI/4.0);      //result to a1 (cos (pi/4)) is a in method multadd
		double b1 =  1.0/2.0;       // division to take half of a and multiply it in multadd (a*b)
		double c1 = Math.sin(Math.PI/4.0);       //result to c1 (sin(pi/4)) is c in method multadd
		System.out.print("sin(pi/4) + cos(pi/4)/2 = "); 
        multadd (a1, b1, c1); 
        System.out.println(" ");

        double a2= 1.0;
        double b2 = Math.log(10);
        double c2 = Math.log ( 20);
        System.out.print("log(10)+log(20)= ");
        multadd (a2, b2, c2);  
        System.out.println(" ");
        
        System.out.print("Please insert number to calculate x in this equation:[xe^(-x) + sqrt(1 - e^(-x))] \n x = ");
        Scanner in = new Scanner(System.in); 
        if (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("IMPUT ERROR: "+word + " is not a number");
            return;
        }
        double x = in.nextInt();
        expSum (x);

}}