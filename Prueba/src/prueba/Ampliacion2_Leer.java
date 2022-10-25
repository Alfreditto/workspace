package prueba;

import java.io.*;

public class Ampliacion2_Leer {

	public static void main(String[] args) throws IOException {
		File fichero = new File("Optimo.dat");
		char[] nombre = new char[15];
		char[] localidad = new char[18];
		int dep;
		String nombres, localidada;

		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		System.out.println("Tama�o arichivo: " + fichero.length());

		while (file.getFilePointer() < file.length()) {
			dep = file.readInt();

			for (int i = 0; i < nombre.length; i++) {
				nombre[i] = file.readChar();
			}
			nombres = new String(nombre);

			for (int i = 0; i < localidad.length; i++) {
				localidad[i] = file.readChar();
			}
			localidada = new String(localidad);

			System.out.printf("Departamento: %d, nombre: %s, localidad: %s\n", dep, nombres, localidada);
		}

		file.close();

	}

}
