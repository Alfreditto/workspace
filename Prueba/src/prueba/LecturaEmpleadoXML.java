package prueba;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaEmpleadoXML {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("Empleados.xml"));
			document.getDocumentElement().getNodeName(); //Devuelve: Empleados
			NodeList empleados = document.getElementsByTagName("empleado");
			for (int i = 0; i < empleados.getLength() -1; i++) {
				Node emple = empleados.item(i);
				Element elemento = (Element) emple;
				System.out.printf("ID: %s ", getNodo("id", elemento));
				System.out.printf("Apellido: %s ", getNodo("apellido", elemento));
				System.out.printf("Dep: %s ", getNodo("dep", elemento));
				System.out.printf("Salario: %s \n", getNodo("salario", elemento));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static String getNodo(String etiqueta, Element elemento) {
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) nodo.item(0);
		return valornodo.getNodeValue();
	}
}
