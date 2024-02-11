package pizzeria;

public class PedidosPizza {
    public static void main(String[] args) {
       
        Pizza p1 = new Pizza("margarita", "mediana");
        Pizza p2 = new Pizza("funghi", "familiar");
        p2.serve(); // Corregido para usar el método serve() adecuadamente
        Pizza p3 = new Pizza("cuatro quesos", "mediana");
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        p2.serve(); // Intenta servir una pizza que ya ha sido servida, debería mostrar el mensaje de que ya ha sido servida.
        
        System.out.println("pedidas: " + Pizza.getTotalOrdered());
        System.out.println("servidas: " + Pizza.getTotalServed());
    }
}



/*Para compilar con exito un paquete con las clases en diferentes archivos del main > javac Pizza.java PedidosPizza.java

despues ir a directorio anterior y ejecutar: java pizzeria.PedidosPizza
Este comando le indica a Java que ejecute el método main de la clase PedidosPizza, que se encuentra dentro del paquete pizzeria.*/
    
/*
SOLUCION QUE DEBE DAR: 

pizza margarita mediana, pedida
pizza funghi familiar, servida
pizza cuatro quesos mediana, pedida
esa pizza ya se ha servido
pedidas: 3
servidas:  1

---------------------
PS C:\programming> java pizzeria.PedidosPizza

pizza margarita mediana, ordered
pizza funghi familiar, served
pizza cuatro quesos mediana, ordered
Esa pizza ya se ha servido.
pedidas: 3
servidas: 1
*/