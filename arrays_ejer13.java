/*Ejercicio 13
Escribe un programa que rellene un array de 100 elementos con números enteros aleatorios comprendidos entre 0 y 500 (ambos incluidos). A continuación
el programa mostrará el array y preguntará si el usuario quiere destacar el
máximo o el mínimo. Seguidamente se volverá a mostrar el array escribiendo
el número destacado entre dobles asteriscos. */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class arrays_ejer13 {

    public static int encontrarMinimo(int[] array) {
        int minimo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }

    public static int encontrarMaximo(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }    
    
    public static void main(String[] args) {
    int[] numeros = new int[100];
        
    Random random = new Random();
    System.out.println("");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(501); // Genera un número aleatorio entre 0 y 100
        }

        for (int numero : numeros) {            //mostramos el array
            System.out.print(numero + " ");
        }
    System.out.println("\n");
    
    Scanner entrada = new Scanner(System.in);
    System.out.println("¿Qué quiere destacar? (1 - mínimo, 2 - máximo): ");
    int opcion = entrada.nextInt();
        
    entrada.close();

        //buscamos el minimo y el maximo ordenando los valores con las funciones.
        int minimo = encontrarMinimo(numeros); 
        int maximo = encontrarMaximo(numeros);
        
    System.out.println();                   
        for (int numero : numeros) {                // Destacar el número minimo o maximo segun lo pida el usuario
            if (opcion == 1 && numero == minimo) {
                System.out.print("**" + numero + "** ");
            } else if (opcion == 2 && numero == maximo) {
                System.out.print("**" + numero + "** ");
            } else {
                System.out.print(numero + " ");
            }
        }
    }
}





     
//"numeros" es la colección de elementos que deseamos recorrer y "numero" es una variable declarada en el bucle que tomará el valor de cada elemento de la colección.
/*Por ejemplo, si tenemos un arreglo llamado "numeros" que contiene los siguientes valores: {1, 2, 3, 4, 5}, al usar el bucle "for" de la siguiente forma:

for (int numero : numeros) { System.out.println(numero); }

El resultado sería la impresión de cada valor en una línea separada:

1 2 3 4 5

En cada iteración del bucle, la variable "numero" tomará el valor de cada elemento de la colección "numeros". De esta manera, se simplifica 
la forma de recorrer una colección y acceder a sus elementos sin tener que utilizar índices o contadores adicionales.
*/