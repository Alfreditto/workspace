package prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ej4_35 {
	public static void main(String[] args) throws IOException {
		File f1 = new File(args[0]);
		File f2 = new File(args[1]);
		if (!f2.exists()) {
			f2.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(f1));
		String linea;
		FileWriter fw = new FileWriter(f2);
		PrintWriter pw = new PrintWriter(fw);
		while ((linea = br.readLine()) != null) {
			pw.println(linea);
		}
		br.close();
		fw.close();
	}
}
