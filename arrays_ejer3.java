/**
* @author Maria drp
*/
/*Ejercicio 3
Escribe un programa que lea 10 números por teclado y que luego los muestre
en orden inverso, es decir, el primero que se introduce es el último en
mostrarse y viceversa.
*/

import java.util.Arrays;
import java.util.Scanner;

public class arrays_ejer3 {
    


    
public static void main(String[] args) {
   
    Scanner in= new Scanner(System.in);
       
    int index = 0;
    int numerosTec [] = new int [10];
        
    
        for (int i = 0; i < numerosTec.length; i++) {
            System.out.print("Insert number " +index+": ");
            numerosTec[i]= in.nextInt();
            index ++;
        }

        System.out.print("{");
        for (int i = 0; i < numerosTec.length; i++) {
        System.out.print(numerosTec[i]);
            if (i < numerosTec.length - 1) {
                System.out.print(", ");
        }
    }
    System.out.println("}");

    int [] numerosCopy = Arrays.copyOf(numerosTec, numerosTec.length);

    System.out.println("The inverted numbers are: ");
    System.out.print("{");    
        for (int i = numerosCopy.length - 1; i >= 0; i--) {
            System.out.print(numerosCopy[i]);
            if (i!=0) {
                System.out.print(", ");
            }
        }
    System.out.print("}"); 

 in.close();

}}


/*OUTPUT:
Insert number 0: 1
Insert number 1: 2
Insert number 2: 3
Insert number 3: 4
Insert number 4: 5
Insert number 5: 6
Insert number 6: 7
Insert number 7: 8
Insert number 8: 9
Insert number 9: 10
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
The inverted numbers are:
{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
*/





/*  
System.out.print("{");
    for (int i = 0; i < numerosTec.length; i++) {
        System.out.print(numerosTec[i]);
        if (i < numerosTec.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("}"); 

*/