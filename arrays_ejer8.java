/*
Ejercicio 8
Realiza un programa que pida la temperatura media que ha hecho en cada mes de un determinado año y que muestre a continuación un diagrama de barras
horizontales con esos datos. Las barras del diagrama se pueden dibujar a base de asteriscos o cualquier otro carácter.
 */


import java.util.Scanner;

public class arrays_ejer8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] temperaturas = new int[12];

    // temperaturas para cada mes

        for (int i = 0; i < 12; i++) {
            System.out.print("Introduce la temperatura media del mes " + (i+1) + ": ");
            temperaturas[i] = sc.nextInt();
        }

    // Dibujamos el diagrama de barras
    
        for (int i = 0; i < 12; i++) {                      //hasta 12 meses
            System.out.print("Mes " + (i+1) + ": ");        //mprime el texto "Mes ", seguido del número del mes (en lugar de imprimirlo como 0-11, se agrega 1 al valor de i).
            for (int j = 0; j < temperaturas[i]; j++) {     //La variable j la utilizamos para controlar cantidad de asteriscos a imprimir.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

