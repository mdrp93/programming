public class libro_ch06_ejer6_scrable {
    
        public static boolean canSpell(String tiles, String word) {
            // Convert the tiles and word strings to char arrays
            char[] tilesArray = tiles.toCharArray();
            char[] wordArray = word.toCharArray();
            
            // Create a letter frequency map for the tiles
            int[] tileFrequency = new int[26];
            for (char tile : tilesArray) {
                tileFrequency[tile - 'a']++;
            }
            
            // Check if each letter in the word can be formed using the tiles
            for (char letter : wordArray) {
                if (tileFrequency[letter - 'a'] > 0) {
                    tileFrequency[letter - 'a']--;
                } else {
                    return false; // Tile not available
                }
            }
            
            return true; // All letters can be formed using the tiles
        }
        
        public static void main(String[] args) {
            String tiles = "quijibo";
            String word = "jib";
            
            if (canSpell(tiles, word)) {
                System.out.println("The tiles can spell the word.");
            } else {
                System.out.println("The tiles cannot spell the word.");
            }
        }
    }


/*
En este código, el método canSpell toma dos cadenas como entrada: tiles, que representa el conjunto de fichas, 
y palabras, que representa la palabra a probar. 
El método primero convierte las cadenas en matrices de caracteres para facilitar su manipulación.
A continuación, crea un mapa de frecuencia de letras para las fichas utilizando una matriz de enteros 
tileFrequency. Cada elemento en tileFrequency representa la frecuencia de una letra en las fichas, 
donde el índice i corresponde a la letra 'a' + i. La frecuencia de cada letra se calcula iterando a través de 
tilesArray e incrementando el elemento correspondiente en tileFrequency.

Luego, el método verifica si cada letra en wordArray puede formarse utilizando las fichas. Lo hace iterando a 
través de wordArray y verificando si la frecuencia de la letra en tileFrequency es mayor que 0. 
Si lo es, reduce la frecuencia en 1. Si la frecuencia ya es 0, significa que la letra no está disponible en las 
fichas y el método devuelve false.

Finalmente, si todas las letras de la palabra se pueden formar utilizando las fichas, el método devuelve true. 
En el método principal, se muestra un ejemplo de uso del método canSpell, donde se verifica si las fichas pueden
 formar la palabra "jib". El resultado se muestra en la consola.
 */


/* ENGLISH:
In this code, the canSpell method takes two strings as input: tiles, which represents the set of tiles, and word, 
which represents the word to test. The method first converts the strings to char arrays for easier manipulation.
Next, it creates a letter frequency map for the tiles using an integer array tileFrequency. 
Each element in tileFrequency represents the frequency of a letter in the tiles, where the index i corresponds 
to the letter 'a' + i. The frequency of each letter is calculated by iterating through the tilesArray and 
incrementing the corresponding element in tileFrequency.

Then, the method checks if each letter in the wordArray can be formed using the tiles. It does this by 
iterating through the wordArray and checking if the frequency of the letter in tileFrequency is greater than 0.
If it is, it decrements the frequency by 1. If the frequency is already 0, it means the letter is not available in 
the tiles, and the method returns false.

Finally, if all letters in the word can be formed using the tiles, the method returns true. In the main method, 
an example usage of the canSpell method is shown, where it checks if the tiles can spell the word "jib". 
The result is printed to the console. */