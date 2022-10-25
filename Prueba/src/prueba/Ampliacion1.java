package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ampliacion1 {

	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		int contador = 1; //contador == idDepart
		while (((contador-1)*70) < file.length()) {
			file.seek((contador-1)*70);
			if(file.readInt() == 0) {
				if(file.readChar() == 0) {
					System.out.printf("No hay datos del departamento %d\n", contador);
				} else {
					System.out.printf("Departamento %d restaurado\n", contador);
					file.seek((contador-1)*70);
					file.writeInt(contador);
				}
			} else {
				System.out.printf("El departamento %d, no hace falta restaurarlo\n", contador);
			}
			contador++;
		}

		file.close();
	}
}

