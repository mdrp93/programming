/*Ejercicio 13
Escribe un programa que rellene un array de 100 elementos con números enteros aleatorios comprendidos entre 0 y 500 (ambos incluidos). A continuación
el programa mostrará el array y preguntará si el usuario quiere destacar el
máximo o el mínimo. Seguidamente se volverá a mostrar el array escribiendo
el número destacado entre dobles asteriscos. */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class arrays_ejer13copy {
  
    public static void main(String[] args) {
        int[] array = new int[100];

        // Rellena el array con números aleatorios entre 0 y 500
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(501);
        }

        // Muestra el array
        System.out.println(Arrays.toString(array));

        // Pregunta al usuario qué número desea destacar
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Qué quiere destacar? (1 – mínimo, 2 – máximo): ");
        int opcion = scanner.nextInt();

        // Destaca el número correspondiente y muestra el array nuevamente
        if (opcion == 1) {
            int minimo = encontrarMinimo(array);
            destacarNumero(array, minimo);
        } else if (opcion == 2) {
            int maximo = encontrarMaximo(array);
            destacarNumero(array, maximo);
        } else {
            System.out.println("Opción inválida");
        }
        System.out.println(Arrays.toString(array));
    }

    // Encuentra el valor mínimo en un array
    public static int encontrarMinimo(int[] array) {
        int minimo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }

    // Encuentra el valor máximo en un array
    public static int encontrarMaximo(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    // Destaca un número en un array colocándolo entre dobles asteriscos
    public static void destacarNumero(int[] array, int numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                array[i] = -1; // Puedes utilizar cualquier número especial para destacar
                break;
            }
        }
    }
}
