/*3 COLORES: VIVAS MUERTAS Y MORIBUNDAS*/

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeedsAutomata extends JPanel {
    private boolean[][] grid;
    private ArrayList<Point> cellsToDie; // Lista de células moribundas
    private int size;
    private int cellSize;
    private int delay;

    public SeedsAutomata (int size, int cellSize, int delay) {
        this.size = size;
        this.cellSize = cellSize;
        this.delay = delay;
        this.grid = new boolean[size][size];
        this.cellsToDie = new ArrayList<>();
        setPreferredSize(new Dimension(size * cellSize, size * cellSize));
        
        // Inicializar el patrón
        initializePattern("seeds.rle");
    }

    private void initializePattern(String path) {
        try {
            File file = new File(path);
            Scanner scan = new Scanner(file);
    
            // ArrayList para almacenar las líneas que representan la cuadrícula
            ArrayList<String> lines = new ArrayList<>();
    
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (!line.startsWith("!") && !line.isEmpty()) {
                    lines.add(line);
                }
            }
            
            int startX = (size - lines.get(0).length()) / 2;
            int startY = (size - lines.size()) / 2;

            // Asumiendo que las líneas representan el estado inicial de la cuadrícula,
            // actualiza la cuadrícula `grid` con el patrón centrado
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < line.length(); j++) {
                    grid[startY + i][startX + j] = (line.charAt(j) == 'O'); // Suponiendo que 'O' representa una célula viva
                }
            }
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void startSimulation() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nextGeneration();
                repaint();
            }
        }).start();
    }

    private void nextGeneration() {
        boolean[][] newGrid = new boolean[size][size];
        cellsToDie.clear(); // Limpiar la lista de células moribundas
        // Aplicar las reglas
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (grid[i][j]) { // Célula viva
                    // Si una célula está viva y tiene exactamente 2 vecinos vivos, permanece viva
                    // De lo contrario, la célula muere
                    if (aliveNeighbors != 2) {
                        // Marcar la célula como moribunda si no tiene exactamente 2 vecinos vivos
                        cellsToDie.add(new Point(i, j));
                    }
                    newGrid[i][j] = true;
                } else { // Célula muerta
                    // Si una célula está muerta y tiene exactamente 2 vecinos vivos, se enciende
                    // De lo contrario, la célula permanece muerta
                    newGrid[i][j] = (aliveNeighbors == 2);
                }
            }
        }
        // Eliminar células moribundas de la cuadrícula
        for (Point p : cellsToDie) {
            newGrid[p.x][p.y] = false;
        }
        grid = newGrid;
    }

    private int countAliveNeighbors(int x, int y) {
        int aliveNeighbors = 0;
        // Recorrer los vecinos de la célula en un vecindario de Moore
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignorar la propia célula
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                // Verificar si el vecino está dentro de los límites del grid
                if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
                    // Incrementar el contador si el vecino está vivo
                    if (grid[newX][newY]) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        return aliveNeighbors;
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Establecer el color de fondo negro
    setBackground(Color.BLACK);

    // Dibujar el fondo
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    // Definir colores para las células vivas, muertas y moribundas
    Color colorViva = Color.WHITE;
    Color colorMuerta = Color.BLACK;
    Color colorMoribunda = Color.BLUE;

    // Dibujar las células en tres colores diferentes
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (grid[i][j]) {
                // Dibujar células vivas en blanco
                g.setColor(colorViva);
            } else if (cellsToDie.contains(new Point(i, j))) {
                // Dibujar células moribundas en rojo
                g.setColor(colorMoribunda);
            } else {
                // Dibujar células muertas en azul
                g.setColor(colorMuerta);
            }
            g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
        }
    }
}

    public static void main(String[] args) {
        int size = 250; // Tamaño del grid
        int cellSize = 5; // Tamaño de cada célula en píxeles
        int delay = 30; // Retardo en milisegundos entre generaciones

        SeedsAutomata automata = new SeedsAutomata(size, cellSize, delay);
        JFrame frame = new JFrame("Automata Celular Seeds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(automata);
        frame.pack();
        frame.setVisible(true);
        automata.startSimulation();
    }
}
