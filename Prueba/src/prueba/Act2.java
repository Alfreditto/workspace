package prueba;

import java.io.*;

public class Act2 {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		FileReader fr = new FileReader(file);
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
	}
}
