package prueba;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
	public GestionContenido() {
		super();
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Comienzo del XML");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Fin del documento");
	}

	@Override
	public void startElement(String uri, String nombre, String nombreC, Attributes atts) throws SAXException {
		System.out.println("\t Principio elemento: " + nombre);
	}

	@Override
	public void endElement(String uri, String nombre, String nombreC) throws SAXException {
		System.out.println("\t Fin Elemento: " + nombre);
	}

	@Override
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", "");
		System.out.println("\tCaracteres: " + car);
	}
}
