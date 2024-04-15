import javax.swing.*;

public class MiFrame extends JFrame {
    private JLayeredPane layeredPane; // Declarar JLayeredPane como un miembro de la clase

    public MiFrame() {

        
        System.out.println("apareces por algun sitio mierdoso?");
        // Inicializar JLayeredPane
        layeredPane = new JLayeredPane();
        setContentPane(layeredPane);
        
        setTitle("Ejemplo de JLayeredPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear componentes para agregar al JLayeredPane
        JLabel fondo = new JLabel(new ImageIcon("paper-texture.jpg"));
        fondo.setBounds(50, 50, 800, 600); // Establecer el tamaño y la posición del fondo
        
        JLabel etiqueta = new JLabel("¡Hola, mundo!");
        etiqueta.setBounds(300, 250, 200, 50); // Establecer el tamaño y la posición de la etiqueta
        
        // Agregar componentes al JLayeredPane con capas específicas
        layeredPane.add(fondo, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(etiqueta, JLayeredPane.PALETTE_LAYER);
        
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MiFrame frame = new MiFrame();
            frame.setVisible(true);
        });
    }
}


