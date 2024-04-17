
/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

public class Cartas {
    private int num;
    private int palo;
 
   
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

}