package prueba;
import java.io.File;
public class Actividad1 {

	public static void main(String[] args) {
		System.out.println("Estos son los archivos en el directorio");
		String path = args[0];
		path.replaceAll("\\", File.separator);
		File f = new File(path);
		String[] archivos = f.list();
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
	}

}
