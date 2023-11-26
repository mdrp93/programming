import java.util.Scanner;

public class cadena_ejer12_quitaCaracter{
        
          public static String quitaCharacter(String palabra, char s) {
          palabra=palabra.toLowerCase(); 
            String  nuevaPalabra= "";
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) != s) {
                    nuevaPalabra += palabra.charAt(i);
                }
            }
            return nuevaPalabra;
        }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
                 
        System.out.println("Writte the sentences: ");
        String word = in.nextLine();
           
        System.out.println("Write the character to be remove: ");
        char caracter = in.next().charAt(0);
      
        String solution = quitaCharacter(word, caracter);
        System.out.println(solution);
            
        
        }
    }
