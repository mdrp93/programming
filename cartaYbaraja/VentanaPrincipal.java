/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/


import javax.swing.*;

public class VentanaPrincipal extends JFrame{
    public VentanaPrincipal() {
        setTitle("Juego de 7 y Media");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelJuego7ymedia panelJuego = new PanelJuego7ymedia();
        add(panelJuego);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}