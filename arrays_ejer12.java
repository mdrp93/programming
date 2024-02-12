/**
* @author Maria drp
*/

/*
Realiza un programa que pida 10 números por teclado y que los almacene en
un array. A continuación se mostrará el contenido de ese array junto al índice
(0 – 9). Seguidamente el programa pedirá dos posiciones a las que llamaremos “inicial” y “final”. 
Se debe comprobar que inicial es menor que final y que ambos números están entre 0 y 9. 
El programa deberá colocar el número de la posición inicial en la posición final, rotando el resto de números para que no
se pierda ninguno. Al final se debe mostrar el array resultante.
*/

import java.util.Scanner;
public class arrays_ejer12 {

        
    public static void main(String[] args) {

    Scanner in= new Scanner(System.in);
       
    int index = 0;
    int num[] = new int [10];   
         
        for (int i = 0; i < num.length; i++) {           
            System.out.print("Insert number " +index+": ");
            num[i]= in.nextInt();
            index ++;
        }

    System.out.println();                                //VER INDICE Y VALORES RESPECTIVOS
    System.out.println("INDEX\tVALUE");
        for (int i = 0; i < num.length; i++) {
            System.out.println(i + "\t" + num[i] ); 
        } 

    int[] nueva = new int[num.length];    
        for (int i = 0; i < num.length; i++) {          // Copiar los elementos del original array al nuevo array usando un bucle for
            nueva[i] = num[i];
        }
    System.out.println();
    System.out.print("Insert initial position: ");
    int inicial =in.nextInt();
    
    System.out.print("Insert final position: ");
    int fin =in.nextInt();

        while (inicial < 0 || inicial > 9 || fin < 0 || fin > 9 || inicial >= fin) {     // Comprobamos que las posiciones son válidas
            System.out.println("The value of position are incorrect.");
            System.out.print("Insert initial position: ");
            inicial=in.nextInt();
            System.out.print("Insert final position: ");
            fin=in.nextInt();
        }
        
    int asignada = nueva[inicial];                          //rotacion
        
        for (int i = inicial; i < fin; i++) {
            nueva[i] = nueva[i+1];
            }
    nueva[fin] = asignada;

    System.out.println("INDEX\tVALUE\tNEW VALUE");
        for (int i = 0; i < num.length; i++) {
            System.out.println(i + "\t" + num[i] + "\t" + nueva[i]); 
        }  
    }
}
    
