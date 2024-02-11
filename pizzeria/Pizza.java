package pizzeria;
//ejer5_ch11_6 Atributos y métodos de clase (static)


public class Pizza {
    private String size;
    private String type;
    private boolean served;
    private static int totalOrdered;
    private static int totalServed;

    public Pizza(String type, String size){     //constructor

        this.type = type;
        this.size = size;
        this.served = false;

        totalOrdered++;
    }

    public String toString() {                                 
       String status = this.served ? "served" : "ordered";      //condición ? valor_si_verdadero : valor_si_falso; --> forma corta de escribir una estructura if-else. 
       return "pizza " + this.type + " " + this.size + ", " + status;
    } 

    public String getSize() {
        return this.size;
    }
    public String getType() {
        return this.type;
    }
    public boolean getServed() {
        return this.served;
    }
    public static int getTotalOrdered() {
        return totalOrdered;
    }

    public static int getTotalServed() {
        return totalServed;
    }

    public void serve() {
        if (!this.served) {
            this.served = true;
            totalServed++;
        } else {
            System.out.println("Esa pizza ya se ha servido.");
        }
    }

    
}
  


