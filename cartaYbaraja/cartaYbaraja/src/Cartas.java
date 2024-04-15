import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

public class Cartas {
    private int num;
    private int palo;
    private ImageIcon icono;
    private String nombreCarta;

/**
 * CONSTRUCTORES 
 */

    //Creamos una carta 
    public Cartas (int num, int palo){
        if (!((1<= num && num <=10) && (0<= palo && palo <= 3))){
            throw new IllegalArgumentException("Valores de número y/o palo incorrectos.");
        }
        this.num = num;
        this.palo = palo;
        
    }
    
    

    //Validamos una carta pasando el ID
    public Cartas (int id){
        if (id < 1 || id > 40 ){
            throw new IllegalArgumentException("ID de carta fuera de rango.");
        }
        // asignamos valores ID a num y a palo
        this.num = (id - 1) % 10 + 1;
        this.palo = (id -1)/ 10;
    } 

/**
 * PROPIEDADES
 */
    public int getNum(){
        return num;
    }

    public int getPalo(){
        return palo;
    }

/**
 *  MÉTODOS
 */

    public String nombreNum(){
        String [] nombres = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota","caballo", "rey"};
        return nombres [num - 1];
    }

    public String nombrePalo(){
        String[] palos = {"corazones", "diamantes", "tréboles", "picas"};
        return palos[palo];
    }

    public String getNombreCarta() {
        nombreCarta = nombreNum() + nombrePalo();
        icono = cargarIcono(nombreCarta);
        return nombreNum() + " de " + nombrePalo();
        
    }

 
    public int valorTute() {
        switch (num) {
            case 1: return 11;
            case 3: return 10;
            case 8: return 2;
            case 9: return 3;
            case 10: return 4;
            default: return 0;
        }
    }
    public int valorMus() {
        if (num == 1 || num == 2) {
            return 1;
        } else if (num == 3 || num >= 8) {
            return 10;
        } else {
            return num;
        }
    }

    public double valor7ymedia() {
        return (num >= 8 && num <= 10) ? 0.5 : num;
    }

    private static final Map<String, String> rutasCartas = new HashMap<>();

    private static void inicializarRutasCartas() {
        rutasCartas.put("ascorazones", "/resources/ImgCartas/h01.png");
        rutasCartas.put("doscorazones", "/resources/ImgCartas/h02.png");
        rutasCartas.put("trescorazones", "/resources/ImgCartas/h03.png");
        rutasCartas.put("cuatrocorazones", "/resources/ImgCartas/h04.png");
        rutasCartas.put("cincocorazones", "/resources/ImgCartas/h05.png");
        rutasCartas.put("seiscorazones", "/resources/ImgCartas/h06.png");
        rutasCartas.put("sietecorazones", "/resources/ImgCartas/h07.png");
        rutasCartas.put("sotacorazones", "/resources/ImgCartas/h11.png");
        rutasCartas.put("caballocorazones", "/resources/ImgCartas/h12.png");
        rutasCartas.put("reycorazones", "/resources/ImgCartas/h13.png");

        rutasCartas.put("astréboles", "/resources/ImgCartas/c01.png");
        rutasCartas.put("dostréboles", "/resources/ImgCartas/c02.png");
        rutasCartas.put("trestréboles", "/resources/ImgCartas/c03.png");
        rutasCartas.put("cuatrotréboles", "/resources/ImgCartas/c04.png");
        rutasCartas.put("cincotréboles", "/resources/ImgCartas/c05.png");
        rutasCartas.put("seistréboles", "/resources/ImgCartas/c06.png");
        rutasCartas.put("sietetréboles", "/resources/ImgCartas/c07.png");
        rutasCartas.put("sotatréboles", "/resources/ImgCartas/c11.png");
        rutasCartas.put("caballotréboles", "/resources/ImgCartas/c12.png");
        rutasCartas.put("reytréboles", "/resources/ImgCartas/c13.png");

        rutasCartas.put("aspicas", "/resources/ImgCartas/s01.png");
        rutasCartas.put("dospicas", "/resources/ImgCartas/s02.png");
        rutasCartas.put("trespicas", "/resources/ImgCartas/s03.png");
        rutasCartas.put("cuatropicas", "/resources/ImgCartas/s04.png");
        rutasCartas.put("cincopicas", "/resources/ImgCartas/s05.png");
        rutasCartas.put("seispicas", "/resources/ImgCartas/s06.png");
        rutasCartas.put("sietepicas", "/resources/ImgCartas/s07.png");
        rutasCartas.put("sotapicas", "/resources/ImgCartas/s11.png");
        rutasCartas.put("caballopicas", "/resources/ImgCartas/s12.png");
        rutasCartas.put("reypicas", "/resources/ImgCartas/s13.png");

        rutasCartas.put("asdiamantes", "/resources/ImgCartas/d01.png");
        rutasCartas.put("dosdiamantes", "/resources/ImgCartas/d02.png");
        rutasCartas.put("tresdiamantes", "/resources/ImgCartas/d03.png");
        rutasCartas.put("cuatrodiamantes", "/resources/ImgCartas/d04.png");
        rutasCartas.put("cincodiamantes", "/resources/ImgCartas/d05.png");
        rutasCartas.put("seisdiamantes", "/resources/ImgCartas/d06.png");
        rutasCartas.put(" sietediamantes", "/resources/ImgCartas/d07.png");
        rutasCartas.put("sotadiamantes", "/resources/ImgCartas/d11.png");
        rutasCartas.put("caballodiamantes", "/resources/ImgCartas/d12.png");
        rutasCartas.put("reydiamantes", "/resources/ImgCartas/d13.png");


    }
    static {
        inicializarRutasCartas();
    }

    private ImageIcon cargarIcono(String nombreCarta) {
    
        String ruta = rutasCartas.get(nombreCarta);
        if (ruta != null || ruta.equals(nombreCarta)) {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(ruta));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } else {
            // Manejo de error si la carta no tiene una ruta de imagen asociada
            System.err.println("No se encontró la ruta de imagen para la carta: " + nombreCarta);
            return null;
        }
    }

}