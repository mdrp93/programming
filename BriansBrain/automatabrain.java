import javax.swing.JFrame;

public abstract class automatabrain {

    protected GridCanvas grid;

    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }
        return counts;
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

    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCelula(cell, counts[r][c]);
            }
        }
    }

    private static void updateCelula(Cell celula, int count) {
        if (celula.isOn()) {
            if (count < 2 || count > 3) {
                celula.turnOff();
            }
        } else {
            if (count == 3) {
                celula.turnOn();
            }
        }
    }

    private volatile boolean isRunning = true;

    private void mainloop(int rate) {
        while (true) { 
            this.update();
            grid.repaint();

            try {
                Thread.sleep(1000 / rate);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    public void run(String title, int rate) {
        // set up the window frame
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this.grid);
        frame.pack();
        frame.setVisible(true);
        this.mainloop(rate);
    }

}
