import java.util.Scanner;

public class libro_ch07_ejer5_factors {
    public static boolean areFactors(int n, int[] factors) {
        
        for (int factor : factors) {
            if (n % factor != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Please, enter a value for n (not 0): "); 
            while (!in.hasNextInt()) {
                String word = in.next();
                System.err.println("IMPUT ERROR: "+word + " is not a number.");
                System.out.print("Please, enter a value for n: "); 
            }
        int n = in.nextInt();
        
        System.out.print("Enter a length for array (min 3): "); 
        int[]  numbers = new int[in.nextInt()];
        
        int i;
            
        System.out.println("Please enter the numbers you want to check if they are factors of n \n(example: 0 6 5 9 ..): "); 
        
    
            for(i=0; i< numbers.length; i++)
            {
                System.out.printf("Enter a number %d: ", i+1);
                numbers[i] = in.nextInt();
            }
        
                if (areFactors(n, numbers)) {
                    System.out.println("The numbers "+ numbers[i]+" are ALL factors of " + n);
                } 
                else {
                System.out.println("The numbers in the array are NOT all factors of " + n);
                System.out.println();
            }
    }
    }


    

/* 
El método areFactors toma dos parámetros: un entero n y un array de enteros factors. 
- comprueba si todos los elementos son factores de n. 
- Dentro del bucle, utiliza el operador de módulo % para determinar si n es divisible por el elemento actual del array. Si el resultado es diferente de 0, significa que n no es divisible por ese factor y retorna false. 
*/

/*EXAMPLE THE IMPUT FOR THIS CODE:
    Please, enter a value for n (where n is a integer number): 56
    Please, enter a length for array: 8
    Please enter the numbers you want to check if they are factors of n
    (example: 0 6 5 9 ..):
    Enter a number 1: 1
    Enter a number 2: 2
    Enter a number 3: 4
    Enter a number 4: 7
    Enter a number 5: 8
    Enter a number 6: 14
    Enter a number 7: 28
    Enter a number 8: 56
    The numbers in the array are all factors of 56
 */


