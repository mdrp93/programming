
//package com.mycompany.mariaproyect;
import java.util.Scanner;

public class PruebaHola {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hola, Mundo!");
        System.out.println("Como estas?");
        System.out.println();
        String a = in.nextLine();
        if (a.equals("bien")) {
            System.out.println("Me alegro de que estes bien, yo tambien estoy genial.");
        } else if (a.equals("mal")) {
            System.out.println("Lamento mucho oir eso, espero que eso mejore pronto.");
        } else {
            System.out.println(
                    "Solo puedo saber como te siente si estas bien o mal, soy un programa un poco extremista.");
        }
    
   in.close();
    }
}