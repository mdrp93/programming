import java.awt.Color;
import java.awt.Graphics;

public class Cell {

    public static final Color[] COLORS = {Color.WHITE, Color.RED, Color.BLUE, Color.BLACK};

    private final int x;
    private final int y;
    private final int size;
    private int state;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = 0; // Inicialmente apagada
    }

    public void draw(Graphics g) {
        g.setColor(COLORS[state]);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, size, size);
    }

    public boolean isOn() {
        return state == 1; // Viva
    }

    public boolean isOff() {
        return state == 0;
    }

    public boolean isTransitional() {
        return state == 2; // Retorna verdadero si la célula está en estado moribundo
    }

    public void turnOff() {
        state = 0; // Muerta
    }

    public void turnOn() {
        state = 1; // Viva
    }

    public void transition() {
        state = 2; // Representa el estado de célula moribunda
    }
}


