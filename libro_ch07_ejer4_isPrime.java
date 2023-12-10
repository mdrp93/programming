
import java.util.Scanner;


public class libro_ch07_ejer4_isPrime{ 
    
      public static boolean sieve(int n) { 

        // Crear un array boolean de tamaño n y se asume inicialmente que todos los números son primos.
        boolean[] isPrime = new boolean[n];
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
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a positive integer number: "); 
        while (!in.hasNextInt()) {
            String word = in.next();
            System.err.println("IMPUT ERROR: "+word + " is not a number.");
            System.out.print("Please enter a positive integer number: "); 
        }
        int n = in.nextInt(); 
               
       // Imprimir los números primos
       int k =1; 
       for (int i = 0; i < n; i++) {
            
            if (sieve(n)) {
             System.out.println(k+"º primes number to "+n+" are: "+i);
             k++;
            }
            
        } 
    }
}
 
    
/*El método "sieve" toma un parámetro entero "n" y devuelve un array booleano que indica si cada número del 0 al "n-1" es primo o no.
1- creamos un array booleano "primes" de tamaño "n" y establecemos todos los valores iniciales como verdaderos. 
2- establecemos los valores de 0 y 1 como compuestos (no primos) porque sabemos que no son primos.
3- utilizamos un bucle para iterar sobre los números desde 2 hasta la raíz cuadrada de "n". Si encontramos un número primo, marcamos todos sus múltiplos como compuestos en el array "primes".
4- el método devuelve el array "primes" actualizado.
*/

//COMENTARIO MATEMÁTICO:  todos los números compuestos son números NO primos, pero no todos los números no primos son compuestos.
//COMENTARIO MATEMÁTICO: Un número primo es aquel número natural mayor que 1 que solo se puede dividir exactamente por sí mismo y por 1.






/*COMENTARIO DE UN MÉTODO ENCONTRADO: .fill

El método `.fill()` en Java es un método predefinido en la clase `Arrays` que se utiliza para rellenar un arreglo con un valor específico. El método tiene dos variantes:

1. `fill(array, value)`: este método llena todo el arreglo con el valor especificado. Por ejemplo:
   ```java
   int[] numbers = new int[5];
   Arrays.fill(numbers, 0); // Llena todo el arreglo con el valor 0
   ```

2. `fill(array, fromIndex, toIndex, value)`: este método llena solo una parte del arreglo con el valor especificado entre los índices `fromIndex` (inclusive) y `toIndex` (exclusive). 
Por ejemplo:
   ```java
   int[] numbers = new int[10];
   Arrays.fill(numbers, 3, 7, 1); // Llena los elementos del índice 3 al 6 con el valor 1
   ```
Estos métodos son útiles cuando se necesita inicializar un arreglo con un valor predeterminado o cuando se quiere vaciar el arreglo por completo asignando un valor específico a todos sus elementos. 
LO USAMOS CON: import java.util.Arrays;
*/