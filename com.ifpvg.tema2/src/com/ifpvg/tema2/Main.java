package com.ifpvg.tema2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
	final static String BDpersona = "DBpersonas.yap";

	public static void main(String[] args) {
		// Escribir
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDpersona);
		Persona p1 = new Persona("Juan", "Alberto");
		Persona p2 = new Persona("Ana", "Madrid");
		Persona p3 = new Persona("Luis", "Granada");
		Persona p4 = new Persona("Pedro", "Asturias");

		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);

		// Leer
		Persona per = new Persona(null, null);
		// es lo mismo que select * from Persona
		// Tratar a los null como *

		ObjectSet<Persona> result = db.queryByExample(per);

		if (result.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			System.out.printf("Numero de reguistros: %d\n", result.size());
		}
		while (result.hasNext()) {
			Persona p = (Persona) result.next();
			System.out.printf("Nombre: %s, Ciudad: %s\n", p.getNombre(), p.getCiudad());
		}

		// Modificar
		ObjectSet<Persona> resulta = db.queryByExample(new Persona("Juan", null));
		if (resulta.size() == 0) {
			System.out.println("No existe Juan...");
		} else {
			Persona existe = resulta.next();
			existe.setCiudad("Toledo");
			db.store(existe);
			System.out.printf("Nombre: %s, Ciudad: %s\n", existe.getNombre(), existe.getCiudad());
		}
		// Eliminar
		ObjectSet<Persona> resulta1 = db.queryByExample(new Persona("Pedro", null));
		if (resulta1.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			System.out.printf("Numero de registros a borrar: %d\n", resulta1.size());
		}
		while (resulta1.hasNext()) {
			Persona existe = (Persona) resulta1.next();
			db.delete(existe);
		}
		// Leer luego de borrar a los pedros
		System.out.println("Adios Pedros");
		per = new Persona(null, null);

		ObjectSet<Persona> resulta2 = db.queryByExample(per);

		if (resulta2.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			System.out.printf("Numero de reguistros: %d\n", resulta2.size());
		}
		while (resulta2.hasNext()) {
			Persona p = (Persona) resulta2.next();
			System.out.printf("Nombre: %s, Ciudad: %s\n", p.getNombre(), p.getCiudad());
		}
		db.close();
	}
}
