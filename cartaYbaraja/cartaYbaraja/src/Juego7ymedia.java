import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/


public class Juego7ymedia extends JPanel {

    private JTextArea areaTexto;
    private JButton botonPedirCarta;
    private JButton botonPlantarse;
    private JButton botonReinicio;
    private Baraja baraja;
    private double puntuacionPersona;
    private double puntuacionOrdenador;
    private String usuario;
    private JLayeredPane layeredPane; // Agrega un JLayeredPane

    public Juego7ymedia() {
        setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER); // Agrega el JLayeredPane al panel principal

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.BOLD, 18));
        areaTexto.setForeground(Color.BLUE);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

    
        // Cargar iconos
        // Cargar iconos utilizando getResource()
        ImageIcon iconoPedirCarta = new ImageIcon(getClass().getResource("/resources/icono_cartas_copy.png"));
        ImageIcon iconoPlantarse = new ImageIcon(getClass().getResource("/resources/plantarse_copy.png"));
        ImageIcon iconoReinicio = new ImageIcon(getClass().getResource("/resources/reiniciar.png"));

        // Escalar los iconos al tamaño deseado
        Image imagenPedirCarta = iconoPedirCarta.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoPedirCartaEscalado = new ImageIcon(imagenPedirCarta);

        Image imagenPlantarse = iconoPlantarse.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoPlantarseEscalado = new ImageIcon(imagenPlantarse);

        Image imagenReinicio = iconoReinicio.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoReinicioEscalado = new ImageIcon(imagenReinicio);

        // Crear botones con iconos escalados
        botonPedirCarta = new JButton(iconoPedirCartaEscalado);
        botonPlantarse = new JButton(iconoPlantarseEscalado);
        botonReinicio = new JButton(iconoReinicioEscalado);

        botonPedirCarta.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Cartas carta = baraja.robar();
                puntuacionPersona += carta.valor7ymedia();

                if (puntuacionPersona > 7.5) {
                    areaTexto.append("\n"+usuario+" recibe carta: \n" + carta.getNombreCarta().toUpperCase()
                            + ".\n \nTu puntuación actual es: " + puntuacionPersona + "\n\n¡Te has pasado de 7.5!" + "\n Has perdido.\n");
                    finJuego();
                } else {
                    areaTexto.append("\n"+usuario+" recibe carta: \n" + carta.getNombreCarta().toUpperCase()
                            + ".\n \nTu puntuación actual es: " + puntuacionPersona + "\n");

                }
            }
        });

        botonReinicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });

        botonPlantarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("\n"+ usuario +" se ha plantado." + "\n\n Es el turno del oponente.\n");
                turnoMaquina();
            }
        });

        // Agregar botones al panel de botones
        panelBotones.add(botonPedirCarta);
        panelBotones.add(botonPlantarse);
        panelBotones.add(botonReinicio);
        add(panelBotones, BorderLayout.SOUTH);

        iniciarJuego();
    }

    private void iniciarJuego() {
        baraja = new Baraja(1, true);
        puntuacionPersona = 0;
        puntuacionOrdenador = 0;
        solicitarNombreUsuario(); 

    }

    private void solicitarNombreUsuario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));    //layout a BoxLayout vertical
        JLabel label = new JLabel("Introduce tu nombre:");
        JTextField textField = new JTextField(10); // Tamaño del campo de texto
        textField.setText("Usuario"); // Texto predeterminado

        panel.add(label);
        panel.add(textField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Nombre de usuario", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
            // Si se presiona "Aceptar", asigna el nombre ingresado por el usuario
            usuario = textField.getText();
            } else {
            // Si se presiona "Cancelar" o se cierra el cuadro de diálogo, cierra el programa
            System.exit(0);
            }
        areaTexto.append("¡Bienvenido al juego Siete y Media, " + usuario + "!\n" + "Usa los botones para robar carta o plantarte.\n\n");
        }

    private void finJuego() { // Determinar el resultado
        String resultado;
        if (puntuacionPersona > 7.5 && puntuacionOrdenador > 7.5) {
            resultado = "\n ¡Ambos jugadores se han pasado de 7.5! \t¡Ha habido un empate!" + "\n";

        } else if (puntuacionPersona > 7.5) {
            resultado = "\n¡Te has pasado de 7.5! Has perdido." + "\n";

        } else if (puntuacionOrdenador > 7.5) {
            resultado = "\nEl oponente se ha pasado de 7.5. ¡Has ganado!" + "\n";

        } else {
            // Ninguno se ha pasado de 7.5, determinar quién está más cerca
            double diferenciaPersona = 7.5 - puntuacionPersona;
            double diferenciaOrdenador = 7.5 - puntuacionOrdenador;
            if (diferenciaPersona < diferenciaOrdenador) {
                resultado = "\n¡Has ganado!";
            } else if (diferenciaOrdenador < diferenciaPersona) {
                resultado = "\n¡El oponente gana!" + "\n";
            } else {
                resultado = "\n¡Ha habido un empate!" + "\n";
            }
        }
        areaTexto.append("\nResultado: " + resultado + "\t\t\t" + "FIN" + "\n");
        botonPlantarse.setEnabled(false);
        botonPedirCarta.setEnabled(false);
        botonReinicio.setEnabled(true);
    }

    private void reiniciarJuego() {
        // Limpiar el JTextArea
        areaTexto.setText("");

        botonPedirCarta.setEnabled(true);
        botonPlantarse.setEnabled(true);
        botonReinicio.setEnabled(false);

        iniciarJuego();
    }

    private void turnoMaquina() {
        Timer timer = new Timer(1000, new ActionListener() {
            int contador = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador < 3) {
                    Cartas carta = baraja.robar();
                    puntuacionOrdenador += carta.valor7ymedia();
                    areaTexto.append("\nOponente recibe carta: \n" + carta.getNombreCarta().toUpperCase()
                            + ".\n\nSu puntuación actual es: " + puntuacionOrdenador + "\n");
                    contador++;
                } else {
                    ((Timer) e.getSource()).stop();
                    if (puntuacionOrdenador > 7.5) {
                        areaTexto.append("\nEl oponente se ha pasado de 7.5. \n¡Has ganado!\n\t\t\tFIN");
                        botonPlantarse.setEnabled(false);
                        botonPedirCarta.setEnabled(false);

                    } else {
                        areaTexto.append("\nEl oponente se ha plantado. \nComparando puntuaciones...\n");
                        botonPlantarse.setEnabled(false);
                        botonPedirCarta.setEnabled(false);
                        finJuego();
                    }
                }
            }
        });
        timer.start();
        botonReinicio.setEnabled(true);
    }


}
