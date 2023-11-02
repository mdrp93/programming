

public class date2 {

public static void printAmerican(String day, String month, int date, int year) {
    System.out.println(day+","+" "+month+" "+date+" "+year);
}

public static void printEuropean(String day, String month, int date, int year) {
    System.out.println(day+","+" "+date+" "+month+" "+year);
}


public static void main(String[] args) {
       String day = "Friday";
       int date = 3;
       String month = "November";
       int year = 2023;
        System.out.println ("Date of the day"); 
        
        printAmerican(day, month, date, year);
        printEuropean(day, month, date, year);
        
           
    String despedida = "Have a good day!";
    System.out.print (despedida);    
}
}