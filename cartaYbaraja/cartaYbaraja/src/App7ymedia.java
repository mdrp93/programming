import javax.swing.*;
import java.awt.*;


/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/
/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

public class App7ymedia extends JFrame {
 
    
    public App7ymedia() {

        // Establecer el diseño de la ventana principal
        setLayout(new BorderLayout());
        
        // Configurar el juego y agregarlo a la ventana principal
        Juego7ymedia juego = new Juego7ymedia();
        add(juego, BorderLayout.CENTER); // Agregar el juego a la ventana
        
        // Configurar la ventana principal
        setTitle("LAS SIETE Y MEDIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Establecer el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true); // Hace visible la ventana
        setResizable(false); //no redimensionable
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App7ymedia());
    }
}
