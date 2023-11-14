import java.util.Scanner;


public class numVocales{

    public static int numeroVocales(String cadena) {
        int cont = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            if (Character.toLowerCase(caracter) == 'a' || Character.toLowerCase(caracter) == 'e' ||
                Character.toLowerCase(caracter) == 'i' || Character.toLowerCase(caracter) == 'o' ||
                Character.toLowerCase(caracter) == 'u') {
                cont++;
            }
        }

        return cont;
            
        }
     public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Insert a word: ");
        String palabra = in.nextLine();
        int numero = numeroVocales(palabra);
        System.out.println("Number of vowels: " + numero);
        }
    
    }
    