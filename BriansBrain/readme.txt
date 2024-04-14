PASO A PASO:

### Tamaño de Célula (`CELL_SIZE`)
```java
private final int CELL_SIZE = 5;
```
Esta constante determina el tamaño de cada célula en la cuadrícula. En este caso, cada célula será un cuadrado de 5x5 
píxeles.

### Colores
```java
private final Color ON_COLOR = Color.WHITE;
private final Color DYING_COLOR = Color.BLUE;
private final Color OFF_COLOR = Color.BLACK;
```
Se definen tres colores para representar diferentes estados de las células: `ON_COLOR` para células vivas (blanco),
`DYING_COLOR` para células que están muriendo (azul) y `OFF_COLOR` para células muertas (negro).

### ArrayList de Células Moribundas (`cellsToDie`)
```java
private ArrayList<Point> cellsToDie;
```
Se crea un `ArrayList` de objetos `Point` para almacenar las coordenadas de las células que están muriendo en 
cada generación.

### Cuadrícula de Juego (`board`)
```java
private boolean[][] board;
```
Se declara una matriz booleana `board` para representar el estado de la cuadrícula del juego. Cada elemento de la 
matriz representa el estado de una célula: `true` para célula viva y `false` para célula muerta.

### Timer (`timer`)
```java
private Timer timer;
```
Se crea un temporizador que controlará la velocidad de la simulación.

### Constructor de la Clase (`BriansBrainSimulation`)
```java
public BriansBrainSimulation(String filename)
```
En el constructor de la clase:
- Se establece el título de la ventana como "Brian's Brain".
- Se configura el cierre de la ventana al hacer clic en el botón de cierre (exit).
- Se crea un panel personalizado (`JPanel`) para dibujar la cuadrícula del juego.
- Se inicializa la cuadrícula de juego llamando al método `initializeBoard()` con el nombre del archivo de configuración.
- Se configura el temporizador para que llame al método `nextGeneration()` y repinte el panel cada vez que se active.
- Se empaqueta la ventana, se la coloca en el centro de la pantalla y se la hace visible.

### Método `initializeBoard(String filename)`
```java
private void initializeBoard(String filename)
```
Este método se encarga de leer el archivo de configuración y establecer el estado inicial de la cuadrícula de juego.

### Método `nextGeneration()`
```java
private void nextGeneration()
```
Este método calcula el siguiente estado de la cuadrícula de juego basándose en las reglas de Brian's Brain.

### Método `countNeighbors(int x, int y)`
```java
private int countNeighbors(int x, int y)
```
Este método cuenta el número de vecinos vivos de una célula dada en una posición dada (x, y).

### Método `drawBoard(Graphics g)`
```java
private void drawBoard(Graphics g)
```
Este método dibuja la cuadrícula de juego en el panel.

### Método `main(String[] args)`
```java
public static void main(String[] args)
```
Este método es el punto de entrada del programa. Se verifica si se proporcionó un nombre de archivo como argumento 
y se crea una instancia de `BriansBrainSimulation` con el nombre del archivo proporcionado como argumento. 
Se utiliza `SwingUtilities.invokeLater()` para asegurarse de que la creación de la interfaz de usuario se ejecute 
en el subproceso de despacho de eventos de Swing para evitar problemas de concurrencia.