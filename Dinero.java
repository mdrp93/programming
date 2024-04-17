/**
 * JAVA: Ejerciciós de Clases y Objetós (5): Dinero y Moneda
 * @author Maria DrP
*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Dinero {
    
    private TipoMoneda tMoneda;
    private static ArrayList<Moneda> listaMonedas = new ArrayList<>();
    private static Map<TipoMoneda, String> codigosMoneda = new HashMap<>();
    
    private double cantidad;
    
   
    

    //Constructores
   
        // Constructor con cantidad como double y TipoMoneda
    public Dinero(double cantidad, TipoMoneda tMoneda) {
        this.cantidad = cantidad;
        this.tMoneda = tMoneda;
    }

    // Constructor con cantidad como int y TipoMoneda
    public Dinero(int cantidad, TipoMoneda tMoneda) {
        this.cantidad = cantidad;
        this.tMoneda = tMoneda;
    }

    // Bloque estático
    static {
        // Inicializamos la lista 
        listaMonedas.add(new Moneda(TipoMoneda.EURO, 2, "€", 1));
        listaMonedas.add(new Moneda(TipoMoneda.DOLAR, 2, "$", 1.18));
        listaMonedas.add(new Moneda(TipoMoneda.LIBRA, 2, "£", 0.86));
        listaMonedas.add(new Moneda(TipoMoneda.YEN, 0, "¥", 130.85));
        listaMonedas.add(new Moneda(TipoMoneda.PESO, 2, "MXN$", 24.70));
        listaMonedas.add(new Moneda(TipoMoneda.FRANCO, 2, "CHF", 1.08));
    }


    /*static {
        // Inicializamos la lista de monedas con sus códigos
        listaMonedas.add(new Moneda(TipoMoneda.EURO, 2, "€", 1, "EUR"));
        codigosMoneda.put(TipoMoneda.EURO, "EUR");

        listaMonedas.add(new Moneda(TipoMoneda.DOLAR, 2, "$", 1.18, "USD"));
        codigosMoneda.put(TipoMoneda.DOLAR, "USD");

        listaMonedas.add(new Moneda(TipoMoneda.LIBRA, 2, "£", 0.86, "GBP"));
        codigosMoneda.put(TipoMoneda.LIBRA, "GBP");

        listaMonedas.add(new Moneda(TipoMoneda.YEN, 0, "¥", 130.85, "JPY"));
        codigosMoneda.put(TipoMoneda.YEN, "JPY");

        listaMonedas.add(new Moneda(TipoMoneda.PESO, 2, "MXN$", 24.70, "MXN"));
        codigosMoneda.put(TipoMoneda.PESO, "MXN");

        listaMonedas.add(new Moneda(TipoMoneda.FRANCO, 2, "CHF", 1.08, "CHF"));
        codigosMoneda.put(TipoMoneda.FRANCO, "CHF");
    }*/

    /*public static void actualizaListaInternet() {         NO FUNCIONA POR QUE LA URL ME DA FALLO TODO EL RATO, ES PROBABLE QUE SEA POR EL ENTORNO VSCODE. 
        try {
            URL url = new URL("https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_2Mkpi15sIJIIPM9Ko7SiQKyDmNc8iXg6uz9WdKmM"); //para esto hace falta un usuario en alguna API que te den la CLAVE_KEY yo me he hecho uno gratuito en https://app.freecurrencyapi.com/
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                // Procesar cada línea y agregar a la listaMonedas
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    TipoMoneda tipoMoneda = TipoMoneda.valueOf(parts[0]);
                    int decimales = Integer.parseInt(parts[1]);
                    String simbolo = parts[2];
                    double cambioEuro = Double.parseDouble(parts[3]);
                    String codigo = parts[4];
                    listaMonedas.add(new Moneda(tipoMoneda, decimales, simbolo, cambioEuro, codigo));
                }
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    // Getters y setters
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public TipoMoneda getMoneda() {
        return tMoneda;
    }

    public void setMoneda(TipoMoneda tMoneda) {
        this.tMoneda = tMoneda;
    }

    //Métodos estáticos
    public static void actualizaCambio(TipoMoneda t, double cambio) {
        Moneda moneda = buscaMoneda(t);
        if (moneda != null) {
            moneda.setCambioEuro(cambio);
        } else {
            throw new IllegalArgumentException("La moneda no existe en la lista.");
        }
    }

    private static Moneda buscaMoneda(TipoMoneda t) {
        for (Moneda moneda : listaMonedas) {
            if (moneda.getMoneda() == t) {
                return moneda;
            }
        }
        return null; // Si no se encuentra la moneda nos devuelve null
    }
   
    public static Map<TipoMoneda, String> getCodigosMoneda() {
        return codigosMoneda;
    }


    public String toString() {
        Moneda miMoneda = buscaMoneda(tMoneda);
        int decimales = miMoneda.getDecimales();
        double divisor = Math.pow(10, decimales);
        double cantidadMult = this.cantidad * divisor;
        double cantidadRed = Math.round(cantidadMult) / divisor;
        return cantidadRed + miMoneda.getSimbolo();
    }

    public double valorEn(TipoMoneda t) {
        double cambio = 0;
        for(Moneda moneda : listaMonedas) {
            if(moneda.getMoneda().equals(t)) {
                cambio = moneda.getCambioEuro();
                break;
            }
        }
        double valor = this.cantidad * cambio;
        valor = valor * 100;
        valor = Math.round(valor);
        valor = valor / 100;
        return valor;
    }


    public Dinero convierteEn(TipoMoneda t) {
        double cambio = 0;
        double valor;
        TipoMoneda tipo = TipoMoneda.EURO;
        for(Moneda moneda : listaMonedas) {
            if(moneda.getMoneda().equals(t)) {
                cambio = moneda.getCambioEuro();
                tipo = moneda.getMoneda();
                break;
            }
        }
        valor = this.cantidad * cambio;
        valor = valor * 100;
        valor = Math.round(valor);
        valor = valor / 100;
        Dinero dinero = new Dinero(valor, tipo);
        return dinero;
    }


    public String toString(TipoMoneda t) {
        Moneda miMoneda = buscaMoneda(t);
        int decimales = miMoneda.getDecimales();
        double divisor = Math.pow(10, decimales);
        double cantidadMult = this.cantidad * divisor;
        double cantidadRed = Math.round(cantidadMult) / divisor;
        return cantidadRed + miMoneda.getSimbolo();
    }

   //operadores
   public Dinero add(Dinero dinero) {
    if (tMoneda != dinero.getMoneda()) {
        dinero = dinero.convierteEn(tMoneda);
    }
    return new Dinero(cantidad + dinero.getCantidad(), tMoneda);
    }

    public Dinero substract(Dinero dinero) {
        if (tMoneda != dinero.getMoneda()) {
            dinero = dinero.convierteEn(tMoneda);
        }
        return new Dinero(cantidad - dinero.getCantidad(), tMoneda);
    }
    
    public Dinero multiply(double multiplicador) {
        return new Dinero(cantidad * multiplicador, tMoneda);
    }

    public Dinero divide(double divisor) {
        return new Dinero(cantidad / divisor, tMoneda);
    }

    public Dinero negate() {
        return new Dinero(-cantidad, tMoneda);
    }

    public boolean equals(Dinero din) {
        boolean equal = false;
        Dinero otorDin = convierteEn(tMoneda);
        if(this.cantidad == otorDin.cantidad) {
            return equal = true;
        }
        return equal;
    }

    public int compareTo(Dinero d) {
        Dinero aux = convierteEn(tMoneda);
        if(this.cantidad < aux.cantidad) {
            return -1;
        } else if(this.cantidad > aux.cantidad) {
            return 1;
        } else {
            return 0;
        }
    }



//un main para probar el programa

    public static void main(String[] args) {
    
        //Dinero.actualizaListaInternet();

        System.out.println("Lista de monedas disponibles:");
        for (Moneda moneda : Dinero.listaMonedas) {
            //System.out.println("Tipo de moneda: " + moneda.getMoneda() + ", Código: " + moneda.getCodigo());
            System.out.println("Tipo de moneda: " + moneda.getMoneda());
        }

        // objetos Dinero para probar
        Dinero dinero1 = new Dinero(100.0, TipoMoneda.EURO);
        Dinero dinero2 = new Dinero(50, TipoMoneda.DOLAR);

        // Imprimir las cantidades de dinero
        System.out.println("1 Cantidad inicial en euros: " + dinero1);
        System.out.println("2 Cantidad inicial en dolares: " + dinero2);

        // Probar métodos de conversión
        Dinero dineroConvertido1 = dinero1.convierteEn(TipoMoneda.EURO);
        System.out.println("Cantidad convertida a euros: " + dineroConvertido1);
        Dinero dineroConvertido2 = dinero2.convierteEn(TipoMoneda.DOLAR);
        System.out.println("Cantidad convertida a dólares: " + dineroConvertido2);

        // Probar operaciones con dinero
        Dinero suma = dinero1.add(dinero2);
        Dinero resta = dinero1.substract(dinero2);
        Dinero producto = dinero1.multiply(2);
        Dinero division = dinero1.divide(2);
        Dinero negativo = dinero1.negate();

        // Imprimir resultados de operaciones
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Producto: " + producto);
        System.out.println("División: " + division);
        System.out.println("Negativo de Dinero 1: " + negativo);

        // Probar métodos equals y compareTo
        Dinero dinero3 = new Dinero(100.0, TipoMoneda.EURO);
        Dinero dinero4 = new Dinero(100.0, TipoMoneda.EURO);

        System.out.println("Dinero 3 es igual a Dinero 1: " + dinero3.equals(dinero1));
        System.out.println("Comparación entre Dinero 3 y Dinero 4: " + dinero3.compareTo(dinero4));
    }
}


