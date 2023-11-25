import java.util.Scanner;

public class cadenas_ejer16_vecesPalabra{
        
           
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        String cadenaDondeBuscar = "hola";
        String loQueQuieroBuscar = sc.nextLine();
        String[] palabras = loQueQuieroBuscar.split("\\W+"); 
    
        for (String palabra : palabras) {
            if (cadenaDondeBuscar.contentEquals(palabra)) {
                System.out.println("Encontrado");
                
            }
        }
    }}