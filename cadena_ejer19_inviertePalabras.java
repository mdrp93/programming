/**
* @author Maria drp
*/

import java.util.Scanner;

public class cadena_ejer19_inviertePalabras {

    public static String invierteCadena(String cadena) { 
        String nuevaCadena = "";
        for(int i = cadena.length() -1; i>=0;i--) { 
           nuevaCadena += cadena.charAt(i);
        }
        return nuevaCadena;
     }
     
     public static String inviertePalabras(String cadena) {
        // Dividir la cadena en palabras
        String[] palabras = cadena.split(" ");
        
        // Invertir cada palabra
        for(int i = 0; i < palabras.length; i++) { 
           palabras[i] = invierteCadena(palabras[i]);
        }
        
        // Unir las palabras invertidas en una nueva cadena
        String resultado = String.join(" ", palabras);
        
        return resultado;
     }
public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a sentence: ");
        String cadenaOriginal = in.nextLine();  

        System.out.print(inviertePalabras(cadenaOriginal));
         String cadenaInvertida = inviertePalabras(cadenaOriginal);
         System.out.println(cadenaInvertida);
       
        
    }
   
}


/*  1.Declaramos una variable nuevaCadena como una cadena vacía.
    2.Usamos un bucle for que comienza desde la última posición de la cadena (cadena.length() - 1) y termina en la primera posición (0).
    3.Durante cada iteración, obtenemos el carácter en la posición actual usando cadena.charAt(i) y lo concatenamos con nuevaCadena.
    4.Finalmente, devuelve nuevaCadena, que contendrá la cadena original invertida.
    5.El método inviertePalabras toma una cadena como argumento y devuelve una nueva cadena con las palabras invertidas.

    6.Dividimos la cadena en palabras utilizando el método split(" "), que separa la cadena en cada espacio encontrado y devuelve un arreglo de cadenas.
    7.Recorremos el arreglo de palabras usando un bucle for.
    8.Durante cada iteración, llamamos al método invierteCadena para invertir cada palabra y asignamos el resultado de vuelta a la posición correspondiente en el arreglo de palabras.
    9.Utilizamos String.join(" ", palabras) para unir las palabras invertidas en una nueva cadena, separando cada palabra con un espacio.
    10.Devolvemos la nueva cadena resultante con las palabras invertidas. */