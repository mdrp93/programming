

    import java.util.Scanner;

public class cadena_ejer15_vecesCaracter {
        
  public static int vecesPalabra(String cadena, char caracter) {     
                
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter) {
                contador++;
            }
        }
        return contador;
    }
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.print("Write the sentence ");
        String cadena = in.nextLine();  
        
        System.out.print("Write the character you want to search for: ");
        char character= in.next().charAt(0);
        
        int veces = vecesPalabra(cadena, character);
        System.out.println("The word \"" + character + "\" appears in the string "+ veces+ " times.");
    }
}
    

