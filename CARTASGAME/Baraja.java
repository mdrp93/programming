/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/



import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {
    
    private ArrayList<Carta> listaCartas;
    private Carta ultimaCartaRobada; 
/*
* CONSTRUCTORES
*/
    // Baraja vacía
    public Baraja() {
        listaCartas = new ArrayList<Carta>();   //vacía
        ultimaCartaRobada = null; // Inicialmente no hay ninguna carta robada
    }


    // Baraja del tipo especificado
    public Baraja(int tipoBaraja) {
        this();
        if (tipoBaraja == 1) {
            inicializarBaraja(40);      //baraja normal de 40 cartas
        } else if (tipoBaraja == 2) {
            inicializarBaraja(80);      //una baraja doble de 80 cartas
        } else {
            throw new IllegalArgumentException("Tipo de baraja no válido.");
        }
    }

    //baraja del tipo especificado, barajarla si o no
    public Baraja(int tipoBaraja, boolean barajar) {
        this(tipoBaraja);
        if (barajar) {
            barajar();
        }
    }
    


/*
* MÉTODOS
*/
    
      // Método para robar una carta
      public Carta robar() {
        if (listaCartas.isEmpty()) {
            throw new IllegalStateException("La baraja está vacía.");
        }
        Carta cartaRobada = listaCartas.remove(0);
        ultimaCartaRobada = cartaRobada; // Actualizar la última carta robada
        return cartaRobada;
    }

    // Método para obtener la última carta robada
    public Carta getUltimaCartaRobada() {
        return ultimaCartaRobada;
    }
    // Iicializar baraja con el número de cartas especificado
    private void inicializarBaraja(int numCartas) {
        for (int i = 1; i <= numCartas; i++) {
            listaCartas.add(new Carta(i));
        }
    }

    //Barajar las cartas de la baraja
    public void barajar() {
        Collections.shuffle(listaCartas, new Random());
    }

    //Cortar la baraja
    public void cortar(int numeroCartas) {
        List<Carta> listaCortada = new ArrayList<>(listaCartas.subList(0, numeroCartas));
        listaCartas.removeAll(listaCortada);
        listaCartas.addAll(listaCortada);
    }

    //Insertar una carta al final o al principio de la baraja
    public void insertarCartaFinal(int idCarta) {
        listaCartas.add(new Carta(idCarta));
    }

    public void insertarCartaPrincipio(int idCarta) {
        listaCartas.add(0, new Carta(idCarta));
    }

    public void insertarCartaFinal(Carta carta) {
        listaCartas.add(carta);
    }

    public void insertarCartaPrincipio(Carta carta) {
        listaCartas.add(0, carta);
    }

    //Obtener el número de cartas en la baraja
    public int numeroCartas() {
        return listaCartas.size();
    }

    //Verificar si la baraja está vacía
    public boolean vacia() {
        return listaCartas.isEmpty();
    }
}

