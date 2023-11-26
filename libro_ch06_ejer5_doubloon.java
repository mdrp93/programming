//Exercise 6.5 java

import java.util.Scanner;

public class libro_ch06_ejer5_doubloon {
    
    public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;
    }

    public static boolean isDoubloon(String word) { 
        
        word = word.toLowerCase(); //the function converts the word to lowercase 
        int len = word.length(); 
        int count = 0;  //This variable is used to count how many times a letter is repeated in the word.
        boolean retVal = false; //will be used to store the final result of whether the word is a doubloon or not.

        for (int i = 0; i < len; i++) {  //In each iteration, the current letter of the word is obtained using the "charAt(i)" where "i" is the index of the current letter.
            char letra = word.charAt(i); 
            for (int j = i + 1; j < len; j++) { //remaining letters after the current letter.
                if (letra == word.charAt(j)) { //the current letter is compared to the letter at index "j".
                    count++; } } } //If the two letters are the same, the variable "count" is incremented by one.
        
       if(count == len / 2) {retVal=true; } //checked if "count" is equal to half the length of the word. If so, true is assigned to retVal.
       
       return retVal;}
    
    public static void countDifferentLetters(String palabra) {
        int dif = 0;
        int equals = 0;
        
            for (int i = 0; i < palabra.length(); i++) {
                char letra = palabra.charAt(i); //variable "letter" of type char is declared that stores the letter in position "i" of the word.
                boolean same = false;
        
                for (int j = i + 1; j < palabra.length(); j++) { //Another "for" loop is started to compare the current letter with the next letters in the word.
                    if (letra == palabra.charAt(j)) { // If the letter is equal to any of the following letters, the value of "same" is changed to true and the loop is broken.
                        same = true;
                        break;
                    }
                }
            if (same) {equals++;}  //If "same" is true, the "equals" counter is incremented.
            else {dif++;} //If "same" is false, the "dif" counter is incremented.
            }
        
        System.out.println("The word \"" + palabra + "\" contains " + dif + " different letters and " + equals+" repeated letters.");
        }
    
       
     public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        
        System.out.println();
        System.out.print("Insert a word: ");
        
        String word = in.nextLine();
        System.out.println();
            while (!onlyLetters(word)) {    //while onlyLetter is false
                System.err.println("ERROR INPUT: " +word+ " is not a word or is unexpected character.");
                System.out.print("Insert a word: ");
                word = in.nextLine(); //the loop will continue running until the user enters a word that only contains letters.
            }
            if (isDoubloon(word)==true){
                System.out.println ("The word \"" + word + "\" IS a doubloon.");  
            }
            else {
                System.out.println ("The word \"" + word + "\" is NOT a doubloon."); 
            } 
        System.out.println();
        countDifferentLetters(word);
        System.out.println();
    }
}
