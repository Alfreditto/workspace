package prueba;

import java.io.*;

public class Ampliacion2 {
	public static void main(String[] args) throws IOException {
		int dep[] = {20,30,10,40,100,7,58,101};
		String nombre[] = {"Direccion","Compras","Contabilidad","Ventas","N�minas","No","Tampoco","Excede"};
		String localidad[]= {"Madrid","Puertollano","Madrid","Ciudad Real","Valdepe�as","No","Tampoco","Excede"};
		File fichero = new File("Optimo.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		StringBuffer buffer1 = null;
		StringBuffer buffer2 = null;

		for (int i = 0; i < dep.length; i++) {
			if(dep[i] % 10 == 0 && dep[i] != 0 && dep[i] <= 100) {
				file.seek(((dep[i]/10) - 1) * 70);
				file.writeInt(dep[i]);

				buffer1 = new StringBuffer(nombre[i]);
				buffer1.setLength(15);
				file.writeChars(buffer1.toString());

				buffer2 = new StringBuffer(localidad[i]);
				buffer2.setLength(18);
				file.writeChars(buffer2.toString());
			} else {
				System.out.printf("El numero de departamento %d, no es valido\n", dep[i]);
			}
		}
		file.close();

	}
}
