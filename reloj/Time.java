package reloj;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.println();
        System.out.print("Inserta la hora actual (formato 0h 0m 0s):  ");
        int h1 = in.nextInt();
        int m1 = in.nextInt();
        int s1 = in.nextInt();
        System.out.println();

        Tiempo t1 = new Tiempo(h1, m1,s1); //hora actual t1
        System.out.println(">> Hora introducida: "+t1+"\n");

        System.out.print("Inserta el tiempo que quiere sumar a "+t1+" (formato 0h 0m 0s): ");

        int h2 = in.nextInt();
        int m2 = in.nextInt();
        int s2 = in.nextInt();
        System.out.println();

        Tiempo t2 = new Tiempo(h2, m2, s2); //hora suma t2
        System.out.println(">> Hora introducida: "+t2+"\n");

        Tiempo suma = t1.suma(t2);
        System.out.println("    Suma: " +t1 + " + "+t2+" = "+ suma.toString()+"\n"); 
    
        System.out.print("Inserta el tiempo que quiere restar a "+t1+" (formato 0h 0m 0s): ");

        int h3 = in.nextInt();
        int m3 = in.nextInt();
        int s3 = in.nextInt();
        System.out.println();

        Tiempo t3 = new Tiempo(h3, m3, s3);     //hora resta t3
        System.out.println(">> Hora introducida: "+t3+"\n");

        Tiempo resta = t1.resta(t3);
        System.out.println("    Resta: " +t1 + " - "+t3+" = "+ resta.toString()+"\n");
}
}


//compilacion:  javac Time.java Tiempo.java


/* OUTPUT CONSOLA: 

Inserta la hora actual (formato 0h 0m 0s):  1 30 50

>> Hora introducida: 1h 30m 50s

Inserta el tiempo que quiere sumar a 1h 30m 50s (formato 0h 0m 0s): 0 29 10

>> Hora introducida: 0h 29m 10s

    Suma: 1h 30m 50s + 0h 29m 10s = 2h 0m 0s

Inserta el tiempo que quiere restar a 1h 30m 50s (formato 0h 0m 0s): 1 0 0

>> Hora introducida: 1h 0m 0s

    Resta: 1h 30m 50s - 1h 0m 0s = 0h 30m 50s
*/