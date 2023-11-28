import java.util.Scanner;




public class cadena_ejer13_quitaAcentos{
    
        
    public static String quitaAcentos(String cadena) {
        String cadenaSinAcentos = cadena
        .replaceAll("[áäâà]", "a")
        .replaceAll("[éëêè]", "e")
        .replaceAll("[íïîì]", "i")
        .replaceAll("[óöôò]", "o")
        .replaceAll("[úüûù]", "u")
        .replaceAll("[ñ]", "n")
        .replaceAll("[ÁÄÂÀ]", "A")
        .replaceAll("[ÉËÊÈ]", "E")
        .replaceAll("[ÍÏÎÌ]", "I")
        .replaceAll("[ÓÖÔÒ]", "O")
        .replaceAll("[ÚÜÛÙ]", "U")
        .replaceAll("[Ñ]", "N");
        return cadenaSinAcentos;
    }
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
                 
        System.out.println("Writte the sentences: ");
        String word = in.nextLine();

           //String word = "HOLÁ";
        System.out.println(quitaAcentos(word));
        
        }
    }


   
    


/*COMENTARIO:
cuando ejecuto el rograma me quita los acentos al poner el nuevo carácter y me da problemas de normalizacion con UTF-8 creo: h¢la (?st  es £na cÆdena ?centua).
*/
