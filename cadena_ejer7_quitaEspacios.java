/**
* @author Maria drp
*/

import java.util.Scanner;

public class cadena_ejer7_quitaEspacios {

public static String quitaEspacios(String s) {

    String s2=" ";

    for(int i=0;i<s.length();i++){
        if (s.charAt(i)!=' '){
            s2=s2+s.charAt(i);
        }
    }

    return s2;
        
    }       
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.print("Write a sentence: ");
        String cadena = in.nextLine();  
        
        String cadenaSin = quitaEspacios(cadena);
        System.out.println("Sentence without spaces: "+cadenaSin);

        
    }

    
}
