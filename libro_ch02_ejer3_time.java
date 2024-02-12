/**
* @author Maria drp
*/

public class libro_ch02_ejer3_time {

    public static void main(String[] args) {
        int hour = 20;
        int minute = 42;
        int second = 20;

        System.out.print("The current time is ");
        System.out.print(hour);
        System.out.print(":");
        System.out.print(minute);
        System.out.print(":");
        System.out.print(second);
        System.out.println(".");
        System.out.print("Number of seconds since midnight: ");
        System.out.println(((hour * 60 + minute) * 60)+second);
        System.out.print("Number of seconds remaining in the day: ");
        System.out.println((24*60*60)-((hour * 60 + minute) * 60)- second);
        
            double minutos = 42;
            double horas = 20;
            double segundos = 20;
        
        System.out.printf( "Fraction of the day that has passed = %.2f", (((horas * 60 + minutos) * 60)+ segundos)/(24*60*60)); 
            
            int minuteFin = 52;
            int hourFin = 21;
            int secondFin = 56;
        System.out.print("\nNumber of seconds since I started working on this exercise: ");
        System.out.print((((hourFin-hour)*60+(minuteFin - minute))*60+(secondFin-second)));        
}
}