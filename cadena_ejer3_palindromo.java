import java.util.Scanner;

public class cadena_ejer3_palindromo {
   
    public static boolean esPalindrome(String cadena) { 
        
        cadena = cadena.toLowerCase(); 
        cadena = cadena.replaceAll("\\s+","");
        
        for(int i = 0; i < cadena.length() / 2; i++) { //INFO 1
            if(cadena.charAt(i) != cadena.charAt(cadena.length() - 1 - i)) {    //INFO 2      
        return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a sentence: ");
        String cadena = in.nextLine();  

        if (esPalindrome(cadena)==true){
            System.out.println ("The word \"" + cadena+ "\" IS a PALINDROME.");  
        }
        else {
            System.out.println ("The word \"" + cadena + "\" is NOT a PALINDROME."); 
        } 
       
        
    }

}

/*INFO 1: La expresión "cadena.length() - 1 - i" se utiliza para acceder a los elementos de una cadena de texto 
en orden inverso, empezando desde el último elemento y avanzando hacia el primero, según el valor de "i". */

/* INFO 2: "- i" se resta el valor de la variable "i" al resultado anterior. Esto permite iterar por los 
elementos de la cadena en orden inverso según el valor de "i". Por ejemplo, si "i" es 0, entonces se estará 
mirando el último elemento de la cadena, si "i" es 1, se estará mirando el penúltimo elemento, y así sucesivamente.*/