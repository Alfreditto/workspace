package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Consultas3 {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");

		Values values = odb.getValues(
				new ValuesCriteriaQuery(Jugador.class).field("nombre").field("edad").field("pais.nombrePais"));
		while (values.hasNext()) {
			ObjectValues objetos = (ObjectValues) values.next();
			System.out.println("Nombre: " + objetos.getByAlias("nombre") + " - Edad: " + objetos.getByIndex(1)
					+ " - Pais: " + objetos.getByIndex(2));

		}
		System.out.println("\nNombre y ciudad de deportistas Españoles:");
		Values values2 = odb.getValues(new ValuesCriteriaQuery(Jugador.class, Where.equal("pais.nombrePais", "España"))
				.field("nombre").field("ciudad"));
		while (values2.hasNext()) {
			ObjectValues objetos = (ObjectValues) values2.next();
			System.out.println("Nombre: " + objetos.getByAlias("nombre") + " - Ciudad: " + objetos.getByIndex(1));

		}
		System.out.println("\nNombre y ciudad de deportistas españoles con 14 años");
		Values values3 = odb.getValues(new ValuesCriteriaQuery(Jugador.class,
				new And().add(Where.equal("pais.nombrePais", "España")).add(Where.equal("edad", 14))).field("nombre")
				.field("ciudad"));
		while (values3.hasNext()) {
			ObjectValues objetos = (ObjectValues) values3.next();
			System.out.println("Nombre: " + objetos.getByAlias("nombre") + " - Ciudad: " + objetos.getByIndex(1));

		}

		odb.close();
	}

}
