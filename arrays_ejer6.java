/*
Ejercicio 6
Escribe un programa que lea 15 números por teclado y que los almacene en un
array. Rota los elementos de ese array, es decir, el elemento de la posición 0
debe pasar a la posición 1, el de la 1 a la 2, etc. El número que se encuentra en
la última posición debe pasar a la posición 0. Finalmente, muestra el contenido
del array.
 */

import java.util.Scanner;

public class arrays_ejer6 {
    
    public static void main(String[] args) {

    Scanner in= new Scanner(System.in);
       
    int index = 0;
    int cadena[] = new int [15];   
         
        for (int i = 0; i < cadena.length; i++) {           
            System.out.print("Insert number " +index+": ");
            cadena[i]= in.nextInt();
            index ++;
        }
    in.close();

    System.out.println();
    System.out.print("String values entered: ");
    System.out.print("{" + cadena[0]);
        for (int i = 1; i < cadena.length; i++) {
            System.out.print(", " + cadena[i]);
        }
    System.out.println("}");
    
    int ultimo = cadena[cadena.length - 1];                 //nueva cadena en la que tomamos como referencia la cadena original con ultimo elemento. 
        
        for (int i = cadena.length-1; i > 0; i--)  {          //cadena en reverso ; rotación;
            cadena[i] = cadena[i - 1];                   //asignamos el valor de un elemento anterior  al actual.
        }
       cadena[0] = ultimo;

    System.out.println();  
    System.out.print("Values of the string rotated by one position: "); 
    System.out.print("{" + cadena[0]);
       for (int i = 1; i < cadena.length; i++) {            //igualar a uno para que el bucle comience en el segundo lugar del index no en el cero. el cero se imprime en la primera iteracion.    
           System.out.print(", " + cadena[i]);
       }
   System.out.println("}");

   System.out.println();                                //VER INDICE Y VALORES RESPECTIVOS
   System.out.println("INDEX\tVALOR");
        for (int i = 0; i < cadena.length; i++) {
            System.out.println(i + "\t" + cadena[i] ); 
        } 

in.close();
}
}


/*OUTPUT:
 * Insert number 0: 0
Insert number 1: 1
Insert number 2: 2
Insert number 3: 3
Insert number 4: 4
Insert number 5: 5
Insert number 6: 6
Insert number 7: 7
Insert number 8: 8
Insert number 9: 9
Insert number 10: 10
Insert number 11: 11
Insert number 12: 12
Insert number 13: 13
Insert number 14: 14

Valores de la cadena introducidos: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}

Valores de la cadena rotados en una posición: {14, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}

INDEX   VALOR
0       14
1       0
2       1
3       2
4       3
5       4
6       5
7       6
8       7
9       8
10      9
11      10
12      11
13      12
14      13
 */
