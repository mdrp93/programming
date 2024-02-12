import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class JapanFlag extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JapanFlag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
              
        Canvas canvas = new JapanFlag();
        canvas.setSize(400, 300); // Ajuste el tamaño para reflejar la proporción correcta
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint (Graphics g) {
        
            
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        
        int diameter = Math.min(getWidth(), getHeight()) * 2 / 5;   //aseguramos que el círculo siempre quepa dentro del componente sin importar su forma. Y multiplica por la proporción deseada : 2/5 > 40%
        int x = (getWidth() - diameter) / 2;    //centramos el círculo horizontalmente sobre el eje x
        int y = (getHeight() - diameter) / 2; //centramos el círculo horizontalmente sobre el eje y
        g.fillOval(x, y, diameter, diameter); //dibujamos el circulo con la posicion calculada antes y las dimensiones . 


        //de esta manera nos aseguramos de que el circulo siempre este centrado con respecto al rectangulo (lienzo)

      
    }

}

