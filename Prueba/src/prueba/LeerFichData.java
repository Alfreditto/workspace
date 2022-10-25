package prueba;

import java.io.*;

public class LeerFichData {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichData.txt");
		FileInputStream filein = new FileInputStream(fichero);
		DataInputStream dataIS = new DataInputStream(filein);
		String n;
		int e;
		try {
			while(true) {
				n = dataIS.readUTF();
				e = dataIS.readInt();
				System.out.println("Nombre: " + n + " edad: " + e + ", mas tres: " +  (e+3));
			}
		} catch (EOFException er){ 
			er.printStackTrace();
		}
		dataIS.close();
		filein.close();
	}
}
