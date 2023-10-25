public class Time {

    public static void main(String[] args) {
int hour = 20;
int minute = 42 ;
int second = 20;
System.out.print ("The current time is ");
System.out.print (hour);
System.out.print (":");
System.out.print (minute);
System.out.print (":");
System.out.print (second);
System.out.println (".");
System.out.print("Number of minutes since midnight: ");
System.out.println(((24*60*60)-(hour*60))+(minute*60));
    double minutos = 42;
System.out.print("Fraction of the hour that has passed: ");
System.out.println(minutos / 60);
    }
}

