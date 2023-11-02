
Ch04

## Exercise 3: Answer the following questions without running the program on a computer.

1 - Draw a stack diagram that shows the state of the program the first time ping is invoked.

2 - What is output by the following program? Be precise about the placement of spaces and newlines.

>public static void zoop() {
    baffle();
    System.out.print("You wugga ");
    baffle();}

>public static void main(String[] args) {
    System.out.print("No, I ");
    zoop();
    System.out.print("I ");
    baffle();
    }

>public static void baffle() {
    System.out.print("wug");
    ping();
}

>public static void ping() {
    System.out.println(".");
}

// 1: Stack diagram: ping (vacío)

// 2: 

No, I wug.

You wugga wug.

I wug.
