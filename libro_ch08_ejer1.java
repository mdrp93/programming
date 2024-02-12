/**
* @author Maria drp
*/

public class libro_ch08_ejer1 {

    public static void main(String[] args) {
        int numVersos = 99; 
        System.out.println();
        bottlesOfBeerSong(numVersos);
    }

    public static void bottlesOfBeerSong(int n) {   //se invoca a si mismo para cada vez ur restando el num del verso . 
        if (n > 0) {
            System.out.println(bottlesOfBeerVerse(n));
            bottlesOfBeerSong(n - 1); //recursivo
        } else {
            System.out.println();
            System.out.println("No hay botellas de cerveza en la pared,\n" +
                               "no hay botellas de cerveza,\n" +
                               "no puedes quitar una, no puedes pasarla,\n" +
                               "¡porque no hay más botellas de cerveza en la pared!");
            System.out.println();
        }
    }

    public static String bottlesOfBeerVerse(int num) {
        if (num == 1) {
            return "1 botella de cerveza en la pared,\n" +
                   "1 botella de cerveza,\n" +
                   "quitas una y la pasas,\n" +
                   "no hay más botellas de cerveza en la pared.";
        } else {
            return num + " botellas de cerveza en la pared,\n" +
                   num + " botellas de cerveza,\n" +
                   "quitas una y la pasas,\n" +
                   (num - 1) + " botellas de cerveza en la pared.\n";
        }
    }
}
