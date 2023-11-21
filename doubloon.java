import java.util.Scanner;

public class doubloon {
    
    public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;
    }

    public static boolean isDoubloon(String word) {
        
        word = word.toLowerCase();
        int len = word.length(); 
        int count = 0;
        boolean retVal = false;

        for (int i = 0; i < len; i++) { 
            char letra = word.charAt(i); 
            for (int j = i + 1; j < len; j++) { 
                if (letra == word.charAt(j)) { 
                    count++; } } }
        
       if(count == len / 2) {retVal=true; }
       
       return retVal;}
    
    public static void countDifferentLetters(String palabra) {
        int dif = 0;
        int equals = 0;
        
            for (int i = 0; i < palabra.length(); i++) {
                char letra = palabra.charAt(i);
                boolean same = false;
        
                for (int j = i + 1; j < palabra.length(); j++) {
                    if (letra == palabra.charAt(j)) {
                        same = true;
                        break;
                    }
                }
            if (same) {equals++;} 
            else {dif++;}
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
