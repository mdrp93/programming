import java.util.Scanner;

public class Triangle {
public static boolean validateLengths(int side1, int side2, int side3) { 
        return side1 > 0 && side2 > 0 && side3 > 0; } //All sides must be greater than zero--> with && the result must be true.
    
public static boolean isTriangle(int side1, int side2, int side3) { 
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1; } 
        //Mathematically, for a triangle with sides of lengths a, b, and c, the triangular inequality can be written as: (a + b > c b + c > a c + a > b)

public static void main(String[] args) { Scanner in = new Scanner(System.in);
    
    int side1, side2, side3;
    
    System.out.print("Enter the first side of the triangle: "); 
    if (!in.hasNextInt()) {
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        return;
    }
    side1 = in.nextInt();
    
    System.out.print("Enter the second side of the triangle: "); 
    if (!in.hasNextInt()) {
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        return;
    }side2 = in.nextInt();
    
    System.out.print("Enter the third side of the triangle: "); 
    if (!in.hasNextInt()) {
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        return;
    }
    side3 = in.nextInt();
    
    if (validateLengths(side1, side2, side3)) { 
        
        if (isTriangle(side1, side2, side3)) { 
            System.out.println("It is possible to form a triangle with the given lengths."); } 
        else { System.out.println("It is not possible to form a triangle with the given lengths."); 
    } } 
    
    else { System.out.println("Error: lengths must be positive integers and non-zero."); 
    }}
    
    
    }


    //!! If any of the three lengths is greater than the sum of the other two, a triangle cannot be formed. !!