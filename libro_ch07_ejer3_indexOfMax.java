/**
* @author Maria drp
*/
import java.util.Scanner;

public class  libro_ch07_ejer3_indexOfMax{

   
 public static int indexOfMax(int[] currentArray) {
        int indiceMaximo = 0;       //almacenar el índice del elemento máximo. inicia en 0
        int maximo = currentArray[0];      //almacenará el valor máximo encontrado hasta el momento. inicia en 0

        for (int i = 1; i < currentArray.length; i++) {   // iterar desde el segundo elemento del array (índice 1) hasta el último elemento. Se comienza desde el segundo elemento porque el primero ya fue asignado a "maximo" en la línea anterior.
            if (currentArray[i] > maximo) {                //se compara si el valor del elemento actual (array[i]) es mayor que el valor de "maximo". 
                maximo = currentArray[i];                  //Si es así, se actualiza el valor de "maximo" con el valor del elemento actual 
                indiceMaximo = i;                   //y se actualiza "indiceMaximo" con el índice actual (i).
            }
        }

        return indiceMaximo;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de elementos de la matriz: ");
        int size = scanner.nextInt();

        int[] arrayUser = new int[size];

        // Pedir al usuario los elementos de la matriz
        for (int i = 0; i < size; i++) {
            System.out.print("Ingrese el elemento #" + (i + 1) + ": ");
            arrayUser[i] = scanner.nextInt();
        }
        
        // Obtener el índice del elemento más grande
        int indexMax = indexOfMax(arrayUser);
        System.out.println("The index of the largest element is: " + indexMax);

       
    }
}



/*Yes, it could be written with an enhanced loop but in this particular case, an enhanced loop would not 
be suitable for finding the index of the largest element in the array. By using an enhanced loop, 
we would not have access to the current index of the element in each iteration. An enhanced loop only provides us 
with the value of the element itself, not the corresponding index. 

They are not helpful when you need to refer to the index, as in search operations.*/


/*Si, se podria escribir con un bucle mejorado pero en este caso particular, un bucle mejorado no sería adecuado para encontrar el índice del 
elemento más grande en la matriz. Al utilizar un bucle mejorado, no tendríamos acceso al índice 
actual del elemento en cada iteración. Un bucle mejorado solo nos proporciona el valor del elemento en sí, 
no el índice correspondiente. */




/*COMENTARIO:
 * La variable i DE IndexOfMax se inicia en 1 para evitar una comparación innecesaria en la primera iteración del bucle. 
 * Si i se inicializara en 0, en la primera iteración se compararía el elemento en la posición 0 con sí mismo, 
 * lo cual es redundante. Iniciar i en 1 permite comenzar a comparar el segundo elemento del array con el primer 
 * elemento del array, que es lo que se desea en este caso.
 */