/**
* @author Maria drp
*/

/*Ejercicio 11.
Realiza un programa que pida 10 números por teclado y que los almacene en un array. A continuación se mostrará el contenido de ese array junto al índice
(0 – 9) utilizando para ello una tabla. Seguidamente el programa pasará los primos a las primeras posiciones, desplazando el resto de números (los que
no son primos) de tal forma que no se pierda ninguno. Al final se debe mostrar el array resultante.
*/

import java.util.Scanner;
public class arrays_ejer11 {
    
    public static boolean isPrime(int n) { 
        
        boolean[] isPrime = new boolean[n];     // Crear un array boolean de tamaño n y se asume inicialmente que todos los números son primos.
         for (int i = 2; i < n; i++) {  //El número 1 no, porque no es primo.
            isPrime[i] = true;  // marcar el número "i" como primo
        }
        // desde el número 2 hasta la raíz cuadrada de "n", para marcar números compuestos como no primos --> COMENTARIO: un número compuesto puede ser dividido por otros números más allá de 1 y sí mismo. 
        for (int i = 2; i * i < n; i++) {       
            if (isPrime[i]) {   //verificamos que isPrime sea verdadero, lo que significa que i es primo.
                for (int j = i * i; j < n; j += i) {        // "j" representa los múltiplos de "i"
                    isPrime[j] = false; // marcamos todos los múltiplos de "i" como números no primos.
                }
            }
        }
        return isPrime[n-1];
    }


    public static void main(String[] args) {
       
        int[] numeros = new int[10];

        Scanner in= new Scanner(System.in);       // Pedimos los números por teclado
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = in.nextInt();
        }
                
        in.close();
        
        System.out.println("Índice\tNúmero");       // Mostramos el contenido del array junto a su índice
        System.out.println("======\t=======");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t" + numeros[i]);
        }           
                                            
        //controla de la posición en la que se deben insertar los números primos.   
        int[] numerosOrdenados = new int[10];        // Pasar los números primos a las primeras posiciones
        int index = 0;
        
        for (int i = 0; i < 10; i++) {                  //Si el número no es primo, se guarda en la siguiente posición libre del array "numerosOrdenados", es decir, en la posición siguiente a las que ya están ocupadas con los números primos. 
            if (!isPrime(numeros[i])) {
                numerosOrdenados[index] = numeros[i];
                index++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (isPrime(numeros[i])) {
                numerosOrdenados[index] = numeros[i];   //Si el número es primo, se guarda en la siguiente posición libre del array "numerosOrdenados" 
                index++;
            }
        }
        System.out.println("Array resultante:");             // Mostramos el array resultante
        System.out.print("{");
        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.print(numerosOrdenados[i]);
            if (i < numerosOrdenados.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}"); 
        }

       
    }


