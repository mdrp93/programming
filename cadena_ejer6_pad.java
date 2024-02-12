/**
* @author Maria drp
*/

import java.util.Scanner;

public class cadena_ejer6_pad {

    public static String padRigth(String word, int len){
        int i=0;
        String space="-"; 
         
        for (i=0; i<word.length(); i++){
            if (word.length()<len){
                word=word+space;
            }
        }
        
        if(word.length()>len||word.length()==len){
                System.out.println("\'"+word + "\' has less or equal length than "+len+"."); 
            }
        
        return word;
    }
    
    public static String padLeft(String word, int len){
         int i=0;
        String space="-"; 

        for (i=0; i<word.length(); i++){
            if (word.length()<len){
                word=space+word;
            }
        }
        
        if(word.length()>len||word.length()==len){
                System.out.println("\'"+word + "\' has less or equal length than "+len+"."); 
            }
        
        return word;
    }

     public static String padBoth(String word, int len){
         int i=0;
        String space="-"; 

        for (i=0; i<word.length(); i++){
            if (word.length()<len){
                word=space+word+space;
            }
        }
        
        if(word.length()>len||word.length()==len){
                System.out.println("\'"+word + "\' has less or equal length than "+len+"."); 
            }
        
        return word;
    }
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Write a sentence to add space: ");
        String cadena = in.nextLine();  
        System.out.print("Please enter the number of characters you want to add in the left side: ");
        int num = in.nextInt();
        
        System.out.println("Result left: '" +padLeft(cadena, num)+"'");


        /*THE OTHER FUNCTION:
        System.out.println("Result right: '" +padRigth(cadena, num)+"'");
        System.out.println("Result both: '" +padBoth(cadena, num)+"'");*/
          
    }
}
