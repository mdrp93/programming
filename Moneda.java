/**
 * JAVA: Ejerciciós de Clases y Objetós (5): Dinero y Moneda
 * @author Maria DrP
*/


public class Moneda {

      private TipoMoneda tMoneda;
      private int decimales;
      private String simbolo;
      private double cambioEuro;
      //private String codigo;
    

     public Moneda(TipoMoneda tMoneda, int decimales, String simbolo, double cambioEuro) {
        // Comprobaciones de validez de los parámetros
        if (decimales < 0 || decimales > 4) {
            throw new IllegalArgumentException("El número de decimales debe estar entre 0 y 4.");
        }
        if (simbolo == null || simbolo.isEmpty()) {
            throw new IllegalArgumentException("El símbolo de la moneda no puede estar vacío.");
        }
        if (cambioEuro < 0) {
            throw new IllegalArgumentException("El cambio con respecto al euro no puede ser negativo.");
        }

        this.tMoneda = tMoneda;
        this.decimales = decimales;
        this.simbolo = simbolo;
        this.cambioEuro = cambioEuro;
        //this.codigo = codigo;
    }


   /* public String getCodigo() {
        return codigo;
    }*/
    
    public TipoMoneda getMoneda() {
        return tMoneda;
    }

    public int getDecimales() {
        return decimales;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getCambioEuro() {
        return cambioEuro;
    }

    public void setCambioEuro(double cambioEuro) {
        if (cambioEuro < 0) {
            throw new IllegalArgumentException("El cambio con respecto al euro no puede ser negativo.");
        }
        this.cambioEuro = cambioEuro;
    }

}
