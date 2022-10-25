package prueba;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Actividad5_30 {

	public static void main(String[] args) throws IOException {
		File fichero = new File("Departamentos.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		int dep, posicion = 0;
		char[] nombre = new char[15];
		char[] localidad = new char[18];
		char aux;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			for (;;) {
				file.seek(posicion);
				dep = file.readInt();
				for (int i = 0; i < nombre.length; i++) {
					aux = file.readChar();
					nombre[i] = aux;
				}
				String nombreS = new String(nombre);
				for (int i = 0; i < localidad.length; i++) {
					aux = file.readChar();
					localidad[i] = aux;
				}
				String localidadS = new String(localidad);

				if (dep > 0) {
					Element raiz = document.createElement("departamento");
					document.getDocumentElement().appendChild(raiz);
					CrearElemento("dep", Integer.toString(dep), raiz, document);
					CrearElemento("nombre", nombreS.trim(), raiz, document);
					CrearElemento("localidad", localidadS.trim(), raiz, document);
				}
				posicion += 70;
				if (file.getFilePointer() == file.length()) break;
			}
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Departamento.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		file.close();
	}
	public static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}