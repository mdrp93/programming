/*Ejercicio 16
Escribe un programa que rellene un array de 20 elementos con números enteros aleatorios comprendidos entre 0 y 400 (ambos incluidos). A continuación
el programa mostrará el array y preguntará si el usuario quiere resaltar los múltiplos de 5 o los múltiplos de 7. Seguidamente se volverá a mostrar 
el array escribiendo los números que se quieren resaltar entre corchetes.
*/

/**
* @author Maria drp
*/

import java.util.Random;
import java.util.Scanner;

public class arrays_ejer16 {
    
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        
        // Rellena el array con números aleatorios entre 0 y 400
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(401);
        }
        
        // Muestra el array original
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Pregunta al usuario qué números desea resaltar
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Qué números quiere resaltar? (1 - los múltiplos de 5, 2 - los múltiplos de 7): ");
        int opcion = scanner.nextInt();
        
        // Muestra el array con los números resaltados
        System.out.println("Array con números resaltados:");
        for (int num : array) {
            if (opcion == 1 && num % 5 == 0) {
                System.out.print("[" + num + "] ");
            } else if (opcion == 2 && num % 7 == 0) {
                System.out.print("[" + num + "] ");
            } else {
                System.out.print(num + " ");
            }
        }
    }
}
