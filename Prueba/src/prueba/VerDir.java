package prueba;

import java.io.File;

public class VerDir {

	public static void main(String[] args) {
		System.out.println("Estos son los archivos en el directorio");
		File f = new File("C:/");
		String[] archivos = f.list();
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
	}

}
