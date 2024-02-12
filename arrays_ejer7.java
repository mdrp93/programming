/**
* @author Maria drp
*/
/*
 Ejercicio 7
Escribe un programa que genere 100 números aleatorios del 0 al 20 y que los
muestre por pantalla separados por espacios. El programa pedirá entonces
por teclado dos valores y a continuación cambiará todas las ocurrencias del
primer valor por el segundo en la lista generada anteriormente. Los números
que se han cambiado deben aparecer entrecomillados.
 */

import java.util.Random;
import java.util.Scanner;

public class arrays_ejer7 {

    public static void main(String[] args) {
    
    int [] aleatorios = new int [100];
    Random ramdon = new Random();

        for (int i =0; i<aleatorios.length; i++){               //cargamos el array numeor con valores aleatorios de o a 20
            aleatorios[i]= ramdon.nextInt(21);
        }
    
        for (int numero : aleatorios) {
            System.out.print(numero + " ");                 //separamos por espacios
        }

    System.out.println();
    Scanner in = new Scanner(System.in);
    System.out.print("Insert a first number: ");
    int valor1 = in.nextInt();
    System.out.print("Insert a second number: ");
    int valor2 = in.nextInt();

        for (int i = 0; i < aleatorios.length; i++) {
        if (aleatorios[i] == valor1) {                  //comparar si i es igual al valor1
            aleatorios[i] = valor2;                     //asigna el valor2
            System.out.print("'" + valor2 + "' ");
        } 
        else {
            System.out.print(aleatorios[i] + " ");
        }
        }
    System.out.println();
    
in.close(); //info abajo

 



}
}





/*COMENTARIO:
scanner.close() es una línea de código que se utiliza en Java para cerrar un objeto Scanner. 
El objeto Scanner es una clase que se utiliza para escanear datos de entrada en un programa. 
Cuando se trabaja con un objeto Scanner, es importante cerrarlo correctamente para liberar los recursos y evitar posibles fugas de memoria. 
La función scanner.close() cierra el objeto Scanner y ya no se puede utilizar para leer datos de entrada.
*/



/*EJEMPLO OUTPUT:
7 6 4 14 18 16 20 14 17 0 6 12 20 19 1 9 1 20 3 11 19 8 15 4 8 12 18 10 2 1 13 8 17 2 15 15 12 0 0 11 16 20 4 18 13 0 7 1 6 16 1 14 16 17 0 5 7 8 10 5 3 10 18 3 16 17 20 20 0 20 4 18 13 1 14 3 4 11 17 14 9 13 6 9 13 17 1 17 3 11 15 13 7 19 16 4 19 15 1 6 
Insert a first number: 4
Insert a second number: 56
7 6 '56' 14 18 16 20 14 17 0 6 12 20 19 1 9 1 20 3 11 19 8 15 '56' 8 12 18 10 2 1 13 8 17 2 15 15 12 0 0 11 16 20 '56' 18 13 0 7 1 6 16 1 14 16 17 0 5 7 8 10 5 3 10 18 3 16 17 20 20 0 20 '56' 18 13 1 14 3 '56' 11 17 14 9 13 6 9 13 17 1 17 3 11 15 13 7 19 16 '56' 19 15 1 6 
*/