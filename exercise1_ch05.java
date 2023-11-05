import java.util.Scanner;

public class exercise1_ch05 {

       public static void main (String[] args){
        
       System.out.println("Insert a number: ");
        Scanner in = new Scanner(System.in); 
         int x =  in.nextInt();

        if (x < 10 && x>0) { System.out.println( "numero positivo de un solo digito." ); } 
    }
       
}
