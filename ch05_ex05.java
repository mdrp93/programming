public class ch05_ex05 {
    
public static void main(String[] args) {
    boolean flag1 = isHoopy(202);
    boolean flag2 = isFrabjuous(202);
    System.out.println(flag1);
    System.out.println(flag2);
    if (flag1 && flag2) {
        System.out.println("ping!");
    }
    if (flag1 || flag2) {
        System.out.println("pong!");
    }
}
public static boolean isHoopy(int x) {
    boolean hoopyFlag;
    if (x % 2 == 0) {
        hoopyFlag = true;
    } else {
        hoopyFlag = false;
    }
    return hoopyFlag; //return true if  par
}
public static boolean isFrabjuous(int x) {
    boolean frabjuousFlag;
    if (x > 0) {
        frabjuousFlag = true;
    } else {
        frabjuousFlag = false;
    }
    return frabjuousFlag;
}
    
}

//SOLUTION: 
// 1º --> flag 1 [true] --> print "true"
// 2º --> flag 2 [true] --> print "true"
// 3º --> flag 1 equal flag 2 --> print "ping"
// 4º --> flag 1 [is] ó flag2 [is]--> print "pong"

