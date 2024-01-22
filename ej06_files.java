package ficheros;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ej06_files{

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Proporciona nombre del archivo y la palabra a buscar como argumentos");
            return;
        }
        
        String fileName = args[0];
        String palabra = args[1];
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linea;
            int contador = 0;
            
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                
                for (String palabraEnLinea : palabras) {
                    if (palabraEnLinea.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
            
            System.out.println("El archivo contiene " + contador + " ocurrencias de la palabra '" + palabra + "'");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

