/**
* @author Maria drp
*/

public class libro_ch04_ejer5_zoop {
    public static void zoop(String fred, int bob) {
        System.out.println(fred);
        if (bob == 5) {
            ping("not ");
        } else {
            System.out.println("!");
        }
    }
    public static void main(String[] args) {
        int bizz = 5;
        int buzz = 2;
        zoop("just for", bizz);
        clink(2 * buzz);
    }
    public static void clink(int fork) {
        System.out.print("It's ");
        zoop("breakfast ", fork);
    }
    public static void ping(String strangStrung) {
        System.out.println("any " + strangStrung + "more ");
    }
    
}

//Draw a stack diagram that shows the state of the program the second time zoop is invoked. What is the complete output?
// Zoop = fred [breakfast] bob [fork]
// fork in this moment is equal 2 * buzz , buzz is equal 2, so fork is equal 4.
//Solution zoop diagram {fred [breakfast] bob [4]}