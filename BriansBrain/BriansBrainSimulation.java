//RUN: "Usage: java BriansBrainSimulation <filename.rle>"


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BriansBrainSimulation extends JFrame {
    private final int CELL_SIZE = 5;
    private final Color ON_COLOR = Color.WHITE;
    private final Color DYING_COLOR = Color.BLUE;
    private final Color OFF_COLOR = Color.BLACK;
    private ArrayList<Point> cellsToDie;

    private boolean[][] board;
    private Timer timer;

    public BriansBrainSimulation(String filename) {
        setTitle("Brian's Brain");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cellsToDie = new ArrayList<>();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
            }
        };
        panel.setPreferredSize(new Dimension(800, 600));
        add(panel);

        initializeBoard(filename);

        timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextGeneration();
                panel.repaint();
            }
        });
        timer.start();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initializeBoard(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int width = 0, height = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                } else if (line.startsWith("x")) {
                    Pattern pattern = Pattern.compile("x = (\\d+), y = (\\d+)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        width = Integer.parseInt(matcher.group(1));
                        height = Integer.parseInt(matcher.group(2));
                        board = new boolean[height][width];
                    }
                } else {
                    int x = 0, y = 0;
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (c == 'o') { // Célula viva
                            board[y][x] = true;
                        }
                        x++; // Incrementar la coordenada x para la siguiente célula
                        if (x >= width) { // Si x alcanza el ancho máximo, reiniciar a cero y pasar a la siguiente fila
                            x = 0;
                            y++;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void nextGeneration() {
        boolean[][] newBoard = new boolean[board.length][board[0].length];
        cellsToDie.clear();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = countNeighbors(i, j);
                if (board[i][j]) {
                    newBoard[i][j] = false; // Célula muere en el siguiente paso
                    cellsToDie.add(new Point(j, i)); // Agrega la célula a la lista de células moribundas
                } else {
                    newBoard[i][j] = (neighbors == 2); // Célula se enciende si tiene exactamente 2 vecinos
                }
            }
        }
        board = newBoard;
    }

    private int countNeighbors(int x, int y) {
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(board.length - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(board[0].length - 1, y + 1); j++) {
                if (board[i][j] && !(i == x && j == y)) {
                    count++;
                }
            }
        }
        return count;
    }

    private void drawBoard(Graphics g) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Color color;
                if (board[i][j]) {
                    color = ON_COLOR; // Célula viva
                } else if (cellsToDie.contains(new Point(j, i))) {
                    color = DYING_COLOR; // Célula que está muriendo
                } else {
                    color = OFF_COLOR; // Célula muerta
                }
                g.setColor(color);
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java BriansBrainSimulation <filename.rle>");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BriansBrainSimulation(args[0]);
            }
        });
    }
}
