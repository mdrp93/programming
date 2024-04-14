/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/

import javax.swing.*;

public class Juego7yMediaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ventana = new JFrame("Juego de 7 y Media");
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                PanelJuego7ymedia panelJuego = new PanelJuego7ymedia();
                ventana.add(panelJuego);

                ventana.pack();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });
    }
}
