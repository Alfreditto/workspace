package prueba;

import java.io.*;

public class EscribirFichData {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichData.txt");
		FileOutputStream fileout = new FileOutputStream(fichero);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Julio", "Antonio",
				"María Jesús" };
		int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };
		for (int i = 0; i < nombres.length; i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
		}
		dataOS.close();
		dataOS.close();
		fileout.close();
	}
}
