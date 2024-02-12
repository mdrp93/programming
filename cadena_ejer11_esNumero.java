/**
* @author Maria drp
*/

import java.util.Scanner;

public class cadena_ejer11_esNumero {

    public static boolean esNumero(String cadena) {
        // Comprobamos si todos los caracteres de la cadena son dígitos
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String numerito = scanner.next();

        if (esNumero(numerito)) {
            int numero = Integer.parseInt(numerito); // Si es un número válido, se convierte a entero utilizando Integer.parseInt() y se muestra por pantalla. Si la cadena no es un número válido, se muestra un mensaje de error.
            System.out.println("The imput IS a number: " + numero);
        }
        else {
            System.out.println("The input is NOT a valid number. ");
        }
    }
}
