/*Exercise 2  
Modify Mickey.java to draw ears on the ears, and ears on those ears, and more ears all the way down until the smallest ears are only 3 pixels wide. 
*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class Mickey extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mickey Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Mickey();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.WHITE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Rectangle bb = new Rectangle(100, 100, 200, 200);
        mickey(g, bb);
    }

    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }

    public void mickey(Graphics g, Rectangle bb) {
        boxOval(g, bb);

        // Si el ancho (o alto) de la oreja es menor o igual a 3, detiene la recursión.
        if (bb.width <= 3) {
            return;
        }

        int hx = bb.width / 2;  //anchura de instancia bb
        int hy = bb.height / 2; //altura de la instancia bb
        
        Rectangle leftEar = new Rectangle(bb.x - hx / 2, bb.y - hy / 2, hx, hy);
        Rectangle rightEar = new Rectangle(bb.x + bb.width - hx / 2, bb.y - hy / 2, hx, hy);

        mickey(g, leftEar);
        mickey(g, rightEar);
    }
}
   
