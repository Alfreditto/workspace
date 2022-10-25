package prueba;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Act3 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		int posicion, identificador;
		identificador = Integer.valueOf(args[0]);
		posicion = (identificador - 1) * 36;
		if (posicion >= fichero.length()) {
			System.out.printf("ID: %i , no existe el empleado", identificador);
		} else {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			int dep, id;
			char aux;
			double salario;
			char[] apellido = new char[10];

			file.seek(posicion);
			id = file.readInt();

			for (int i = 0; i < apellido.length; i++) {
				aux = file.readChar();
				apellido[i] = aux;
			}
			String apellidoS = new String(apellido);
			dep = file.readInt();
			salario = file.readDouble();
			System.out.println("ID: " + id + ", Apellidos: " + apellidoS + " Deparmanto: " + dep + ", Salario: "
					+ salario + " Puntero: " + file.getFilePointer());
			file.close();
		}
	}
}
