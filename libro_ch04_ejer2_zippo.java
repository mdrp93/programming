public class libro_ch04_ejer2_zippo {
    public static void main(String[] args) {
        zippo("rattle", 13); 
    }
    public static void baffle(String blimp) {
        System.out.println(blimp); //2º "rattle"
        zippo("ping", -5);
    }
    public static void zippo(String quince, int flag) {
        if (flag < 0) {
            System.out.println(quince + " zoop"); //3º "ping zoop"
        } else {
            System.out.println("ik"); //1º "ik"
            baffle(quince);
            System.out.println("boo-wa-ha-ha"); //4º "boo-wa-ha-ha"
        }
    }
    
}


//Solution:
//Write the number 1 next to the first line of code in this program that will execute.
//Write the number 2 next to the second line of code, and so on until the end of the program. If a line is executed more than once, it might end up with more than one number next to it.
//What is the value of the parameter blimp when baffle gets invoked? The value when baffle gets invoked is "rattle", and then change to "ping"
//What is the output of this program? The output in order is:  ik, rattle, ping zoop, boo-wa-ha-ha