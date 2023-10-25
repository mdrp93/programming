import java.util.Scanner;
import java.util.Random;

public class Guessmynumber {
    public static void main (String[] args){
       
    Random random = new Random();
    int number = (int) random.nextInt(50)+1;
    int k = 5;
    
    Scanner in = new Scanner(System.in);       
    System.out.println( "I'm thinking of a number between 1 and 50 (including both).");
    System.out.println( "Can you guess what it is?\nYou have 5 tries to guess.");        
   
    while (k>1) {
        System.out.print( "     Insert a number: ");
        int guess = in.nextInt();
            
            if (guess == number) {
                System.out.println("Congratulation!!");
                System.out.println("Your guess is: " + guess);
                System.out.println("The number I was thinking of is: " + number);
                break; 
            }
            else if (guess > 51) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
            }
            
            else if (guess<0 ) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
                }
            else if (guess == 0) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
                }
            else {System.out.println("You have " + (k - 1) + " tries left.");
        
            k--;
            }}
    
        while (k==1){
            System.out.print( "     Insert a number: ");
            int guess=in.nextInt();
            if (guess == number) {
                
                System.out.println("Congratulation!!");
                System.out.println("Your guess is: " + guess);
                System.out.println("The number I was thinking of is: " + number);
                k--;
                break; }

            else if (guess > 51) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
              
            }
            else if (guess == 0) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
                }

            else if (guess<0 ) {
                System.out.println( "Type a number between 1 and 50 (including both)");
                System.out.println( "Please, try again!");
                System.out.println("You have " + (k) + " tries left.");
                }
            else {
                System.out.println("Ohh!! You ran out of tries!");    
                System.out.println("Your number is: " + guess);
                System.out.println("I was thinking of: " + number);
                System.out.println("     You were off by: " + (guess - number)); 
                System.out.println("Don't worry, maybe next time you will guess!");
                break;
            }}
          } }    
    
    