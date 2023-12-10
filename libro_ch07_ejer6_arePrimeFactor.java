import java.util.Arrays;

public class libro_ch07_ejer6_arePrimeFactor {
    
    
    
    public static boolean arePrimeFactors(int n, int[] factors) { // Comprobar si todos los factores son primos 
        for (int factor : factors) { 
            if (!sieve(factor)) { return false; 
            } 
        }                               // Calcular el producto de los factores 
        int product = 1; 
        for (int factor : factors) { 
            product *= factor;  
        }                                   // Comprobar si el producto es igual a n 
        return product == n; }


    public static boolean sieve(int n) { 

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {  
            isPrime[i] = true;  
        }
        
        for (int i = 2; i * i < n; i++) {       
            if (isPrime[i]) {  
                for (int j = i * i; j < n; j += i) {      
                    isPrime[j] = false; 
                }
            }
        }
        
      return isPrime[n-1]; 
    }

    public static void main(String[] args) {
 
    int n = 12; 
    int[] factors = {2, 3};

    boolean result = arePrimeFactors(n, factors);

        if (result) { 
            System.out.println("The numbers in the array " + Arrays.toString(factors) + " are all primes and their product is " + n + "."); } 
         else { 
            System.out.println("The numbers in the array " + Arrays.toString(factors) + " are NOT all primes or their product is not equal to " + n + "."); 
        } 
    } 
}


/*
En este programa, se define una función llamada "arePrimeFactors" que toma dos parámetros: un número entero "n" y un arreglo de enteros "factors".
La función itera sobre cada factor en el arreglo "factors" y verifica si es un número primo utilizando la función "sieve". Si algún factor no es primo, la función retorna falso.
Luego, se calcula el producto de todos los factores y se guarda en la variable "product". Después, se verifica si el producto es igual a "n". Si es igual, la función retorna verdadero. 
Si no, retorna falso.
La función "sieve" implementa el algoritmo criba de Eratóstenes para determinar si un número es primo. 
Crea un arreglo de booleanos "isPrime" de tamaño "n", donde cada índice representa un número. Inicialmente, todos los elementos del arreglo son verdaderos, excepto los índices 0 y 1.
Luego, el algoritmo itera desde el número 2 hasta la raíz cuadrada de "n". Si un número es primo (su posición en el arreglo "isPrime" es verdadero), se marca como falso todos los múltiplos de ese número en el arreglo.
Al final, se devuelve el valor del índice "n-1" en el arreglo "isPrime".
En la función "main", se define un número "n" y un arreglo de factores "factors". Se llama a la función "arePrimeFactors" con estos valores y se guarda el resultado en la variable "result". Luego, se imprime un mensaje dependiendo del resultado obtenido.
 */