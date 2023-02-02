package com.ifpvg.tema4;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Consultas2 {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");

		Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).sum("edad"));

		ObjectValues ov = val.nextValues();

		BigDecimal value = (BigDecimal) ov.getByAlias("edad");

		System.out.println("Suma de edad con el nombre del atributo: " + value);

		Values valdos = odb.getValues(new ValuesCriteriaQuery(Jugador.class).sum("edad"));

		ObjectValues ovdos = valdos.nextValues();

		BigDecimal valuedos = (BigDecimal) ovdos.getByIndex(0);

		System.out.println("Suma de edad con el Index: " + valuedos);

		// Count

		Values val2 = odb.getValues(new ValuesCriteriaQuery(Jugador.class).count("nombre"));

		ObjectValues ov2 = val2.nextValues();

		BigInteger value2 = (BigInteger) ov2.getByAlias("nombre");

		System.out.println("Numero de Jugadores: " + value2);

		// Esto igual va igual no
		// Values val3 = odb.getValues(new
		// ValuesCriteriaQuery(Jugador.class).avg("edad","media"));

		// ObjectValues ov3 = val3.nextValues();

		// BigInteger value3 = (BigInteger) ov3.getByAlias("media");

		// System.out.println("Edad media: " + value3);

		// como long e int son enteros, la division es entera, redondeando al entero mas
		// proximo:
		System.out.println("Edad media sin decimales: " + value.longValue() / value2.intValue());
		// prueba la edad maxyma y minima pero nbo omo viene en el libro: no funcionara a no ser
		// que primero pongais .min y luego .max, en su liugar hazlo con dos consultas diferentes para evitar errores en el futuro
		
		// select ciudad, count(nombre) from jugadores group by ciudad.
		System.out.println("\nNúmero de jugadores de la ciudad:");
		Values groupBy = odb.getValues(new ValuesCriteriaQuery(Jugador.class).field("ciudad").count("nombre").groupBy("ciudad"));
		while (groupBy.hasNext()) {
			ObjectValues objetos = (ObjectValues) groupBy.next();
			System.out.println(objetos.getByIndex(0)+ ": " + objetos.getByIndex(1));
		}
		
		
		
		
		
		
		
		
		
		odb.close();
	}

}
