public class squareroot{
    final static double MIN= 0.001; 

    public static double squareRoot(double a){
        double x1 = 0;
        double x0 = a/2;
        

        while (Math.abs(x0-x1)>MIN){
            x1 = x0;
            x0= (x0 + a/x0);       
        }

        
    return x0;
        }
    
    
    public static void main (String[] args){
        double x [] = {9, 16, 25, 49, 64 };
        for (int i=0; i<5; i++){
        System.out.printf("sqrt (%.2f) is %.2f\n", x [i], squareRoot(x[i]));
        }
    }
}
