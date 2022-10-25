package prueba;

import java.io.*;

public class CrearDir {
	public static void main(String[] args) {
		File d = new File("NUEVODIR");
		File f1 = new File(d, "FICHERO1.TXT");
		File f2 = new File(d, "FICHERO2.TXT");
		if (!d.mkdir())
			System.out.println("El directorio ya existe");
		try {
			if (f1.createNewFile())
				System.out.println("FICHERO1 creado correctamente...");
			else
				System.out.println("No se ha podido crear FICHERO1...");

			if (f2.createNewFile())
				System.out.println("FICHERO2 creado correctamente...");
			else
				System.out.println("No se ha podido crear FICHERO2...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		if (f1.renameTo(new File(d, "FICHERO1NUEVO")))
			System.out.println("Fichero1 renombrado...");
		else
			System.out.println("No se puede renombrar el fichero");
		try {
			File f3 = new File("NUEVODIR/FICHERO3.TXT");
			if (f3.createNewFile())
				System.out.println("Fichero3 creado correctamente...");
			else
				System.out.println("No se ha podido crear FICHERO3...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		if (f2.delete())
			System.out.println("FICHERO2 BORRADO...");
	}
}