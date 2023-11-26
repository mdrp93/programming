import java.util.Scanner;

public class cadena_ejer8_quitaEspacios {

    public static String quitaEspaciosTrim(String cadena) {
        int inicio = 0;
        int fin = cadena.length() - 1;

        while (inicio <= fin && cadena.charAt(inicio) == ' ') {// Encuentra el índice del primer carácter que no sea un espacio en blanco desde el inicio de la cadena
        inicio++;
        }
        
        while (fin >= inicio && cadena.charAt(fin) == ' ') {// Encuentra el índice del último carácter que no sea un espacio en blanco desde el final de la cadena
        fin--;
         }
    
        return cadena.substring(inicio, fin + 1);// Devuelve la cadena sin los espacios en blanco al principio y al final
    }       
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a sentence: ");
        String cadena = in.nextLine();  
        
        String cadenaSin = quitaEspaciosTrim(cadena);
        System.out.println(" Sentence without spaces :"+cadenaSin);

        
    }

}
