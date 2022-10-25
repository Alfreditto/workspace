package prueba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirFichPrint {
	public static void main(String[] args) throws IOException {
		File fichero = new File("prueba.txt");
		PrintWriter f = new PrintWriter(new FileWriter(fichero));
		for (int i = 1; i <= 10; i++) {
			f.println("filas " + i);
		}
		f.close();
	}
}
