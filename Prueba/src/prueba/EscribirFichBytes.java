package prueba;

import java.io.*;

public class EscribirFichBytes {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichBytes.txt");
		fichero.createNewFile();
		FileOutputStream fileout = new FileOutputStream(fichero);
		FileInputStream filein = new FileInputStream(fichero);
		int i;
		for (i = 0; i < 100; i++) {
			fileout.write(i);
		}
		fileout.close();
		while((i = filein.read()) != -1) {
			System.out.println(i);
		}
		filein.close();
	}

}
