/**
* Entradas.java
* Definición de la clase Entradas
* @author Maria drp
*/
package expoCoches;

import java.util.Scanner;

public class Entradas {
    
    public static void main(String[] args) {
        Zona principal = new Zona(1000);
        Zona compraVenta = new Zona(200);
        Zona vip = new Zona(25);
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        do {
            System.out.println("\n1. Mostrar número de entradas libres");
            System.out.println("2. Vender entradas");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("Elija una opción: ");
            
            while (!sc.hasNextInt()) {
                String word = sc.next();
                System.out.println();
                System.err.println("ERROR: "+word + " no es un número.");
                System.out.println("\n1. Mostrar número de entradas libres");
                System.out.println("2. Vender entradas");
                System.out.println("3. Salir");
                System.out.println(); 
                System.out.print("Por favor, elija una opción: ");
               
            }
            opcion = sc.nextInt(); 
                   
            System.out.println();
            
            switch(opcion) {        //estructura de control de flujo permite ejecutar diferentes bloques. swith >> case >> break >> default >> while (condicion para el flujo) 
                case 1:
                    System.out.println("Entradas disponibles:");
                    System.out.println("    Sala principal: " + principal.getEntradasPorVender());
                    System.out.println("    Zona de compra-venta: " + compraVenta.getEntradasPorVender());
                    System.out.println("    Zona VIP: " + vip.getEntradasPorVender());
                    break;
                case 2:
                
                    System.out.println("¿Para qué zona desea comprar entradas?");
                    System.out.println("    1. Sala principal");
                    System.out.println("    2. Zona de compra-venta");
                    System.out.println("    3. Zona VIP");
                    System.out.println();
                    System.out.print("Elija una zona: ");

                    while (!sc.hasNextInt()) {
                        String word = sc.next();
                        System.err.println("ERROR: "+word + " no es un número.\n");
                        System.out.println("    1. Sala principal");
                        System.out.println("    2. Zona de compra-venta");
                        System.out.println("    3. Zona VIP\n");
                        System.out.print("Por favor, elija una zona: "); 
                    }
                    int zona = sc.nextInt();

                    if(zona==1||zona==2||zona==3){
                    System.out.println();

                    System.out.print("¿Cuántas entradas desea comprar? ");
                    
                   while (!sc.hasNextInt()) {
                        String word = sc.next();
                        System.out.println();
                        System.err.println("ERROR: "+word + " no es un número.\n");
                        System.out.print("Por favor, inserte un número: "); 
                   }
                    int cantidad = sc.nextInt();
                    
                    switch(zona) {
                        case 1:
                            principal.vender(cantidad);
                            break;
                        case 2:
                            compraVenta.vender(cantidad);
                            break;
                        case 3:
                            vip.vender(cantidad);
                            break;
                    }}
                else{
                    System.err.println("ERROR: "+zona+ " no es una zona válida.\n");
                    System.err.println("Volviendo al menú principal...");
                }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 3);
    
        sc.close();
    }
}

