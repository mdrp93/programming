
//don´t finish

    public class libro_ch06_ejer3_gauss  {
    

        public static double gauss(double x, int n) {
            double suma = 0;
            double termino = 1;
    
            for (int i = 0; i < n; i++) {
                suma += termino;
                termino *= (-1) * x * x / (i + 1);
            }
    
            return suma;
        }
    
        public static void main(String[] args) {
            double x = 2.0;
            int n = 5;
    
            double resultado = gauss(x, n);
            
            System.out.printf("Para x = 1 la solucion es %.2f\n", Math.exp(x));
            System.out.println("El resultado de la serie es: " + resultado);
        
    }}
        
    
