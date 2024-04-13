/**
* @author Maria drp
*/

//import java.util.Scanner;

public class excepcionesPropias {

    public static boolean letrasynumeros(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))||!Character.isDigit(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;}
    
}

//EJEMPLO DE MAIN:
//public static void main (){ 
   // Scanner in = new Scanner(System.in); 
        
        //System.out.println();//añadir lo que se quiera ;
        //String frase = in.nextLine();   
           // while(!letrasynumeros(frase)) {
           // System.err.println("IMPUT ERROR: " +frase+ " includes unexpected character.");
              //  System.out.print(("Escribe la palabra que se va a sustituir: "));
                //frase= in.nextLine();
      //  }
//}


public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;
    }


//EJEMPLO DE MAIN DE ONLYLETTER:
//String word = in.nextLine();
       // System.out.println();
           // while (!onlyLetters(word)) {    //while onlyLetter is false
               // System.err.println("IMPUT ERROR: " +word+ " is not a word or is unexpected character.");
                //System.out.print("Insert a word: ");
                //word = in.nextLine(); //the loop will continue running until the user enters a word that only contains letters.
            //}