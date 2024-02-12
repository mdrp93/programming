
/**
* @author Maria drp
*/
import java.util.Scanner;

public class cadena_ejer18_sustituyePalabra{
        
    public static String sustituyePalabra(String cadena, String palabra1, String palabra2) {
        cadena=cadena.toUpperCase(); //paso todo a mayúsculas para evitar problemas de búsqueda
        palabra1=palabra1.toUpperCase();
        palabra2=palabra2.toUpperCase();

        String resultado = cadena.replaceAll(palabra1, palabra2); //uso el método .replaceAll que cambia una palabra por otra.
       
          
        return resultado;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Writte the sentences: ");
        String frase = in.nextLine();   
           
        System.out.println("Write the word to be replaced: ");
        String palabra1 = in.nextLine();
           
        System.out.println("Write the new word: ");
        String palabra2 = in.nextLine();
      
        String solution = sustituyePalabra(frase, palabra1, palabra2);
        System.out.println(solution);
            
        frase.replaceAll(palabra1,palabra2);
        }
    }


   