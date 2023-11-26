
//Exercise 3. Chapter 05. Fermat’s Last Theorem says that there are no integers a, b, c, and n such that an + bn = cn [except when n ≤ 2].

import java.util.Scanner;

public class libro_ch05_ejer3_fermat{
  public static void main(String[] args) { 
    Scanner in = new Scanner(System.in); 
    
    System.out.println( "Fermat's Last Theorem: a^n + b^n = c^n (except when n ≤ 2)."); 
    
    System.out.print("Introduce number for a: "); 
    int a = in.nextInt(); 
    System.out.print("Introduce number for b: "); 
    int b = in.nextInt(); 
    System.out.print("Introduce number for c: "); 
    int c = in.nextInt();
    System.out.print("Introduce number for n: "); 
    int n = in.nextInt();
    System.out.println();
      
    checkFermat(a,b,c,n); //method fermat
    in.close();
  }

  public static void checkFermat (int a, int b,int c, int n){         
     
    if (( n>2) && ((int)Math.pow(a,n) + (int)Math.pow(b,n)  == (int)Math.pow(c,n))){                           
        System.out.println("Holy smokes, Fermat was wrong!");  //if n is bigger than 2 and an +bn = cn
    }
    else if ((n<=2)&&((int)Math.pow(a,n) + (int)Math.pow(b,n)  == (int)Math.pow(c,n))) { //if n is lower than 2 and an +bn = cn 
        System.out.println("n with value " +n + " is lower or equal than 2:\nFermat was correct!");
    }
    else{
         System.out.println("No, that doesn't work. Fermat was correct!"); 
         //in the other case, this is what Fermat stated that the equation does not hold if n is greater than 2.
    }
  }
}