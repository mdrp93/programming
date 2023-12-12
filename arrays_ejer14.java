/*Ejercicio 14.
Escribe un programa que pida 8 palabras y las almacene en un array. A
continuación, las palabras correspondientes a colores se deben almacenar al
comienzo y las que no son colores a continuación. Puedes utilizar tantos arrays
auxiliares como quieras. Los colores que conoce el programa deben estar en
otro array y son los siguientes: verde, rojo, azul, amarillo, naranja, rosa, negro, blanco y morado.*/

import java.util.Arrays;
import java.util.Scanner;

public class arrays_ejer14 {

       public static boolean esColor(String palabra, String[] colores) {
        for (String color : colores) {
            if (palabra.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] palabras = new String[8];            // Pedir las palabras al usuario
        System.out.println("Introduce 8 palabras: ");
        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Palabara " + (i + 1) + ": ");
            palabras[i] = scanner.nextLine();
        }
       
        String[] colores = {"verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco", "morado"};  // Palabras que son colores
        
        String[] palabrasColores = new String[8];       // Arrays auxiliares para almacenar las palabras
        String[] palabrasNoColores = new String[8];
        
        int indexColores = 0; // Índice para recorrer palabrasColores
        int indexNoColores = 0; // Índice para recorrer palabrasNoColores
        
        for (int i = 0; i < palabras.length; i++) {         // Separar las palabras en los arrays correspondientes
            String palabra = palabras[i];
            if (esColor(palabra, colores)) {
                palabrasColores[indexColores] = palabra;
                indexColores++;
            } else {
                palabrasNoColores[indexNoColores] = palabra;
                indexNoColores++;
            }
        }
        
        Arrays.sort(palabrasColores, 0, indexColores);       // Ordenar los arrays resultantes
        Arrays.sort(palabrasNoColores, 0, indexNoColores);
        
        String[] palabrasOrdenadas = new String[8];      // Juntar los arrays en uno solo
        System.arraycopy(palabrasColores, 0, palabrasOrdenadas, 0, indexColores);
        System.arraycopy(palabrasNoColores, 0, palabrasOrdenadas, indexColores, indexNoColores);
        
        // Mostrar el array resultante
        System.out.println("Array resultado:");
        System.out.println(Arrays.toString(palabrasOrdenadas));
    }
 
}
    

