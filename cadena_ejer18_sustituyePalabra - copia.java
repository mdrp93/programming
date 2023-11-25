import java.util.Scanner;

public class cadena_ejer18_sustituyePalabra{
        
    public static String sustituyePalabra(String cadena, String palabra1, String palabra2) {
        cadena=cadena.toUpperCase(); //paso todo a mayúsculas para evitar problemas de búsqueda
        palabra1=palabra1.toUpperCase();
        palabra2=palabra2.toUpperCase();

        String resultado = cadena.replaceAll(palabra1, palabra2); //uso el método .replace que cambia una palabra por otra.
       
          
        return resultado;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Escribe una frase: ");
        String frase = in.nextLine();   
           
        System.out.println("Escribe la palabra que se va a sustituir: ");
        String palabra1 = in.nextLine();
           
        System.out.println("Escribe la palabra nueva: ");
        String palabra2 = in.nextLine();
      
        String solution = sustituyePalabra(frase, palabra1, palabra2);
        System.out.println(solution);
            
        frase.replaceAll(palabra1,palabra2);
        }
    }


   