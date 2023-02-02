package com.ifpvg.tema4;

import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Ejercicio8 {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");

		Values values = odb.getValues(new ValuesCriteriaQuery(Jugador.class,
				new And().add(Where.equal("pais.nombrePais", "España")).add(Where.equal("edad", 15))).count("nombre"));
		ObjectValues ov = values.nextValues();

		BigInteger value = (BigInteger) ov.getByAlias("nombre");
		System.out.println("Numero de jugadores españoles con 15 años: " + value);

	}

}
