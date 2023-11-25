import java.util.Scanner;

public class cadena_ejer16_vecesPalabra{
        
  public static int vecesPalabra(String cadena, String palabra) {
        // Convertir la cadena y la palabra a minúsculas para hacer la comparación
        cadena = cadena.toLowerCase();
        palabra = palabra.toLowerCase();
        
        int contador = 0;
        int indice = 0;
        
        // Iterar mientras se encuentre la palabra en la cadena con indexOf. 
        while ((indice = cadena.indexOf(palabra, indice)) != -1) {  // El método indexOf devuelve la posición la palabra en la cadena, o -1 si no se encuentra--> el -1 es como si fuera un false. 
            contador++;
            indice += palabra.length(); //sigue desde la siguiente posición.
        }
        
        return contador;
    }  
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Escribe una frase: ");
        String cadena = in.nextLine();  
        
        System.out.println("Escribe la palabra que se quiere buscar: ");
        String palabra = in.nextLine();
        
        int veces = vecesPalabra(cadena, palabra);
        System.out.println("La palabra \"" + palabra + "\" aparece " + veces + " veces en la cadena.");
    }
}