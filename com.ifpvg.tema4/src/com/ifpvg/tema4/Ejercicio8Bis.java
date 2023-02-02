package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Ejercicio8Bis {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");
		Values groupBy = odb.getValues(new ValuesCriteriaQuery(Jugador.class).field("pais.nombrePais").count("nombre").groupBy("pais.nombrePais"));
		while (groupBy.hasNext()) {
			ObjectValues objetos = (ObjectValues) groupBy.next();
			System.out.println(objetos.getByIndex(0)+ ": " + objetos.getByIndex(1));
		}
	}

}
