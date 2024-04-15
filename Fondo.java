import javax.swing.*;

public class Fondo extends JFrame{
    public static void main(String[] args) {
        
        Fondo f = new Fondo();
        f.setSize(400, 300);
        f.setVisible(true);
        Panel p= new Panel("/imagenes/fondo.jpg");
        f.add(p);
    }
}
