package prueba;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTextoBuf {
	public static void main(String[] args) throws IOException {
		File fichero = new File("prueba.txt");
		BufferedWriter f = new BufferedWriter(new FileWriter(fichero ));
		for (int i = 1; i <= 10; i++) {
			f.write("fila " + i);
			f.newLine();
		}
		f.close();
	}
}
