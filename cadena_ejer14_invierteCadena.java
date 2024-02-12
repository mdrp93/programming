/**
* @author Maria drp
*/

import java.util.Scanner;

public class cadena_ejer14_invierteCadena {
   
 
    public static String invierteCadena(String cadena) { 
        
        String nuevaCadena="";

        for(int i = cadena.length() -1; i>=0;i--) { 
            nuevaCadena=nuevaCadena+cadena.charAt(i);
            }
        
        return nuevaCadena;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a sentence: ");
        String cadena = in.nextLine();  

        System.out.print(invierteCadena(cadena));
       
        
    }

}


