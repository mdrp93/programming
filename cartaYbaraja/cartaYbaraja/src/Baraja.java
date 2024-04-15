import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

public class Baraja {

    private ArrayList<Cartas> listaCartas;

/*
* CONSTRUCTORES
*/

    public Baraja() {

        listaCartas = new ArrayList<Cartas>(0);   
    }

    public Baraja(int tipobaraja){
        this();
            if (tipobaraja == 1) {
                iniciarbaraja(40);      //baraja normal de 40 cartas
            } else if (tipobaraja == 2) {
                iniciarbaraja(80);      //una baraja doble de 80 cartas
            } else {
                throw new IllegalArgumentException("Tipo de baraja no válido.");
            }
}

    public Baraja(int tipobaraja, boolean barajamos) {
        this(tipobaraja);
        if (barajamos) {
            barajar();
        }
    }

/*
* MÉTODOS
*/

    public void barajar(){
         Collections.shuffle(listaCartas, new Random());
    }

    public void cortar(int numCartas){
        List<Cartas> listaCortada = new ArrayList<>(listaCartas.subList(0, numCartas));
        listaCartas.removeAll(listaCortada);
        listaCartas.addAll(listaCortada);
    }

    public void iniciarbaraja (int numCartas){
        for (int i = 1; i <= numCartas; i++) {
            listaCartas.add(new Cartas(i));
        }
    }

    public Cartas robar() {
        if (listaCartas.isEmpty()) {
            throw new IllegalStateException("La baraja está vacía.");
        }
        Cartas cartaRobada = listaCartas.remove(0);
        return cartaRobada;
    }

    public void insertaCartaFinal(int idCarta){
        listaCartas.add(new Cartas(idCarta));
    }

    public void insertarCartaPrincipio(int idCarta) {
        listaCartas.add(0, new Cartas(idCarta));
    }

    public void insertarCartaFinal(Cartas carta) {
        listaCartas.add(carta);
    }

    public int numCartas() {
        return listaCartas.size();
    }
    
    public boolean vacia(){
        return listaCartas.isEmpty();
    }

}
