package prueba;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PruebaSax1 {
	public static void main(String[] args) {
		XMLReader procesadorXML = null;
		try {
			procesadorXML = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("alumnos.xml");
		try {
			procesadorXML.parse(fileXML);
		} catch (IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
