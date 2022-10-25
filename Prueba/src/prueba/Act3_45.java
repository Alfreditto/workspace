package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Act3_45 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		char nombre[] = new char[15];
		char localidad[] = new char[18];
		int idDep;
		int registro = Integer.parseInt(args[0]);
		long posicion = (registro - 1) * 70;
		if (posicion >= fichero.length()) {
			System.out.println("El departamento al que esttas intentando acceder no existe / esta fuera de rango");
		} else {
			file.seek(posicion);
			file.seek(posicion + 4);
			if (file.readChar() == 0) {
				System.out.println("El departamento esta vacio");
			} else {
				file.seek(posicion);
				idDep = file.readInt();
				for (int i = 0; i < nombre.length; i++) {
					nombre[i] = file.readChar();
				}
				for (int i = 0; i < localidad.length; i++) {
					localidad[i] = file.readChar();
				}
				System.out.printf("Se ha borrado el siguiente registro\nDepartamento: %d, Nombre: %s, Localidad: %s",
						idDep, String.valueOf(nombre), String.valueOf(localidad));
				file.seek(posicion);
				file.writeInt(0);
				/*
				 * for (int i = 0; i < nombre.length; i++) { file.writeChar(0); } for (int i =
				 * 0; i < localidad.length; i++) { file.writeChar(0); }
				 */
			}
		}
	}
}
