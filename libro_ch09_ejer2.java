
import java.math.BigInteger;

public class libro_ch09_ejer2 { //big.java

    public static void main(String[] args) {
        System.out.println("Factoriales con BigIntegers:");

        for (int i = 0; i <= 30; i++) {             //usando long no se puede usar un rango superior a 30 porque se desborda.  Para ello debemos usar bigInteger
            BigInteger result = iterativeFactorial(i);
            System.out.println(i + "! = " + result);
        }
    }

    public static BigInteger iterativeFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n; i++) {             //BigInteger.valueOf(i): Convierte el valor entero i a un objeto BigInteger. Este método estático de BigInteger devuelve un objeto BigInteger que contiene el valor de i.
            result = result.multiply(BigInteger.valueOf(i));        //result.multiply(...): Multiplica el valor actual almacenado en result por el valor de BigInteger.valueOf(i)

        }

        return result;
    }
    }

/*1 - Cree un nuevo programa llamado Big.java y escriba una versión iterativa factorial(usando un forbucle).

2 - Muestra una tabla de los números enteros del 0 al 30 junto con sus factoriales. En algún momento, alrededor de los 15, probablemente verás que las respuestas ya no son correctas. ¿Por qué no? 
    A partir de 20 se desborda. 
3 - Convierta factorialpara que realice su cálculo utilizando BigIntegers y devuelva a BigInteger como resultado. Puedes dejar el parámetro solo; seguirá siendo un número entero.
4 - Intente mostrar la tabla nuevamente con su método factorial modificado. ¿Es correcto hasta 30? ¿Qué tan alto puedes hacerlo llegar? 
    Puedes llegar a calcular valores factoriales muy elevados de manera correcta aunque el tiempo de ejecución es altisimo a medida que aumente el valor a calcular.
 * 
 */
