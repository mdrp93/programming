import java.util.Scanner;

public class libro_ch07_ejer7_letterHist {

    public static boolean onlyLetters(String palabra) { //The purpose of this method is to check if a given string contains only letters.
        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLetter(palabra.charAt(i))) { //with hte "Character.isLetter" method we can check if the current character is a letter.
                return false;
            }
        }
        return true;}
    public static int[] letterHist(String word) {
        
        int[] histogram = new int[26]; // Crear el histograma con 26 elementos (para las letras desde a hasta z)
        
        word = word.toLowerCase(); // Convertir todas las letras a minúsculas
        
        for (int i = 0; i < word.length(); i++) {
            
            if (Character.isLetter(word.charAt(i))) { // Verificar si el caracter es una letra
                int index = word.charAt(i) - 'a'; // Calcular el índice correspondiente en el histograma
                histogram[index]++; // Incrementar el contador correspondiente en el histograma
            }
        }
        
        return histogram;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        System.out.print("Enter the word you want to analyze under a histogram: ");
        String word = in.nextLine();
            while (!onlyLetters(word)) {    //while onlyLetter is false
                System.err.println("IMPUT ERROR:" +word+ " is not a word or is unexpected character.");
                System.out.print("Insert a word: ");
                word = in.nextLine(); //the loop will continue running until the user enters a word that only contains letters.
            }
        
        int[] histogram = letterHist(word);
        System.out.println("");
        System.out.println("The histogram for \""+word+"\" is: \n");
        System.out.println("Letter \t Times it appears");
         System.out.println("______\t ________________\n");
        // Imprimir el histograma
        for (int i = 0; i < histogram.length; i++) {
            char letter = (char) (i + 'a');
            System.out.println("  "+letter + "\t\t" + histogram[i]+" ");
        }
    }
    }
    

//El programa crea un método llamado letterHist que toma una cadena como parámetro y devuelve un histograma de las letras en la cadena. 