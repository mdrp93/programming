import java.util.Scanner;

public class cadena_ejer09_sustituyeCaracter {
    

    public static String SustituyeCaracter(String cadena, char caracter1, char caracter2) {
       
        
        StringBuilder nuevaCadena = new StringBuilder(); // Creamos una nueva cadena para almacenar el resultado de la sustitución

        for (int i = 0; i < cadena.length(); i++) { // Iteramos sobre cada carácter de la cadena original
            char caracterActual = cadena.charAt(i);

            // Si el carácter actual es igual al carácter que queremos sustituir, lo reemplazamos por el segundo carácter
            if (caracterActual == caracter1) {
                nuevaCadena.append(caracter2);
            } else {
                // Si no es el carácter que queremos sustituir, lo agregamos sin cambios a la nueva cadena
                nuevaCadena.append(caracterActual);
            }
        }

        // Convertimos el StringBuilder a un String y lo retornamos
        return nuevaCadena.toString();
        
    }       
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a word: ");
        String cadenaOriginal = in.nextLine();  
        
        System.out.print("Write a caracter to be replaced: ");
        char caracter1= in.nextLine().charAt(0);  

        System.out.print("Write a caracter to replace: ");
        char caracter2= in.nextLine().charAt(0);  
       
        String nuevaCadena = SustituyeCaracter(cadenaOriginal, caracter1, caracter2);
        System.out.println(nuevaCadena);
    }
        
    }
