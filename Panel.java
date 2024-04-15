import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    ImageIcon imagen;
    String nombre;

    public Panel (String nombre){
        this.nombre=nombre;
        setLayout(new BorderLayout()); 
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void paintComponent(Graphics g){   
        super.paintComponent(g);   
        if (imagen != null) {
            Dimension tamaño = getSize();
            imagen = new ImageIcon(getClass().getResource(nombre));
            g.drawImage(imagen.getImage(), 0, 0, tamaño.width, tamaño.height, null);
            setOpaque(false);
        }
        
    }
}



//Info: link web información sobre paneles graficos en JAVA (https://picarcodigo.blogspot.com/2012/08/poner-imagen-de-fondo-en-un-jpanel.html)