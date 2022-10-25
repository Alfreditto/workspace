package prueba;

import java.io.File;

public class VerInf {

	public static void main(String[] args) {
		System.out.println("INFORMACION DE EL DICHERO");
		File f = new File("./src/prueba/VerInf.java");
		System.out.println("Nombre del fichero: " + f.getName());
		System.out.println("Ruta: " + f.getPath());
		System.out.println("Ruta Absoluta: " + f.getAbsolutePath());
		System.out.println("Se puede escribir: " + f.canWrite());
		System.out.println("Se puede leer: " + f.canRead());
		System.out.println("Tamaño: " + f.length());
		System.out.println("Es un directorio: " + f.isDirectory());
		System.out.println("Es un fichero: " + f.isFile());
	}
}
