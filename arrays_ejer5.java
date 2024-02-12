/**
* @author Maria drp
*/
/*Ejercicio 5
Escribe un programa que pida 10 números por teclado y que luego muestre
los números introducidos junto con las palabras “máximo” y “mínimo” al lado
del máximo y del mínimo respectivamente. 
*/

import java.util.Scanner;


public class arrays_ejer5 {

    public static void main(String[] args) {

    Scanner in= new Scanner(System.in);
       
    int index = 1;
    int numeros[] = new int [10];        
    
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Insert number " +index+": ");
            numeros[i]= in.nextInt();
            index ++;
        }
    
    int max = numeros [0];
    int min = numeros [0];
        
        for (int i = 1; i < numeros.length; i++){       //comenzar en 1 permite comparar el segundo elemento ya que los arrays se han iniciado en el primero =0.
            if (numeros [i]>max){               //Si el número en la posición actual (numeros[i]) es mayor que el valor de "maximo", se actualiza el valor de "maximo" con este número. 
                max = numeros[i];
            }
            if (numeros [i] < min){             //Si el número en la posición actual (numeros[i]) es menor que el valor de "minimo", se actualiza el valor de "minimo" con este número.
                min = numeros[i];
            }
        }

        for (int i = 0; i < numeros.length; i++) {
        
            System.out.println();
            System.out.print(numeros[i]);
            
            if (numeros[i] == min) {
                System.out.print(" Mínimo ");
            }
              
            if (numeros[i] == max) {
                System.out.print(" Máximo ");
            }
            
            if(i!=numeros.length){
                System.out.print(" ");
                }     
        }
    }
}
