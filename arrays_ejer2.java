
public class arrays_ejer2 {

/*Ejercicio 2
Define un array de 10 caracteres con nombre simbolo y asigna valores a los
elementos según la tabla que se muestra a continuación. Muestra el contenido
de todos los elementos del array. ¿Qué sucede con los valores de los elementos
que no han sido inicializados
 */

 public static void main(String[] args) {

char simbolo [] = new char [10];

simbolo [0] = 'a';
simbolo [1] = 'x';
simbolo [4] = '@';
simbolo [6] = ' ';
simbolo [7] = '+';
simbolo [8] = 'Q';

System.out.print("{" + simbolo[0]);
    for (int i = 1; i < simbolo.length; i++) {
        System.out.print(", " + simbolo[i]);
    }
System.out.println("}");
    
 }

// Los valores de los elementos que no han sido iniciados aparecen vacios al ser un array de tipo char.
//output:  [a, x, , , @, ,  , +, Q, ]
 
}








/*FORMAS DE ACCEDER A LOS DATOS: 

*   System.out.print("{" + simbolo[0]);
    for (int i = 0; i < simbolo.lenght; i++) {
        System.out.print(", " + simbolo[i]);
    }
    System.out.println("}");
-----------------------------------------------------------------------------------------------------
*   System.out.print(Arrays.toString(simbolo)); 
    Arrays.toString(num) nos sirve para ver impreso el contenido de la array aunque con[] y no con {}.
*/


