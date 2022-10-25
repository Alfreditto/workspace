package prueba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Convertidor {
	public static void main(String[] args) throws IOException {
		String hojaEstilo = "empleadosPlantilla.xsl";
		String datosAlumnos = "Empleados.xml";
		File pagHTML = new File("mipaginaEmpleados.html");
		FileOutputStream os = new FileOutputStream(pagHTML);
		Source estilos = new StreamSource(hojaEstilo);
		Source datos = new StreamSource(datosAlumnos);
		Result result = new StreamResult(os);
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
			transformer.transform(datos, result);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		os.close();
	}
}
