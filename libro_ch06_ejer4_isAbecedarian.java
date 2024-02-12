//Exercise 6.4 java
 /**
* @author Maria drp
*/
import java.util.Scanner;

public class libro_ch06_ejer4_isAbecedarian{

    public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;}

    public static boolean isAbc (String word){

         word=word.toLowerCase(); // Convert the word to lowercase to compare the letters

        for (int i = 1; i < word.length(); i++) { // Loop through each character of the word
       
            if (word.charAt(i) < word.charAt(i - 1)) {  // If the current character is less than the previous character in the alphabet.
                return false;                          //charAt() method to get the character at the current index  // the word is not alphabetic
        }
    }

        return true;
    }


  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    System.out.print("Insert a word: ");
        
        String word = in.nextLine();
        while (!onlyLetters(word)) {    //while onlyLetter is false
                System.err.println("IMPUT ERROR:" +word+ " is not a word or is unexpected character.");
                System.out.print("Insert a word: ");
                word = in.nextLine(); //the loop will continue running until the user enters a word that only contains letters.
             }

             if (isAbc(word)==true){
                System.out.println ("The word \"" + word + "\" IS abecedarian.");  
             }
             else {
                System.out.println ("The word \"" + word + "\" is NOT abecedarian."); 
             } 
}
}