import java.util.Scanner;
import java.util.Random;

public class MyGuess2 {
    public static int mirror (int suppose, int number) {
        if(suppose<number){
         System.out.println("The guess is too LOW");}
 
         else if(suppose>number){
             System.out.println("The guess is too HIGH");
         }
         return 0;
     }

public static void main (String[] args){

Scanner in = new Scanner(System.in); 
Random random = new Random();
int number = (int) random.nextInt(50)+1;
int k = 3;

System.out.println("Hello, what is your name?");   
String name=in.nextLine();
System.out.println("Well, "+name+" I'm MAGICJAVA. ");
System.out.println();
System.out.print( "And I'm thinking of a number between 1 and 50 (including both), ");
System.out.println( "CAN YOU GUESS IT?");
System.out.println();
System.out.println( "You have " + k+ " tries to guess."); 
System.out.println();


//conditions
 while (k>1) {
    
    System.out.print( "     Insert a number: ");
    int guess = in.nextInt();
     System.out.println();
         
        
    if (guess == number) {
        System.out.println();
        System.out.println("CONGRATULATION!!");
        System.out.println();
        System.out.println("Your guess is: " + guess);
        System.out.println("My number is: " + number);
        break; 
         }
                         
    else if (guess > 51 || guess<0 || guess == 0 ) {
        System.out.println();
        System.out.println( "Type a number between 1 and 50 (including both)");
        System.out.println( "PLEASE, TRY AGAIN!");
        System.out.println("Tries left: "+ k + "/"+k);
        }
               
    else { 
        mirror(guess, number);
        System.out.println();
        System.out.println("Tries left: "+(k - 1) + "/"+k);
            
        k--;
    }}
    
        
    while (k==1){
        System.out.print( "     Insert a number: ");
        int guess=in.nextInt();
        
        if (guess == number) {
            System.out.println();
            System.out.println("CONGRATULATION!!");
            System.out.println();
            System.out.println("Your guess is: " + guess);
            System.out.println("My number is: " + number);
        break; }
    
        else if (guess > 51 || guess<0 || guess == 0 ) {
            System.out.println();
            System.out.println( "Type a number between 1 and 50 (including both)");
            System.out.println( "PLEASE, TRY AGAIN!");
            System.out.println("Tries left: "+(k - 1) + "/"+k);
             }

        else {
            System.out.println();
            System.out.println("GAME OVER!");    
            System.out.println();
            System.out.println("Your number is: " + guess);
            System.out.println();
            System.out.println("I was thinking of: " + number);
            System.out.println();
            System.out.println("You were off by: " + (guess - number)); 
            System.out.println();
            System.out.println("Don't worry, maybe next time you will guess!");
            System.out.println();
            break;
            }

 }    
 } }