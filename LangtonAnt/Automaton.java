import javax.swing.JFrame;


public abstract class Automaton {

    protected GridCanvas grid;  //modificador de acceso protegido.
    private int prevCount = Integer.MAX_VALUE;

  
    public abstract void update();

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


    private void mainloop(int rate) {
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


    /**
     * Creates a JFrame and runs the automaton
     * @param title the frame title
     * @param rate frames per second
     */
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
