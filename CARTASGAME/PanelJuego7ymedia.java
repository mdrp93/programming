/**
 * JAVA: Ejerciciós de Clases y Objetós (1): Carta y Baraja - JUEGO 7 Y MEDIA
 * @author Maria DrP
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PanelJuego7ymedia extends JPanel {
    private JTextArea areaTexto;
    private JButton botonPedirCarta;
    private JButton botonPlantarse;
    private Baraja baraja;
    private double puntuacionPersona;
    private double puntuacionOrdenador;
    private Map<String, ImageIcon> imagenesCartas;
    private JLayeredPane layeredPane; // Agrega un JLayeredPane

    public PanelJuego7ymedia() {
        setLayout(new BorderLayout());

        // Inicializar el JLayeredPane
        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER); // Agrega el JLayeredPane al panel principal

        cargarImagenesCartas(); // Llama al método para cargar las imágenes 

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        // Cargar iconos
        ImageIcon iconoPedirCarta = new ImageIcon("icono_cartas.png");
        ImageIcon iconoPlantarse = new ImageIcon("plantarse.png");

        // Escalar los iconos al tamaño deseado
        Image imagenPedirCarta = iconoPedirCarta.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoPedirCartaEscalado = new ImageIcon(imagenPedirCarta);

        Image imagenPlantarse = iconoPlantarse.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoPlantarseEscalado = new ImageIcon(imagenPlantarse);

        // Crear botones con iconos escalados
        botonPedirCarta = new JButton(iconoPedirCartaEscalado);
        botonPlantarse = new JButton(iconoPlantarseEscalado);

        botonPedirCarta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carta carta = baraja.robar();
                puntuacionPersona += carta.valor7ymedia();
                System.out.println("Se muestra la animación?");
                animacionRecibirCarta(carta); // Mostrar la animación de recibir la carta
                
                if (puntuacionPersona > 7.5) {
                    areaTexto.append("¡Te has pasado de 7.5! Has perdido.\n");
                    finJuego();
                } else {
                    areaTexto.append("Has recibido una carta: " + carta.getNombreCarta() + ". Tu puntuación actual es: " + puntuacionPersona + "\n");
                }
            }
        });



    botonPlantarse.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            areaTexto.append("Te has plantado. Es el turno de la máquina.\n");
            turnoMaquina();
        }
    });

    // Agregar botones al panel de botones
    panelBotones.add(botonPedirCarta);
    panelBotones.add(botonPlantarse);
    add(panelBotones, BorderLayout.SOUTH);

    iniciarJuego();
}



    private void cargarImagenesCartas() {
        // Cargamos las cartas al mapa y asociamos nombres
        imagenesCartas = new HashMap<>();
        ImageIcon asCorazones = new ImageIcon("imagenCartas/h01.png");
        if (asCorazones.getImageLoadStatus() != MediaTracker.COMPLETE) {
        System.err.println("Error al cargar la imagen As_de_Corazones.");
        }
        
        //corazones
        imagenesCartas.put("As_de_Corazones", new ImageIcon("imagenCartas/h01.png"));
        imagenesCartas.put("2_de_Corazones", new ImageIcon("imagenCartas/h02.png"));
        imagenesCartas.put("3_de_Corazones", new ImageIcon("imagenCartas/h03.png"));
        imagenesCartas.put("4_de_Corazones", new ImageIcon("imagenCartas/h04.png"));
        imagenesCartas.put("5_de_Corazones", new ImageIcon("imagenCartas/h05.png"));
        imagenesCartas.put("6_de_Corazones", new ImageIcon("imagenCartas/h06.png"));
        imagenesCartas.put("7_de_Corazones", new ImageIcon("imagenCartas/h07.png"));
        imagenesCartas.put("8_de_Corazones", new ImageIcon("imagenCartas/h08.png"));
        imagenesCartas.put("9_de_Corazones", new ImageIcon("imagenCartas/h09.png"));
        imagenesCartas.put("10_de_Corazones", new ImageIcon("imagenCartas/h10.png"));
        imagenesCartas.put("J_de_Corazones", new ImageIcon("imagenCartas/h11.png"));
        imagenesCartas.put("Q_de_Corazones", new ImageIcon("imagenCartas/h12.png"));
        imagenesCartas.put("K_de_Corazones", new ImageIcon("imagenCartas/h13.png"));
        //diamantes
        imagenesCartas.put("As_de_Diamantes", new ImageIcon("imagenCartas/d01.png"));
        imagenesCartas.put("2_de_Diamantes", new ImageIcon("imagenCartas/d02.png"));
        imagenesCartas.put("3_de_Diamantes", new ImageIcon("imagenCartas/d03.png"));
        imagenesCartas.put("4_de_Diamantes", new ImageIcon("imagenCartas/d04.png"));
        imagenesCartas.put("5_de_Diamantes", new ImageIcon("imagenCartas/d05.png"));
        imagenesCartas.put("6_de_Diamantes", new ImageIcon("imagenCartas/d06.png"));
        imagenesCartas.put("7_de_Diamantes", new ImageIcon("imagenCartas/d07.png"));
        imagenesCartas.put("8_de_Diamantes", new ImageIcon("imagenCartas/d08.png"));
        imagenesCartas.put("9_de_Diamantes", new ImageIcon("imagenCartas/d09.png"));
        imagenesCartas.put("10_de_Diamantes", new ImageIcon("imagenCartas/d10.png"));
        imagenesCartas.put("J_de_Diamantes", new ImageIcon("imagenCartas/d11.png"));
        imagenesCartas.put("Q_de_Diamantes", new ImageIcon("imagenCartas/d12.png"));
        imagenesCartas.put("K_de_Diamantes", new ImageIcon("imagenCartas/d13.png"));
        //tréboles
        imagenesCartas.put("As_de_treboles", new ImageIcon("imagenCartas/c01.png"));
        imagenesCartas.put("2_de_treboles", new ImageIcon("imagenCartas/c02.png"));
        imagenesCartas.put("3_de_treboles", new ImageIcon("imagenCartas/c03.png"));
        imagenesCartas.put("4_de_treboles", new ImageIcon("imagenCartas/c04.png"));
        imagenesCartas.put("5_de_treboles", new ImageIcon("imagenCartas/c05.png"));
        imagenesCartas.put("6_de_treboles", new ImageIcon("imagenCartas/c06.png"));
        imagenesCartas.put("7_de_treboles", new ImageIcon("imagenCartas/c07.png"));
        imagenesCartas.put("8_de_treboles", new ImageIcon("imagenCartas/c08.png"));
        imagenesCartas.put("9_de_treboles", new ImageIcon("imagenCartas/c09.png"));
        imagenesCartas.put("10_de_treboles", new ImageIcon("imagenCartas/c10.png"));
        imagenesCartas.put("J_de_treboles", new ImageIcon("imagenCartas/c11.png"));
        imagenesCartas.put("Q_de_treboles", new ImageIcon("imagenCartas/c12.png"));
        imagenesCartas.put("K_de_treboles", new ImageIcon("imagenCartas/c13.png"));
        //picas
        imagenesCartas.put("As_de_picas", new ImageIcon("imagenCartas/s01.png"));
        imagenesCartas.put("2_de_picas", new ImageIcon("imagenCartas/s02.png"));
        imagenesCartas.put("3_de_picas", new ImageIcon("imagenCartas/s03.png"));
        imagenesCartas.put("4_de_picas", new ImageIcon("imagenCartas/s04.png"));
        imagenesCartas.put("5_de_picas", new ImageIcon("imagenCartas/s05.png"));
        imagenesCartas.put("6_de_picas", new ImageIcon("imagenCartas/s06.png"));
        imagenesCartas.put("7_de_picas", new ImageIcon("imagenCartas/s07.png"));
        imagenesCartas.put("8_de_picas", new ImageIcon("imagenCartas/s08.png"));
        imagenesCartas.put("9_de_picas", new ImageIcon("imagenCartas/s09.png"));
        imagenesCartas.put("10_de_picas", new ImageIcon("imagenCartas/s10.png"));
        imagenesCartas.put("J_de_picas", new ImageIcon("imagenCartas/s11.png"));
        imagenesCartas.put("Q_de_picas", new ImageIcon("imagenCartas/s12.png"));
        imagenesCartas.put("K_de_picas", new ImageIcon("imagenCartas/s13.png"));

        
        System.out.println("Se han cargado las imagenes");
    }

    private void iniciarJuego() {
        baraja = new Baraja(1, true);
        puntuacionPersona = 0;
        puntuacionOrdenador = 0;
        areaTexto.setText("¡Bienvenido al juego de 7 y Media!\n");
    }

    
    private void finJuego() {       //Determinar el resultado y mostrar la animación correspondiente
        String resultado;
        if (puntuacionPersona > 7.5 && puntuacionOrdenador > 7.5) {
            resultado = "¡Ambos jugadores se han pasado de 7.5! ¡Ha habido un empate!";
            
        } else if (puntuacionPersona > 7.5) {
            resultado = "¡Te has pasado de 7.5! Has perdido.";
           
        } else if (puntuacionOrdenador > 7.5) {
            resultado = "La máquina se ha pasado de 7.5. ¡Has ganado!";
           
        } else {
            // Ninguno se ha pasado de 7.5, determinar quién está más cerca
            double diferenciaPersona = 7.5 - puntuacionPersona;
            double diferenciaOrdenador = 7.5 - puntuacionOrdenador;
            if (diferenciaPersona < diferenciaOrdenador) {
                resultado = "¡Has ganado!";
               
            } else if (diferenciaOrdenador < diferenciaPersona) {
                resultado = "¡La máquina gana!";
           
            } else {
                resultado = "¡Ha habido un empate!";
            }
        }
        areaTexto.append("Resultado: " + resultado + "\n"+ "FIN");
    }
    
    private void turnoMaquina() {
        Timer timer = new Timer(1000, new ActionListener() {
            int contador = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador < 3) {
                    Carta carta = baraja.robar();
                    puntuacionOrdenador += carta.valor7ymedia();
                    areaTexto.append("La máquina ha recibido una carta: " + carta.getNombreCarta() + ". Su puntuación actual es: " + puntuacionOrdenador + "\n");
                    contador++;
                } else {
                    ((Timer)e.getSource()).stop();
                    if (puntuacionOrdenador > 7.5) {
                        areaTexto.append("La máquina se ha pasado de 7.5. ¡Has ganado!\n");
                      
                    } else {
                        areaTexto.append("La máquina se ha plantado. Comparando puntuaciones...\n");
                        finJuego();
                    }
                }
            }
        });
        timer.start();
    }

    private void animacionRecibirCarta(Carta carta) {
      
        // Obtener la imagen de la carta recibida desde el mapa
        ImageIcon imagenCarta = imagenesCartas.get(carta.getNombreCarta()); 
        int x = (800 - 100) / 2; // (ancho de la cuadrícula - ancho de la carta) / 2
        int y = (600 - 150) / 2; // (altura de la cuadrícula - altura de la carta) / 2

        // Crear un JLabel para mostrar la carta
        JLabel labelCarta = new JLabel(imagenCarta);
        labelCarta.setOpaque(true);
        labelCarta.setBackground(Color.BLUE);
        labelCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelCarta.setBounds(x, y, 100, 150); // Tamaño de la carta
        
        // Establecer la posición de la carta (ajustar según sea necesario)
        labelCarta.setBounds(50, 50, 100, 150);
        
        // Agregar la carta al JLayeredPane en la capa PALETTE_LAYER
        layeredPane.add(labelCarta, JLayeredPane.PALETTE_LAYER);
        
        // Configurar el orden de la capa del JLabel para asegurarse de que esté por encima de otros componentes
        layeredPane.setLayer(labelCarta, layeredPane.getComponentsInLayer(JLayeredPane.PALETTE_LAYER).length);
        
        // Llamar a revalidate() y repaint() para actualizar el JLayeredPane
        layeredPane.revalidate();
        layeredPane.repaint();
    
        // Agregar un mensaje de depuración para verificar si se ejecuta el método
        System.out.println("Se ha llamado al método animacionRecibirCarta");
    }
}    


/*Map: Es una interfaz en Java que representa una colección de pares clave-valor, donde cada clave es única y está asociada a un valor. 
Hay diferentes implementaciones de Map en Java, como HashMap, TreeMap, LinkedHashMap, entre otros. En este caso, imagenesCartas es una variable que se espera que contenga un Map.
<String, ImageIcon>: Esto especifica el tipo de datos de la clave y el valor dentro del Map. En este caso, la clave es de tipo String y el valor es de tipo ImageIcon. 
Por lo tanto, private Map<String, ImageIcon> imagenesCartas; declara una variable imagenesCartas que se espera que sea un mapa que asocie nombres de cartas (String) con imágenes de esas cartas (ImageIcon). */