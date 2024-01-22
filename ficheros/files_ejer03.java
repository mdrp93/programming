package ficheros;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class files_ejer03 {
public static void main(String[] args) {
    if (args.length != 3) {
        System.out.println("Usage: java ej03.java input2.txt input1.txt output.txt");
        return;
    }
    try {
    BufferedReader bh0, bh1, bh_aux;
    bh0= new BufferedReader(new FileReader(args[0]));
    bh1 = new BufferedReader(new FileReader(args[1]));
    BufferedWriter bw;
    bw = new BufferedWriter(new FileWriter(args[2]));
   
    String line0 = "";
    String line1 = "";
    while (line0 != null && line1 != null) {
        line0 = bh0.readLine();
        line1 = bh1.readLine();
        if (line0 != null && line1 != null) {
            bw.write(line0 + "\n");
            bw.write(line1 + "\n");    
        }
    }
    String line_aux = "";
    line_aux = (line0 == null)? line1 : line0;
    bh_aux = (line0 == null)? bh1 : bh0;
    while (line_aux != null) {
        bw.write(line_aux + '\n');
        line_aux = bh_aux.readLine();
    }
    bh0.close();
    bh1.close();
    bw.close();
    }
    catch (IOException e) {
    System.err.println(e.getMessage());
}
}}