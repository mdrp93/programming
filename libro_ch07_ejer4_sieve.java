import java.util.Arrays;

public class libro_ch07_ejer4_sieve{
    public static boolean[] sieve(int n) {

        // Crear un boolean array de tamaño n y establecer todos los valores iniciales a true
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true); //INFO ABAJO
        
        // Establecer el valor de 0 y 1 como números compuestos (no primos)
        primes[0] = false;
        primes[1] = false;
    
        // Iterar sobre los números desde 2 hasta la raíz cuadrada de n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // Si el número es primo, marcar todos sus múltiplos como compuestos
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        
        return primes;
    }
    
    public static void main(String[] args) {
        int n = 20;
        boolean[] primes = sieve(n);
        
        // Imprimir los números primos encontrados
        System.out.print("Números primos encontrados: ");
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Imprimir el array booleano completo
        System.out.print("Array booleano: ");
        for (boolean prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}

/*El método "sieve" toma un parámetro entero "n" y devuelve un array booleano que indica si cada número del 0 al "n-1" es primo o no.
Primero, creamos un array booleano "primes" de tamaño "n" y establecemos todos los valores iniciales como verdaderos. 
Luego, establecemos los valores de 0 y 1 como compuestos (no primos) porque sabemos que no son primos.
Después, utilizamos un bucle para iterar sobre los números desde 2 hasta la raíz cuadrada de "n". Si encontramos un número primo, 
marcamos todos sus múltiplos como compuestos en el array "primes".
Finalmente, el método devuelve el array "primes" actualizado.
El método main es donde se prueba el método "sieve". En este caso, se crea un entero "n" con un valor de 20 
y se llama al método "sieve" para obtener el array booleano de números primos. Luego, se imprimen los números 
primos encontrados y el array booleano completo. */


/*.fill
El método `.fill()` en Java es un método predefinido en la clase `Arrays` que se utiliza para rellenar un arreglo con un valor específico. El método tiene dos variantes:

1. `fill(array, value)`: este método llena todo el arreglo con el valor especificado. Por ejemplo:
   ```java
   int[] numbers = new int[5];
   Arrays.fill(numbers, 0); // Llena todo el arreglo con el valor 0
   ```

2. `fill(array, fromIndex, toIndex, value)`: este método llena solo una parte del arreglo con el valor especificado entre los índices `fromIndex` (inclusive) y `toIndex` (exclusive). Por ejemplo:
   ```java
   int[] numbers = new int[10];
   Arrays.fill(numbers, 3, 7, 1); // Llena los elementos del índice 3 al 6 con el valor 1
   ```
Estos métodos son útiles cuando se necesita inicializar un arreglo con un valor predeterminado o cuando se quiere vaciar el arreglo por completo asignando un valor específico a todos sus elementos. */