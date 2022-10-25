package prueba;

import java.io.*;

public class LeerDir {
	public static void main(String[] args) throws IOException {
		File fichero = new File("prueba.txt");
		FileReader fr = new FileReader(fichero);
		int i;
		while((i = fr.read()) != -1) {
			System.out.print((char)i);
		}
		fr.close();
	}

	
}
