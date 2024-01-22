import java.util.Scanner;

public class libro_ch08_ejer4 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);       
    
    System.out.println("Insert a number for m \"(You should try it only for small values of m and n (no greater than 3).\"");    
    System.out.print("Value m: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Insert a number, no greater than 3: ");
    }
    int m = in.nextInt();

    System.out.println("Insert a number for n \"(You should try it only for small values of m and n (no greater than 3).\"");    
    System.out.print("NValue n: ");
    while (!in.hasNextInt()) {   
        String word = in.next();
        System.err.println("ERROR IMPUT: "+word + " is not a number");
        System.out.print("Insert a number, no greater than 3: ");
    }
    int n = in.nextInt();
       
    int result = ack(m, n);
    System.out.println("The result of the Ackermann function for m=" + m + " y n=" + n + " es: " + result);
}

public static int ack(int m, int n) {
    if (m == 0) {
        return n + 1;               //n+1	if  m = 0. Primera regla. 
    } 
    else if (m > 0 && n == 0) {
        return ack(m - 1, 1);       //A(m−1, 1)	if  m > 0  and  n = 0. Segunda regla. 
    } 
    else if (m > 0 && n > 0) {
        return ack(m - 1, ack(m, n - 1));   //A(m,n)= A(m−1, A(m, n−1)) si m>0 y n>0. Tercera regla de la función.
    } 
    else {
        throw new IllegalArgumentException("The values of m and n must be non-negative.");  // En este caso, los valores de m y n positivos o no negetivos. 
    }
}
}
    
    

/*INFO: La función de Ackermann es una función matemática recursiva propuesta por Wilhelm Ackermann en 1928. 
Esta función se utiliza comúnmente como un ejemplo en teoría de la computación para ilustrar la naturaleza de 
las funciones recursivas no primitivas recursivas y para mostrar la capacidad de cálculo de las máquinas de Turing.

Esta función crece extremadamente rápido y es conocida por su capacidad para generar valores grandes incluso 
para entradas relativamente pequeñas. */

/*EJEMPLO DE LA FUNCIÓN ACKERMANN: 
m = 2 y n = 2.

Primera llamada: ack(2, 2) > Como m y n son ambos mayores que 0, la función entra en la tercera regla. >  Llama a ack(2, 1) (recursión en la tercera regla).
Segunda llamada: ack(2, 1) > Nuevamente, m y n son ambos mayores que 0, entonces entra en la tercera regla. > Llama a ack(2, 0) (recursión en la tercera regla).
Tercera llamada: ack(2, 0) > Ahora n es 0, por lo que la segunda regla se aplica > llama a ack(1, 1).
Cuarta llamada: ack(1, 1) > Nuevamente, m y n son ambos mayores que 0, por lo que entra en la tercera regla. > Llama a ack(1, 0) (recursión en la tercera regla).
Quinta llamada: ack(1, 0) > Ahora n es 0, por lo que la segunda regla se aplica  > llama a ack(0, 1).
Sexta llamada: ack(0, 1) > Ahora m es 0, por lo que la primera regla se aplica > devuelve 1 + 1, que es 2.

Llamadas pendientes:

    La quinta llamada (ack(1, 0)) devuelve 2.
    La cuarta llamada (ack(1, 1)) devuelve 2.
    La tercera llamada (ack(2, 0)) devuelve el resultado de la cuarta llamada, que es 2.
    La segunda llamada (ack(2, 1)) devuelve el resultado de la tercera llamada, que es 2.
    La primera llamada (ack(2, 2)) devuelve el resultado de la segunda llamada, que es 2.
    En resumen, ack(2, 2) finalmente devuelve 7. 
    
*/