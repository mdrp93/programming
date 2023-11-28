public class libro_ch07_ejer3 {

//En este caso, hemos declarado una variable adicional `currentIndex` para realizar un seguimiento del índice actual mientras recorremos el array utilizando el bucle for mejorado. Esto nos permite actualizar el índice máximo mientras recorremos el array sin tener que usar la variable de control de bucle `i`. */
    public static int indexOfMax(int[] array) {
        int maxIndex = 0;
        int maxValue = array[0];
      
        int currentIndex = 0;
        for (int element : array) {
          if (element > maxValue) {
            maxValue = element;
            maxIndex = currentIndex;
          }
          currentIndex++;
        }
      
        return maxIndex;
      }
    
}
/*Para escribir el método indexOfMax en Java, puedes usar un enfoque con bucle for mejorado o un bucle for tradicional.
Aquí está el código utilizando un bucle for tradicional:
```java
public static int indexOfMax(int[] array) {
  int maxIndex = 0;
  int maxValue = array[0];

  for (int i = 1; i < array.length; i++) {
    if (array[i] > maxValue) {
      maxValue = array[i];
      maxIndex = i;
    }
  }
  return maxIndex;
}
```

Explicación paso a paso:

1. Declaramos y asignamos variables para rastrear el índice y el valor máximo. Inicialmente, el índice máximo se establece en 0 y el valor máximo se establece en el primer elemento del array, `array[0]`.
2. Usamos un bucle for para iterar sobre el resto del array. Comenzamos desde el índice 1, ya que ya hemos considerado el primer elemento.
3. Dentro del bucle, comparamos cada elemento del array con el valor máximo actual. Si encontramos un elemento mayor, actualizamos el valor máximo y el índice máximo.
4. Al final del bucle, devolvemos el índice máximo, que representa la posición del elemento más grande en el array.
*/