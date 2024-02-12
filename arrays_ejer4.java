/**
* @author Maria drp
*/
import java.util.Random;


public class arrays_ejer4 {

public static void main(String[] args) {
    int [] numero = new int [20];
    int [] cuadrado = new int [20];
    int [] cubo = new int [20];
    Random ramdon = new Random();

        for (int i =0; i<numero.length; i++){ //cargamos el array numeor con valores aleatorios de o a 100
            numero [i]= ramdon.nextInt(100+1);
        }

        for (int i =0; i<numero.length; i++){ //cargamos el array cuadrado
            cuadrado [i]= numero[i]*numero[i];
        }

         for (int i =0; i<numero.length; i++){ //cargamos el array cubo 
            cubo [i]= numero[i]*numero[i]*numero[i];
        }
    System.out.println();
    System.out.println("Numero\tCuadrado\tCubo\n");
        for (int i = 0; i < numero.length; i++) {
            System.out.println(numero[i] + "\t" + cuadrado[i] + "\t\t" + cubo[i]); //asi podemos mostras el contenido en columnas usando un /t tabulación. 
        }

}
}

