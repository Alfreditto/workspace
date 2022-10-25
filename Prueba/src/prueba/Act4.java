package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Act4 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		int posicion, identificador, importe;
		identificador = Integer.valueOf(args[0]);
		importe = Integer.valueOf(args[1]);
		posicion = (identificador - 1) * 36;
		if (posicion >= fichero.length()) {
			System.out.printf("ID: %i , no existe el empleado", identificador);
		} else {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
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
			System.out.println("ID: " + id + ", Apellidos: " + apellidoS + " Deparmanto: " + dep + ", Salario antiguo: "
					+ salario + " Puntero: " + file.getFilePointer());
			System.out.println("Nuevo salario: " + (salario + importe));
			file.seek(file.getFilePointer() - 8);
			file.writeDouble((salario + importe));
			file.close();
		}

	}
}
