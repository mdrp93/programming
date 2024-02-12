/**
* @author Maria drp
*/
import java.util.Scanner;

public class libro_ch09_ejer6 {
    
        // Encapsulated method
        public static int countParentheses(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                }
            }

            return count;
        }

        // Generalized method
        public static int countMatchingCharacters(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if (c == '(' || c=='['|| c=='{' ) {
                    count++;
                } else if (c == ')' || c==']'|| c=='}') {
                    count--;
                }
            }

            return count;
        }


        public static void printResultMultiple(String s) {
        int result = countParentheses(s);

        if (result == 0) {
            System.out.println("The string '" + s + "' has the same number of opening and closing parentheses. CORRECT.");
        } else if(result<0){
            System.out.println("The string '" + s + "' does NOT have the same number of opening and closing parentheses. MISSING: " + result);
        } else if(result>0){
            System.out.println("The string '" + s + "' does NOT have the same number of opening and closing parentheses. LEFTOVER: " + result);
        }
        }

        public static void printResultGeneralize(String s) {
        int result = countMatchingCharacters(s);

        if (result == 0) {
            System.out.println("The string '" + s + "' has the same number of opening and closing parentheses. CORRECT.");
        } else if(result<0){
            System.out.println("The string '" + s + "' does NOT have the same number of opening and closing parentheses. MISSING: " + result);
        } else if(result>0){
            System.out.println("The string '" + s + "' does NOT have the same number of opening and closing parentheses. LEFTOVER: " + result);
        }
        }

    public static void main(String[] args) {
       
        System.out.println();
        System.out.println("______________________________________________________________________________________________________________________\n");
        // Test with multiple strings
        System.out.println("   Test the multiple strings||\t((3 + 7) * 2)  ||  (3 + 7) * 2)  ||  ((3 + 7) * 2");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ __ _ _ _ _ _ _ _ _ _ \n");
        
        String s1 = "((3 + 7) * 2)";
        String s2 = "(3 + 7) * 2)";
        String s3 = "((3 + 7) * 2";

        printResultMultiple(s1);
        printResultMultiple(s2);
        printResultMultiple(s3);
        
        Scanner in = new Scanner(System.in);    
       

        System.out.println();
        System.out.println("______________________________________________________________________________________________________________________\n");
        System.out.println("Insert a fisrt string with parenthesis to check (example: {{[5 + 3] * 2}} )");
        String s4 = in.nextLine();
        System.out.println("Insert a second string with parenthesis to check (example: {{[5 + 3] * 2}} )");
        String s5 = in.nextLine();
        System.out.println("Insert a third string with parenthesis to check (example: {{[5 + 3] * 2}} )");
        String s6 = in.nextLine();
        System.out.println("   Test the generalized method||\t"+s4+"  ||  "+s5+"  ||  "+s6+"  ||  ");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ __ _ _ _ _ _ _ _ _ _ \n");
        
       
        printResultGeneralize(s4); 
        printResultGeneralize(s5); 
        printResultGeneralize(s6);
        System.out.println();
    }
}
    

