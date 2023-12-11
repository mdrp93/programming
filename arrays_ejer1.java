
import java.util.Arrays;

public class arrays_ejer1 {

/*Ejercicio 1:
Define un array de 12 números enteros con nombre num y asigna los valores
según la tabla que se muestra a continuación. Muestra el contenido de todos
los elementos del array. ¿Qué sucede con los valores de los elementos que no
han sido inicializados?
 */

 public static void main(String[] args) {

    int num [] = new int [12];
    
    num [0] = 39;
    num [1] -= 2;
    num [4] = 0;
    num [6] = 14;
    num [8] = 5;
    num [9] = 120;

    System.out.print(Arrays.toString(num)); //Arrays.toString(num) nos sirve para ver impreso el contenido de la array aunque con[] y no con {}.
   
}

// Los valores de los elementos que no han sido iniciados deben tneer un valor por defecto, que en este caso es cero.
//output: [39, -2, 0, 0, 0, 0, 14, 0, 5, 120, 0, 0]

}
