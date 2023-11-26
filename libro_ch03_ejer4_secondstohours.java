
import java.util.Scanner;

/** Converts seconds to minutes and hours.*/
public class libro_ch03_ejer4_secondstohours {

    public static void main(String[] args) {
        double seconds;

        int  hour, minute, remainder;
        final double SEC_PER_MIN = 60;
        final int SEC_PER_HOUR = 60;

        Scanner in = new Scanner(System.in);

            // prompt the user and get the value
        System.out.print("How many seconds? ");
            seconds = in.nextDouble(); 
        
        minute = (int) (seconds / SEC_PER_MIN);
        hour = minute / SEC_PER_HOUR;
        remainder = minute%SEC_PER_HOUR;
        System.out.printf("%.0f seconds = %d hour, %d minute, %d seconds \n", seconds, hour, minute, remainder );
   
    }
}

