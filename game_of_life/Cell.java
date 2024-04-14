import java.awt.Color;
import java.awt.Graphics;


public class Cell {

    public static final Color[] COLORS = {Color.WHITE, Color.BLACK};

    private final int x;    //posicion de la celda
    private final int y;
    private final int size; //tamaño de la celda
    private int state;  //el estado de la celda (0 para apagado, 1 para encendido).

    /**
     * Constructs a new cell, initially turned off.
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param size number of pixels
     */

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = 0;
    }

    /**
     * Draws the cell on the screen.
     * @param g graphics context
     */
    public void draw(Graphics g) {      //dibuja la celda en el contexto gráfico especificado 
        g.setColor(COLORS[state]);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);       //color para el borde del rectángulo
        g.drawRect(x, y, size, size);
    }

    public boolean isOff() {    //Tests whether the cell is off.    
        return state == 0;
    }

    public boolean isOn() {    //Tests whether the cell is on.
        return state == 1;
    }

   
    public void turnOff() {   // Sets the cell's state to off.
        state = 0;
    }

    public void turnOn() {   // Sets the cell's state to on.
        state = 1;
    }

    public boolean isTransitional() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTransitional'");
    }

    public void transition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

}
