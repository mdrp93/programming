public class libro_ch07_ejer5 {
        public static boolean areFactors(int n, int[] factors) {
            for (int factor : factors) {
                if (n % factor != 0) {
                    return false;
                }
            }
            return true;
        }
        
        public static void main(String[] args) {
            // Ejemplo de uso
            int n = 10;
            int[] factors = {2, 5};
            
            if (areFactors(n, factors)) {
                System.out.println("Los números en la matriz son todos factores de " + n);
            } else {
                System.out.println("Los números en la matriz no son factores todos de " + n);
            }
        }
    }


    

/* El método areFactors toma dos parámetros: un entero n y un array de enteros factors. 
Este método comprueba si todos los elementos en el array factors son factores de n. 
Para hacer esto, itera sobre cada elemento del array utilizando un bucle for-each. 
Dentro del bucle, utiliza el operador de módulo % para determinar si n es divisible
 por el elemento actual del array. Si el resultado de la operación de módulo es diferente 
 de 0, significa que n no es divisible por ese factor y retorna false. Si el bucle se 
 completa sin encontrar ningún factor que no sea divisible por n, retorna true.
El método main es el punto de entrada del programa. Dentro del método main, se define 
una variable entera n con el valor 10 y un array de enteros factors con los valores 2 y 5. 
Luego, se llama al método areFactors pasando los valores de n y factors como argumentos. Dependiendo del resultado, se imprime un mensaje indicando si todos los números en el array son factores de n o no.
explica facil paso a paso para novatos*/


/*  1. Primero, se define un método llamado "areFactors" que toma dos parámetros: un número entero "n" y un array de enteros llamado "factors".
    2. Dentro del método "areFactors", se utiliza un bucle for-each para iterar sobre cada elemento del array "factors".
    3. Dentro del bucle for-each, se utiliza el operador de módulo "%" para determinar si el número "n" es divisible por el elemento actual del array.
    4. Si el resultado del operador de módulo es diferente de cero, significa que "n" no es divisible por ese factor y se retorna "false".
    5. Si el bucle for-each se completa sin encontrar ningún factor que no sea divisible por "n", se retorna "true".
    6. Luego, en el método "main", se define una variable entera "n" con el valor 10 y un array de enteros llamado "factors" con los valores 2 y 5.
    7. Luego, se llama al método "areFactors" pasando los valores de "n" y "factors" como argumentos.
    8. Dependiendo del resultado de la llamada al método "areFactors", se imprime un mensaje indicando si todos los números en el array son factores de "n" o no. */
