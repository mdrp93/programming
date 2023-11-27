//Exercise 6.2 java

import java.util.Scanner;

public class libro_ch06_ejer2_squareroot{

    //exercise 2 - chapter 06

    final static double MIN= 0.001; 

    public static double squareRoot(double a){
        
        double x0 = a/2; 
        double x1 = 0;
        
        while (Math.abs(x0-x1)>MIN){
            x1 = x0;
            x0= (x0 + a/x0)/2;       
        }
        return x0; 
        }
    
    
    public static void main (String[] args){
       
    Scanner in = new Scanner(System.in);       
        
    System.out.println("Insert 5 numbers to calculate the square roots and press \"ENTER\" after each entry.");

    System.out.print("Number 1: ");
        while (!in.hasNextInt()) {   //The loop will keep running until the user inputs a numerical value. Once the characters are numeric, the program will continue executing
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            System.out.print("Number 1: ");
        }
        double a = in.nextInt();    

    System.out.print("Number 2: ");
        while (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            System.out.print("Number 2: ");
        }
        double b = in.nextInt();      
      
       
    System.out.print("Number 3: ");
        while (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            System.out.print("Number 3: ");
        }
        double c = in.nextInt(); 
              
    System.out.print("Number 4: ");
        while (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("ERROR IMPUT: "+word + " is not a number");
            System.out.print("Number 4: ");
        }
      double d = in.nextInt();

    System.out.print("Number 5: ");
        while (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("IMPUT ERROR: "+word + " is not a number");
            System.out.print("Number 5: ");
        }
       double e = in.nextInt(); 

    double x [] ={ a, b, c, d, e}; //value for string numbers --> calculate the sqrt

    for (int i=0; i<5; i++) { //iteratition
        System.out.printf("sqrt(%.2f) is %.2f\n", x[i], squareRoot(x[i]));   
        
                //A floating point number with two decimal places will be printed.
                //x[i] is the value of an element in an array named x, at position i and calculates the square root of x[i].
    }
    }
}




       
    