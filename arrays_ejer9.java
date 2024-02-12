
/**
* @author Maria drp
*/
/*
Ejercicio 9
Realiza un programa que pida 8 números enteros y que luego muestre esos números junto con la palabra “par” o “impar” según proceda.
*/

import java.util.Scanner;

public class arrays_ejer9 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[8];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Insert a number " + (i + 1) + ": ");
            numeros[i] = entrada.nextInt();
        }

        System.out.println("The introduced numbers are:");

        
        for (int i = 0; i < numeros.length; i++) {                  // Mostrar los números junto con "par" o "impar"
            System.out.print(numeros[i] + " is ");
            if (numeros[i] % 2 == 0) {                          //si se divide entre 2 es par y si no es impar else{(odd)}
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}

