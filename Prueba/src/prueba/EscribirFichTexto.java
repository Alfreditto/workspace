package prueba;

import java.io.*;

public class EscribirFichTexto {
	public static void main(String[] args) throws IOException {
		File fich = new File("FichTexto.txt");
		FileWriter fw = new FileWriter(fich);
		String cadena = "Eso es una prueba con FileWriter";
		char[] cad = cadena.toCharArray();
		for (int i = 0; i < cad.length; i++) {
			fw.write(cad[i]);
		}
		fw.append('*');
		fw.close();
	}
}
