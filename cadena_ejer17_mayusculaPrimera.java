import java.util.Scanner;

public class cadena_ejer17_mayusculaPrimera {

        public static String mayusculasPrimera(String cadena) {
            
            String[] palabras = cadena.split(" ");  // Dividir la cadena en palabras
            
            // Iterar por cada palabra y poner la primera letra en mayúscula
            for (int i = 0; i < palabras.length; i++) {
                String palabra = palabras[i]; //La variable "i" es un índice que representa la posición del elemento en el arreglo al que queremos asignarle un valor.
                
                if (!palabra.isEmpty()) {
                    // Obtener la primera letra en mayúscula
                    String primeraLetra = palabra.substring(0, 1).toUpperCase(); // el número 0 indica el índice de inicio de la subcadena y el número 1 indica la cantidad de caracteres que se desea obtener.
                    
                    // Reemplazar la primera letra en la palabra
                    palabra = primeraLetra + palabra.substring(1);
                    
                    // Actualizar la palabra en el arreglo -->La línea de código "palabras[i] = palabra;" asigna el valor de "palabra" al elemento en la posición "i" del arreglo "palabras".
                    palabras[i] = palabra;
                }
            }
            
            return String.join(" ", palabras);  // Unir las palabras con espacios y devolver el resultado
        }
        
        public static void main(String[] args) {
             Scanner in = new Scanner(System.in); 
        
        System.out.println("Writte the sentences: ");
        String cadena = in.nextLine();   
             
        String resultado = mayusculasPrimera(cadena);
        System.out.println(resultado); 
        }
    }
    



/*  La línea de código "String palabra = palabras[i];"
    asigna el valor de la posición "i" del arreglo "palabras" a la variable "palabra". En otras palabras, 
    está tomando un elemento específico del arreglo y guardándolo en una variable para su posterior uso. 
    El tipo de dato de esta variable es "String", lo que significa que puede almacenar cadenas de caracteres. */

 /* 1. Toma como parámetros una cadena de caracteres con el separador y un arreglo de cadenas de caracteres.
    2. Convierte el arreglo de cadenas de caracteres en una cadena de caracteres separadas por el separador especificado.
    3. Devuelve una cadena resultante de la combinación de los elementos de la matriz, separados por el delimitador especificado.
    Nota: La función `String.join(separador, cadenas)` la función .join() se utiliza para combinar los elementos de una matriz 
    de cadenas en una sola cadena, separando cada elemento con un delimitador específico. */

/*  La función .split() se utiliza para dividir una cadena en una matriz de subcadenas basadas en un delimitador especificado. 
    Toma como argumento una expresión regular que representa el delimitador y divide la cadena original en subcadenas en función 
    de la aparición del delimitador. Devuelve un arreglo de cadenas resultante de la división.  */