/**
* @author Maria drp
*/

//EXERCISE STRINGS 2: Escribe la función “numeroVocales” a la que le pasamos una cadena y nos devuelve el número de vocales que hay en la cadena.
 
import java.util.Scanner;

public class cadena_ejer2_numVocales{

    public static int numeroVocales(String cadena) {
        int cont = 0;

        for (int i = 0; i < cadena.length(); i++) { //I use for a loop to iterate through each character in the string.  It starts from the index 0 until it is the length of the string.  
            char caracter = cadena.charAt(i); //charAt() method to get the character at the current index

            if (Character.toLowerCase(caracter) == 'a' || Character.toLowerCase(caracter) == 'e' || //it converts the character to lowercase and compares the lowercase character to 'a', 'e', 'i', 'o', and 'u' to check if it is a vowel.
                Character.toLowerCase(caracter) == 'i' || Character.toLowerCase(caracter) == 'o' || // because it not equal 'A' and 'a'.
                Character.toLowerCase(caracter) == 'u') {
                cont++;
            }
        }
        return cont;   //that return represents the total count of vowels in the string.

        }
    
    public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
            for (int i = 0; i < palabra.length(); i++) {
                if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                    return false;
                }
            }
            return true;
        }

   
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String word;

        System.out.print("Insert a word: ");
        word = in.nextLine();

            while (!onlyLetters(word)) {    //while onlyLetter is false
                System.err.println("IMPUT ERROR: " +word+ " is not a word or is unexpected character.");
                System.out.print("Insert a word: ");
                word = in.nextLine(); //the loop will continue running until the user enters a word that only contains letters.
             }

        int number = numeroVocales(word);  //number is a total of vowels
        System.out.println("Number of vowels: " + number);
    }
}