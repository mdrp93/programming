/*
Ejercicio 10
Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los almacene en un array. 
El programa debe ser capaz de pasar todos los números pares a las primeras posiciones del array (del 0 en adelante) 
y todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es necesario.
*/

import java.util.Arrays;
import java.util.Random;

public class arrays_ejer10 {

    public static int[] ordenarNumeros(int[] numeros) {

        int[] numerosOrdenados = new int[numeros.length];

        int indicePar = 0;
        int indiceImpar = numeros.length - 1;
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                numerosOrdenados[indicePar] = numeros[i];
                indicePar++;
            } 
            else {
                numerosOrdenados[indiceImpar] = numeros[i];
                indiceImpar--;
            }
        }   
        return numerosOrdenados;
    }

 
    public static void main(String[] args) {
    

    int[] numeros = new int[20];
        
    Random random = new Random();
    
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(101); // Genera un número aleatorio entre 0 y 100
        }
        System.out.println("Números generados: \n"+Arrays.toString(numeros) );
       
        int[] numerosOrdenados = ordenarNumeros(numeros);
        
        System.out.println("Números ordenados: \n"+Arrays.toString(numerosOrdenados));
    } 
}

