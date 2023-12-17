import java.util.Arrays;
import java.util.Scanner;


        
public class libro_ch07_ejer8_anagrams {

    public static String quitaEspaciosSobrantes(String cadena) {
        String resultado = cadena.trim(); //Remove spaces in front and behind
        resultado = resultado.replaceAll("\\s+", " "); 
        
        return resultado;

          }

    public static boolean areAnagrams(String word1, String word2) {

        // Remove whitespace and convert strings to lowercase 
        String cadena1= quitaEspaciosSobrantes(word1).toLowerCase();      //Tambien lo podemos hacer asi: word1 = word1.replaceAll(" ", "").toLowerCase(); pero ya no usariamos nuestro método quitaEspaciosTrim();
        String cadena2= quitaEspaciosSobrantes(word2).toLowerCase();       //Tambien lo podemos hacer asi: word2 = word2.replaceAll(" ", "").toLowerCase(); pero ya no usariamos nuestro método quitaEspaciosTrim();
       

        // Check if both strings have the same length
        if (cadena1.length() != cadena2.length()) {
            return false;
        }
        
        // Convert the strings into arrays of characters
        char[] charArray1 = cadena1.toCharArray();
        char[] charArray2 = cadena2.toCharArray();
        
        // Sort the array of characters in ascending order
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);    //.sort() metodo
        
        // Compare the arrays of characters to see if they are equal
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        
        System.out.print("Writte a word to compare with other: ");
        String word1=in.next();

        System.out.print("Writte a word to compare with other: ");
        String word2=in.next();

            if (areAnagrams(word1, word2)) {
            System.out.println(word1 + " and " + word2 + " are anagrams.");
            } 
            else {
                
            System.out.println(word1+ " and " + word2 + " are NOT anagrams.");
            }
            } 
}




/*COMENTARIO INFORMATIOVO SOBRE FUNCIONAMIENTO DEL MÉTODO .sort():
EN Arrays.sort(), se utiliza el algoritmo de ordenación "quicksort" o "dual-pivot quicksort", dependiendo de la versión de Java. El algoritmo de ordenación toma el arreglo original y lo divide en subarreglos más pequeños.
A continuación, el algoritmo selecciona un elemento (denominado "pivote") del arreglo y lo compara con el resto de los elementos. Los elementos se reorganizan de tal forma que los elementos menores que el pivote se coloquen a su izquierda, 
y los mayores a su derecha. 
El algoritmo repite este proceso en cada subarreglo generado, hasta que todos los elementos estén colocados en su posición ordenada. Una vez que se ha completado el proceso de ordenación, los arreglos charArray1 y 
charArray2 ahora estarán ordenados en orden ascendente.
 */