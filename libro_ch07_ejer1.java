public class libro_ch07_ejer1 {
    
public static int banana(int[] a) {
    int kiwi = 1;
    int i = 0;
    while (i < a.length) {
        kiwi = kiwi * a[i];
        i++;
    }
    return kiwi;
}
public static int grapefruit(int[] a, int grape) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == grape) {
            return i;
        }
    }
    return -1;
}
public static int pineapple(int[] a, int apple) {
    int pear = 0;
    for (int pine: a) {
        if (pine == apple) {
            pear++;
        }
    }
    return pear;
}



}



   /*Ejercicio 1  
El propósito de este ejercicio es practicar la lectura de 
código y el reconocimiento de los patrones transversales de 
este capítulo. Los siguientes métodos son difíciles de leer 
porque en lugar de usar nombres significativos para las variables
 y métodos, usan nombres de frutas.

Para cada método, escribe una oración que describa lo que hace
 el método, sin entrar en detalles de cómo funciona. Y para 
 cada variable, identifique el papel que desempeña. */

 