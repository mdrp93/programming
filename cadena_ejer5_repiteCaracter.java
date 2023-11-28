import java.util.Scanner;

public class cadena_ejer5_repiteCaracter {

  
   public static String repiteCaracter(char caracter, int cantidad) {
      String cadena = "";
      
      for (int i = 0; i < cantidad; i++) {
         cadena += caracter;
      }
      
      return cadena;
   }
   
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

        System.out.print("Insert caracter: ");
        char c = in.next().trim().charAt(0);
        System.out.println("How many times should it be repeated?");
        int n = in.nextInt();

      System.out.println(repiteCaracter(c, n)); // Output: AAAAA
   }
}


/*En este código, creamos la función repiteCaracter que tiene dos parámetros: 
caracter (de tipo char) y cantidad (de tipo int). 
Dentro de la función, creamos una cadena vacía y luego utilizamos un bucle for para repetir el carácter 
tantas veces como se indique en el parámetro cantidad, concatenando el carácter a la cadena en cada iteración.
En la función main, definimos el carácter c como 'A' y la cantidad n como 5. Luego, llamamos a la función 
repiteCaracter con estos valores y mostramos el resultado por la consola. En este caso, el resultado será "AAAAA".*/