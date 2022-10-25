package prueba;

import java.io.*;

public class LeerFichObject {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichData.txt");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(filein);
		Persona persona;
		try {
			while (true) {
				persona = (Persona) ois.readObject();
				System.out.println("Nombre: " + persona.getNombre() + " edad: " + persona.getEdad() + ", mas tres: "
						+ (persona.getEdad() + 3));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		ois.close();
		filein.close();
	}
}