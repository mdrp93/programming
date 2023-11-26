import java.util.Scanner;

public class cadena_ejer4_contiene {

      
    public static boolean contiene(String cadena, char caracter) {
        cadena = cadena.toLowerCase();
        
        for(int i = 0; i < cadena.length(); i++) {
            if(cadena.charAt(i) == caracter) {
                return true;
                
            }
        }
        
        return false;
    }

    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Writte a sentence ");
        String cadena = in.nextLine().trim();  // .trim() to eliminate spaces in the first and final position

        System.out.print("Insert a letter ");
        char caracter =in.next().charAt(0); //.charAt() to read only one caracter in the next line.

        boolean resultado = contiene(cadena, caracter);
        
        if (resultado==true){
        System.out.println ("The character " +"\'"+ caracter +"\'"+ " is present in "+"\'"+cadena+"\'"+".");
        }
        else {  //if contiene is true
        System.out.println ("The character " +"\'"+ caracter +"\'"+ " is not present in "+"\'"+cadena+"\'"+"." );
        } 
    }
}