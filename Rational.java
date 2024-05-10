
//libro_ch11_ejer4.java         /*A Rational number is a number that can be expressed as the quotient or fraction of two integers, a numerator, and a denominator, where the denominator is not zero. */


public class Rational {         //Define a class called Rational. A Rational object should have two integer instance variables that store the numerator and denominator.

    private int numerator;
    private int denominator;


   public Rational() {         //Write a constructor that takes no arguments and sets the numerator to 0 and denominator to 1.
        this.numerator = 0;
        this.denominator = 1; }

    public Rational (int numerator, int denominator){   // Write a second constructor that takes two arguments and uses them to initialize the instance variables. Constructor modified for additional practice
            this.numerator=numerator;
            this.denominator=denominator;
    }

    public void printRational() {                               //Write an instance method called printRational that displays a Rational object in a reasonable format.
        if (denominator == 1) {
            System.out.println(numerator); 
        } else {
            System.out.println(numerator + "/" + denominator);  //This addition handles the special case where the rational number is effectively an integer, providing a cleaner output for such instances.
        }
    }

    public String toString() {                                 //Write a toString method for Rational and test it using println.
        return String.format("%d/%d\n",
            this.numerator, this.denominator);
    }
    
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }
    
    public void negate() {
        numerator = -numerator;
    }

    public void invert() {                     //Write an instance method called invert that swaps the numerator and denominator. It should be a modifier. Add lines to main to test the new method.
        if (numerator == 0) {
            throw new IllegalStateException("Numerator cannot be 0 before inversion.");
        }
        int temp= numerator;
        numerator = denominator;
        denominator = temp;
         /* numerator = -numerator;
         denominator= -denominator;  si queremos que no nos cambie el signo aunque matematicamente esta no sería una operación lógica*/
       
    }

    public double toDouble() {                    //Write an instance method called toDouble that converts the rational number to a double (floating-point number) and returns the result.
        return (double) numerator / denominator;
    }

    
    private static int gcd(int a, int b) {      //by finding the greatest common divisor (GCD)
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public Rational getReduced() {          //Write an instance method named reduce that reduces a rational number to its lowest terms by finding the greatest common divisor (GCD). Este método debería ser un método puro; no debe modificar las variables de instancia del objeto en el que se invoca.
        int gcd = gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }
   
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);     // Minimo Comun Multiplo
    }
    
    public Rational add(Rational r) {
        int commonDenominator = lcm(this.denominator, r.denominator);
        int adjustedNumeratorThis = (commonDenominator / this.denominator) * this.numerator;
        int adjustedNumeratorR = (commonDenominator / r.denominator) * r.numerator;
        int sumNumerator = adjustedNumeratorThis + adjustedNumeratorR;
       
        Rational sum = new Rational(sumNumerator, commonDenominator).getReduced();
        return sum;
    }



public static void main(String[] args) {

    Rational r1 = new Rational();       //Beginners sometimes make the mistake of using new in the constructor. Doing so causes an infinite recursion, since new invokes the same constructor, which uses new again, which invokes the constructor again, and so on.
   
    System.out.println();
    System.out.print("Original to "+r1.getNumerator()+"/"+r1.getDenominator()+": ");
    r1.printRational();

    //String r = r1.toString(); 
    //System.out.println(r);

    Rational r2 =new Rational(8, 6);

    System.out.print("Original to "+r2.getNumerator()+"/"+r2.getDenominator()+": ");
    r2.printRational();
    System.out.println();
    
    System.out.print("Negate to "+r2.getNumerator()+"/"+r2.getDenominator()+":  ");
    r2.negate();
    r2.printRational(); 
    System.out.println();
   
    System.out.print("Invert to "+r2.getNumerator()+"/"+r2.getDenominator()+":  ");
    r2.invert();
    r2.printRational(); 
    System.out.println();

    r2.toDouble();
    System.out.println("To double "+r2.getNumerator()+"/"+r2.getDenominator()+":  "+r2.toDouble());
    System.out.println();

    r2.getReduced();
    System.out.println("Reduce "+r2.getNumerator()+"/"+r2.getDenominator()+":   "+r2.getReduced());
    System.out.println();

    Rational r4 =new Rational(8, 6);
    Rational r3 = new Rational(4, 12);
    
    Rational sum = r4.add(r3);
    System.out.print("Sum to "+r4.getNumerator()+"/"+r4.getDenominator()+" + "+r3.getNumerator()+"/"+r3.getDenominator()+" = " + sum);
    System.out.println();
}

}



/* COMENTARIO ADICIONAL SOBRE EL MÉTODO add:

public Rational add(Rational r) {
        // Primero, encontramos el mínimo común múltiplo (MCM) de los denominadores de los dos números racionales.
        // Esto nos asegura que tenemos un denominador común para poder sumar los numeradores.
    
    int commonDenominator = lcm(this.denominator, r.denominator);

        // A continuación, ajustamos los numeradores de ambos números racionales para reflejar el nuevo denominador común.
        // Multiplicamos el numerador de cada fracción por el factor necesario para que su denominador sea igual al MCM.
    
    int adjustedNumeratorThis = (commonDenominator / this.denominator) * this.numerator;
    int adjustedNumeratorR = (commonDenominator / r.denominator) * r.numerator;

        // Ahora que ambos números racionales tienen el mismo denominador, podemos sumar los numeradores ajustados
        // para obtener el numerador de la suma.
    
    int sumNumerator = adjustedNumeratorThis + adjustedNumeratorR;
   
        //Creamos un nuevo objeto Rational con el numerador de la suma y el denominador común.
        //Antes de devolver este nuevo objeto, lo reducimos a su forma más simple llamando al método getReduced.
        //Esto asegura que el número racional resultante esté en su forma más reducida.
    
    Rational sum = new Rational(sumNumerator, commonDenominator).getReduced();
    
        // Finalmente, devolvemos el nuevo número racional que representa la suma de los dos números racionales originales.
    
    return sum;
}

 */