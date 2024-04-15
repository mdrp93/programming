/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

public class Carta {
   
    private int numero;
    private int palo;


/**
 * CONSTRUCTORES
 */

    // Constructor para crear una carta con el número y el palo
    public Carta(int numero, int palo) {
        if (!((1 <= numero && numero <= 10) && (0 <= palo && palo <= 3))) {
            throw new IllegalArgumentException("Valores de número y/o palo incorrectos.");
        }
        this.numero = numero;
        this.palo = palo;
    }

    // Constructor para validar una carta pasando el ID
    public Carta (int id) {
        if (id < 1 || id > 40) {
            throw new IllegalArgumentException("ID de carta fuera de rango.");
        }
        this.numero = (id - 1) % 10 + 1;
        this.palo = (id - 1) / 10;
    }

/**
 * PROPIEDADES
 */
    // Obtener el número y el palo de la carta
    public int getNumero() {
        return numero;
    }

    public int getPalo() {
        return palo;
    }


/**
 * MÉTODOS
 */
    // Obtener el nombre del número de la carta
    public String nombreNumero() {
        String[] nombres = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"}; //para que sean 10 debe no haber ni 8, ni 9, ni 10
        return nombres[numero - 1];
    }

    // Obtener el nombre del palo de la carta
    public String nombrePalo() {
        String[] palos = {"corazones", "diamantes", "treboles", "picas"};
        return palos[palo];
    }

    // Obtener el nombre de la carta
    public String getNombreCarta() {
        return nombreNumero() + " de " + nombrePalo();
    }

    // Obtener el valor de la carta en el juego del tute
    public int valorTute() {
        switch (numero) {
            case 1: return 11;
            case 3: return 10;
            case 8: return 2;
            case 9: return 3;
            case 10: return 4;
            default: return 0;
        }
    }

    // Obtener el valor de la carta en el juego del mus
    public int valorMus() {
        if (numero == 1 || numero == 2) {
            return 1;
        } else if (numero == 3 || numero >= 8) {
            return 10;
        } else {
            return numero;
        }
    }

    // Obtener el valor de la carta en el juego de las 7 y media
    public double valor7ymedia() {
        return (numero >= 8 && numero <= 10) ? 0.5 : numero;
    }



}
