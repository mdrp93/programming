import java.util.Scanner;

public class libro_ch07_ejer7_letterHist {

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
        int[] histogram = letterHist(word);
    
        System.out.print("The histogram for \""+word+"\" is: ");
        // Imprimir el histograma
        for (int i = 0; i < histogram.length; i++) {
            char letter = (char) (i + 'a');
            System.out.print(letter + ":" + histogram[i]+" ");
        }
    }
    }
    

//El programa crea un método llamado letterHist que toma una cadena como parámetro y devuelve un histograma de las letras en la cadena. 