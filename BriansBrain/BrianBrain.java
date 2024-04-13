

public class BrianBrain extends automatabrain {

    public BrianBrain(int rows, int cols) {
        int celulaSize = 20; // Tamaño de la celda en píxeles
        grid = new GridCanvas(rows, cols, celulaSize);

        // Configuración inicial de células
        setInitialCells();
    }

    private void setInitialCells() {
       
        grid.turnOn(4, 0);
        grid.turnOn(4, 1);
        grid.turnOn(5, 0);
        grid.turnOn(5, 1);
        grid.turnOn(4, 10);
        grid.turnOn(5, 10);
        grid.turnOn(6, 10);
        grid.turnOn(3, 11);
        grid.turnOn(7, 11);
        grid.turnOn(2, 12);
        grid.turnOn(8, 12);
        grid.turnOn(2, 13);
        grid.turnOn(8, 13);
        grid.turnOn(5, 14);
        grid.turnOn(3, 15);
        grid.turnOn(7, 15);
        grid.turnOn(4, 16);
        grid.turnOn(5, 16);
        grid.turnOn(6, 16);
        grid.turnOn(5, 17);
        grid.turnOn(2, 20);
        grid.turnOn(3, 20);
        grid.turnOn(4, 20);
        grid.turnOn(2, 21);
        grid.turnOn(3, 21);
        grid.turnOn(4, 21);
        grid.turnOn(1, 22);
        grid.turnOn(5, 22);
        grid.turnOn(0, 24);
        grid.turnOn(1, 24);
        grid.turnOn(5, 24);
        grid.turnOn(6, 24);
        grid.turnOn(2, 34);
        grid.turnOn(3, 34);
        grid.turnOn(2, 35);
        grid.turnOn(3, 35);
    }

    private void evolve() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];

        // Calcula el número de vecinos vivos para cada célula
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }

        // Aplica las reglas del juego para actualizar el estado de las células
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c); // Corregido el método
                int count = counts[r][c];
                updateCelula(cell, count);
            }
        }
    }

    private int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);
        return count;
    }

    private static void updateCelula(Cell celula, int count) {
        if (celula.isOn()) { // Si la célula está viva
            if (count < 2 || count > 3) {
                celula.transition(); // Muere (se convierte en moribunda)
            }
        } else if (celula.isTransitional()) { // Si la célula está moribunda
            celula.turnOff(); // Muere (se convierte en muerta)
        } else { // Si la célula está muerta
            if (count == 3) {
                celula.turnOn(); // Revive (se convierte en viva)
            }
        }
    }
    

    public void update() {
        evolve();
    }

    public static void main(String[] args) {
        String title = "Speed";
        BrianBrain game = new BrianBrain(50, 50);

        // Ejecuta la simulación con una velocidad de actualización de 20 FPS
        game.run(title, 3);
    }
}
