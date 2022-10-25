package prueba;

import java.io.*;

public class Act2_45 {
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
				System.out.printf("Se ha cambiado el siguiente registro\nDepartamento: %d, Nombre: %s, Localidad: %s",
						idDep, String.valueOf(nombre), String.valueOf(localidad));
				String nombreNuevo = new String(args[1]);
				StringBuffer nombreNuevoBuff = new StringBuffer(nombreNuevo);
				nombreNuevoBuff.setLength(15);
				String localidadNueva = new String(args[2]);
				StringBuffer localidadNuevaBuff = new StringBuffer(localidadNueva);
				localidadNuevaBuff.setLength(18);
				file.seek(posicion);
				file.writeInt(Integer.valueOf(args[0]));
				file.writeChars(nombreNuevoBuff.toString());
				file.writeChars(localidadNuevaBuff.toString());

			}
		}
	}
}
