package prueba;

import java.io.*;

public class EscribirFichPersona {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichData.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream oos = new ObjectOutputStream(fileout);
		String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Julio", "Antonio",
				"María Jesús" };
		int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };
		for (int i = 0; i < nombres.length; i++) {
			Persona persona = new Persona(nombres[i],edades[i]);
			oos.writeObject(persona);
		}
		oos.close();
		fileout.close();
	}
}
