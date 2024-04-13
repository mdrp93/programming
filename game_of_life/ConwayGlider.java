import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class ConwayGlider {

    private GridCanvas grid;
    private int prevCount = Integer.MAX_VALUE;

    /*Creates a grid with two Blinkers.*/

    public ConwayGlider(String path) {
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
            
            // Determinar el número de filas y columnas de la cuadrícula
            int rows = lines.size();
            int cols = lines.get(0).length();
            int size = (rows+1)*(cols+1); //tamaño ajustado a las lineas y columnas que hay en el archivo .cells

            // Inicializar la cuadrícula
            grid = new GridCanvas(rows, cols, size);
            
            // Inicializar la cuadrícula basada en los datos leídos
            for (int r = 0; r < rows; r++) {
                String row = lines.get(r);
                for (int c = 0; c < cols; c++) {
                    char cell = row.charAt(c);
                    if (cell == 'O') {
                        grid.turnOn(r, c);
                    }
                }
            }
            scan.close();
            
        } catch (FileNotFoundException e) {
            // Imprimir la traza de la excepción y salir con estado de error
            e.printStackTrace();
            System.exit(1);
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


    private static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                // Any live cell with fewer than two live neighbors dies, as if by underpopulation.
                // Any live cell with more than three live neighbors dies, as if by overpopulation.
                cell.turnOff();
            }
        } else {
            if (count == 3) {
                // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                cell.turnOn();
            }
        }
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

   
    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    /*Simulates one round of Conway's Game of Life.*/
    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    private void updateAndCount()  {
        
        /*Para que el recuento no sea infinito, pero el programa sigue funcionando aunque no se este haciendo ya el recuento una vez estabilizado*/

        int stableCount= 0;       //contamos cuantas interacciones consecutivas con el mismo recuento
        int maxStableIterations = 10;      //número máximo de iteraciones consecutivas con el mismo recuento antes de detener el recuento
        
        while (true) {
            // Actualizar el dibujo y el recuento
            this.update();
            grid.repaint();

            int currentCount = grid.countOn();
            
            // Verificar si el recuento se ha estabilizado
            if (currentCount == prevCount) {
                stableCount++;
            } else {
                stableCount = 0; // Reiniciar el contador si el recuento cambia
            }

            // Detener el conteo si se mantiene constante el recuento durante el número máximo de iteraciones
            if (stableCount >= maxStableIterations) {
                System.out.println("Stable population reached. Stopping count: "+currentCount);
                break; // Salir del bucle de conteo
            }

            if (currentCount != prevCount) {
                System.out.println("Number of cells turned on: " + currentCount);
                prevCount = currentCount; // Actualizar el recuento anterior
            }

            // Retardo de la simulación
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // No hacer nada si ocurre una interrupción
            }
        }
    }


/*The simulation loop.*/
    private void mainloop() {
        while (true) {
            // Actualizar y contar en un hilo separado
            Thread countingThread = new Thread(this::updateAndCount);
            countingThread.start();

            // el conteo se detenga antes de continuar con la siguiente iteración
            try {
                countingThread.join();
            } catch (InterruptedException e) {
            }
        }
    }


    public int countPopulation() {      // Método para obtener el número de celdas encendidas en la cuadrícula
        return grid.countOn(); // Usamos el método countOn de GridCanvas para contar las celdas encendidas
    }
        

    
    
    public static void main(String[] args) {
        String title = "Conway's Game of Life";
        ConwayGlider game = new ConwayGlider("glider.cells");
        JFrame frame = new JFrame(title);  //ventana de la cuadricula principal 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Comportamiento de cierre, otras opciones: (JFrame.DO_NOTHING_ON_CLOSE no realiza ninguna acción), (JFrame.HIDE_ON_CLOSE se oculta pero no cierra app), (JFrame.DISPOSE_ON_CLOSE si es la unica ventana se cierra app)
        frame.setResizable(false); //deshabilitar el redimensionamiento de la ventana
        frame.add(game.grid); //agrega el lienzo gráfico al JFrame
        frame.pack();  //ajusta el tamaño de la ventana automáticamente
        frame.setVisible(true);  //que la ventana JFRame sea visible
        game.mainloop(); //inicia el bucle principal de la simulación

    }

}





/*/*EXERCISE 15.3 */
 /**
    EXAMPLE GLIDER:
    public Conway() {
        grid = new GridCanvas(50, 50, 10); // Por ejemplo, una cuadrícula de 50x50 con celdas de 10x10 píxeles
        grid.turnOn(1, 2);
        grid.turnOn(2, 3);
        grid.turnOn(3, 1);
        grid.turnOn(3, 2);
        grid.turnOn(3, 3);
    } 
    */