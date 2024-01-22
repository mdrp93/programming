package ficheros;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class EjemploFichero01 {
public static void main(String[] args) {
try {
BufferedWriter bw = new BufferedWriter(new FileWriter("fruta.txt"));
BufferedWriter a = new BufferedWriter(new FileWriter("fruta02.txt"));
bw.write("naranja\n");
bw.write("mango\n");
bw.write("chirimoya\n");
bw.write("limón\n");
bw.write("tomate\n");
bw.close();
a.write("fresa\n");
a.write("kiwi\n");
a.write("papaya\n");
a.write("plátano\n");
a.write("piña\n");
a.close();
} catch (IOException ioe) {
System.out.println("No se ha podido escribir en el fichero");
}
}
}