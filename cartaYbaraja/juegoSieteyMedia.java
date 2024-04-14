/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja 
 * @author Maria DrP
*/

package relacionEjerJava.cartaYbaraja;
import java.util.Scanner;


public class juegoSieteyMedia {
    
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("¡Juguemos a 7 y Media!");
    System.out.println();

    Baraja baraja = new Baraja(1, true); //Creamos la baraja


     // Inicializamos las puntuaciones
     double puntuacionPersona = 0;
     double puntuacionOrdenador = 0;


      //Turno del usuario
      System.out.println("Empecemos es TU TURNO: ");
      while (true) {
          // Mostramos la puntuación actual del jugador humano
          System.out.println("Tu puntuación actual es: " + puntuacionPersona);
          System.out.print("¿Quieres una carta más? (s/n): ");
          String respuesta = scanner.nextLine();

          if (respuesta.equalsIgnoreCase("s")) {
              // Robamos una carta y actualizamos la puntuación del jugador humano
              Carta carta = baraja.robar();
              puntuacionPersona+= carta.valor7ymedia();

              // Verificamos si el jugador humano se ha pasado de 7.5
              if (puntuacionPersona> 7.5) {
                  System.out.println("¡Te has pasado de 7.5! Has perdido.");
                  break;
              }
          } else if (respuesta.equalsIgnoreCase("n")) {
              break; // El jugador humano se planta
          } else {
              System.out.println("Por favor, introduce 's' para sí o 'n' para no.");
          }
      }

    
    // Turno deL pc
    System.out.println();
    System.out.println("Es el TURNO DE LA MÁQUINA:");
    while (true) {
        // Mostramos la puntuación actual de El PC
        System.out.println("La puntuación de la máquina es: " +  puntuacionOrdenador );

        // El PC roba una carta si su puntuación es menor que 7.5
        if ( puntuacionOrdenador  < 7.5) {
            Carta carta = baraja.robar();
            puntuacionOrdenador  += carta.valor7ymedia();
        } else {
            break; //El PC se planta si su puntuación es 7.5 o más
        }
    }

// Mostramos las puntuaciones finales
System.out.println();
System.out.println("Puntuación final:");
System.out.println("Tu puntuación: " +  puntuacionPersona);
System.out.println("Puntuación de la computadora: " + puntuacionOrdenador );

// Determinamos al ganador
if (( puntuacionPersona <= 7.5 &&  puntuacionPersona > puntuacionOrdenador ) || puntuacionOrdenador > 7.5) {
    System.out.println("¡Felicidades! ¡Has ganado!");
} else if ((puntuacionOrdenador  <= 7.5 && puntuacionOrdenador  >  puntuacionPersona) ||  puntuacionPersona > 7.5) {
    System.out.println("¡La computadora gana!");
} else {
    System.out.println("¡Ha habido un empate!");
}

scanner.close();
}
}