import java.util.Scanner;

public class cadena_ejer20_quitaTodosEspacios {
  
 
    
        public static String quitaEspaciosSobrantes(String cadena) {
            String resultado = cadena.trim(); // Eliminar espacios delante y detrás
            resultado = resultado.replaceAll("\\s+", " "); // Dejar solo un espacio entre las palabras
            
            return resultado;
    
              }
        
            
        
        public static void main(String[] args) {
            String cadena= "   mi    mama me   mima   ";
        
            String resultado = quitaEspaciosSobrantes(cadena);
            System.out.println(resultado); // Imprime "Mi~mamá~me~mima"
        }
    }
    
       

