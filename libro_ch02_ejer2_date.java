public class libro_ch02_ejer2_date {

    public static void main(String[] args) {
       String day = "Thursday";
       int date = 28;
       String month = "October";
       int year = 2023;
        System.out.println ("Date of the day"); 
        System.out.print ("American format: "); 
        System.out.println (day+", "+month+" "+date+"th" +", "+year);
        System.out.print ("European format: "); 
        System.out.println (day +", "+ date + "th"+" "+month+", "+year);    
    String despedida = "Have a good day!";
    System.out.print (despedida);    
}

    @Override
    public String toString() {
        return "Date []";
    }
}