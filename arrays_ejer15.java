/**
* @author Maria drp
*/

/*Ejercicio 15
Un restaurante nos ha encargado una aplicación para colocar a los clientes en sus mesas. En una mesa se pueden sentar de 0 (mesa vacía) a 4 comensales
(mesa llena). Cuando llega un cliente se le pregunta cuántos son. De momento el programa no está preparado para colocar a grupos mayores a 4, por tanto,
si un cliente dice por ejemplo que son un grupo de 6, el programa dará el mensaje “Lo siento, no admitimos grupos de 6, haga grupos de 4
personas como máximo e intente de nuevo”. Para el grupo que llega, se busca siempre la primera mesa libre (con 0 personas). Si no quedan mesas
libres, se busca donde haya un hueco para todo el grupo, por ejemplo si el grupo es de dos personas, se podrá colocar donde haya una o dos personas.
Inicialmente, las mesas se cargan con valores aleatorios entre 0 y 4. Cada vez que se sientan nuevos clientes se debe mostrar el estado de las mesas.
Los grupos no se pueden romper aunque haya huecos sueltos suficientes */

import java.util.Random;
import java.util.Scanner;


public class arrays_ejer15 {

     public static void main(String args[]) {
        Random random = new Random();
         int[] ocupados = new int[10];
        
        
        for (int i = 0; i < 10; i++) {
           ocupados[i] = random.nextInt(5);
       }
      
        Scanner entrada = new Scanner(System.in);
        int clientes = 0;
        
        while (clientes != -1) {
            System.out.println("");
            System.out.println("│Mesa nº  │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10 │");
            System.out.println("│--------------------------------------------------|");
            System.out.print("│Ocupación");
                for (int i = 0; i < 10; i++) {
                    System.out.printf("│%2d ", ocupados[i]);
                }
            System.out.print(" |");
            System.out.println("");
            System.out.println("│--------------------------------------------------|");
            System.out.println("");
            System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
            clientes = entrada.nextInt();
        
            if (clientes == -1) {
                break;
            } 
            else if (clientes > 4) {
                System.out.println("Lo siento, no admitimos grupos de " + clientes + ", haga grupos de 4 personas como máximo e intente de nuevo.");
                continue;
            }

            // Buscar la primera mesa libre 
            int mesaLibre = -1;
            for (int i = 0; i < ocupados.length; i++) {
                if (ocupados[i] == 0) {
                mesaLibre = i;
            break;
            }
            }    
            if (mesaLibre != -1) {
                ocupados[mesaLibre] = clientes;
               System.out.println("Por favor, siéntense en la mesa número " + (mesaLibre + 1) + ".");  
            } 
            else {              // Buscar una mesa con huecos suficientes para el grupo
            int mesaHuecos = -1;
                for (int i = 0; i < 10; i++) {
                    if (ocupados[i] >= clientes && ocupados[i] < 4) {
                        mesaHuecos = i;
                        break;
                    }
                }
            if (mesaHuecos != -1) {
                ocupados[mesaHuecos] += clientes;
                System.out.println("Por favor, siéntense en la mesa número " + (mesaHuecos + 1) + ".");
               
            } 
            else {
                System.out.println("Lo siento, en estos momentos no queda sitio.");
            }
            }
        }
    entrada.close();
    }
}


        
        
        

        
        
       

            

            

            
