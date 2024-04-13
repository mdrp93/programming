import java.awt.Canvas;
import java.awt.Graphics;


public class GridCanvas extends Canvas {

    
    private Cell[][] array;  //Cells stored in row-major order. 

    /**
     * Constructs a grid of given size.
     * @param rows number of rows
     * @param cols number of columns
     * @param size pixels per cell
     */

    public GridCanvas(int rows, int cols, int size) {   //inicializa una cuadrícula de celdas con el número de filas (rows), columnas (cols) y tamaño de celda (size) 

        // build 2D array of cells
        array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {            //bucle para recorrer todas las celdas y columnas 
            int y = r * size;                       //Se calcula la coordenada y multiplicando el índice de la fila (r) por el tamaño de la celda (size). Esto asegura que cada fila esté separada verticalmente en el lienzo gráfico.
            for (int c = 0; c < cols; c++) {
                int x = c * size;                   //la coordenada x multiplicando el índice de la columna (c) por el tamaño de la celda (size). Esto asegura que cada columna esté separada horizontalmente en el lienzo gráfico.
                array[r][c] = new Cell(x, y, size); //nueva instancia de la clase Cell, pasando las coordenadas 'x, y' y 'size'. Esta celda representa una celda individual en la cuadrícula y se asigna a la posición correspondiente en el arreglo array.
            }
        }
        // set the canvas size
        setSize(cols * size, rows * size);
    }

    /*metodo para dibujar la cuadricula */

    public void draw(Graphics g) {   //Draws the grid, cell by cell.
        for (Cell[] row : array) {
            for (Cell cell : row) {
                cell.draw(g);
            }
        }
    }

    public void paint(Graphics g) {    // Paints the grid on the screen.
        draw(g);
    }

     public void update(Graphics g) {    // Overriding this method helps the simulation run more smoothly. Normally the Canvas is cleared before painting, but there is no need to clear it since the paint method draws the entire grid.
        draw(g);
     }


    /* Métodos de consulta */

    public int numRows() {   //Gets the number of rows.
        return array.length;
    }

    public int numCols() {    //Gets the number of columns.
        return array[0].length;  
    }

    /**
     * Gets the cell at index (r, c).
     * @param r row index
     * @param c column index
     * @return the cell
     */
    public Cell getCell(int r, int c) {
        return array[r][c];
    }


    /* Métodos para manipular el estado de las celdas */

    public void turnOn(int r, int c) {   //Convenience method that turns on the cell at (r, c)
        array[r][c].turnOn();
    }

    /**
     * Returns 1 if the cell at (r, c) exists and is on. Returns 0 if the cell doesn't exist or is off.
     * @param r row index
     * @param c column index
     * @return 1 or 0
     */
    
    public int test(int r, int c) {

/*EXERCISE 15.2: Modify the test method so that the cells 'wrap around' on the edges. */
    
        int rows = numRows();
        int cols = numCols();
        r = (r + rows) % rows;
        c = (c + cols) % cols;
        
        try {
            if (array[r][c].isOn()) {
                return 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // cell doesn't exist
        }
        return 0;
    }


/*EXERCISE 15.1: write a method named countOn that returns the total number of cells that are “on”. */ 
    
    public int countOn() {
        // Crea una variable para contar las celdas encendidas y  obtienemos el número de filas y columnas en la cuadrícula
        int count = 0;  
        int rows = numRows();
        int cols = numCols();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Verifica si la celda actual está encendida
                if (getCell(r, c).isOn()) {
                    count++;    //Incrementamos el contador si la celda está encendida
                }
            }
        }
        return count; //nos devuelve el total de celdas encendidas
    }
    

}
