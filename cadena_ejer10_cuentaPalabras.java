
import java.util.Scanner;

public class cadena_ejer10_cuentaPalabras {
        
  public static int contarPalabras(String cadena) {
        // Convertir la cadena y la palabra a minúsculas para hacer la comparación
        cadena = cadena.toLowerCase();
       
        String cadenaSin = quitaEspaciosTrim(cadena);
        if (cadenaSin.isEmpty()) {
            return 0;
        }
        String [] palabras =cadenaSin.split("\\s+");
        
        return palabras.length;
    }

  public static String quitaEspaciosTrim(String cadena) {
        int inicio = 0;
        int fin = cadena.length() - 1;

        while (inicio <= fin && cadena.charAt(inicio) == ' ') {// Encuentra el índice del primer carácter que no sea un espacio en blanco desde el inicio de la cadena
        inicio++;
        }
        
        while (fin >= inicio && cadena.charAt(fin) == ' ') {// Encuentra el índice del último carácter que no sea un espacio en blanco desde el final de la cadena
        fin--;
         }
    
        return cadena.substring(inicio, fin + 1);// Devuelve la cadena sin los espacios en blanco al principio y al final
    }       
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Escribe una frase: ");
        String cadena = in.nextLine();  
        
              
        int sumatorio = contarPalabras(cadena);
        System.out.println("La palabra \"" + cadena + "\" tiene " + sumatorio + " palabras.");
    }
}