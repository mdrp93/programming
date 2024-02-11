package expoCoches;

    /**
* Definición de la clase Zona
*
* @author Luis José Sánchez
*/
public class Zona {
    private int entradasPorVender;
        public Zona(int n){
        entradasPorVender = n;
        }
    public int getEntradasPorVender() {
        return entradasPorVender;
        }
   
    public void vender(int n) {
        if (this.entradasPorVender == 0) {
            System.out.println("Lo siento, las entradas para esa zona están agotadas.");
        } 
        else if (this.entradasPorVender < n) {
            System.out.println("Sólo me quedan " + this.entradasPorVender + " entradas para esa zona.");
            System.out.println("Volviendo al menú inicial...");
            return;
        }
        else if (n < 0) {
            System.out.println("Error: No se puede vender un número negativo de entradas.");
            System.out.println("Volviendo al menú inicial...");
            return;
        }
        else if (this.entradasPorVender >= n) {
            entradasPorVender -= n;
            System.out.println("Aquí tiene sus " + n + " entradas, gracias.");
        }
    }
    }
    