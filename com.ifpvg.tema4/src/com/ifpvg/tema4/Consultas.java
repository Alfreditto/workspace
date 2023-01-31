package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consultas {

	public static void main(String[] args) {
		ICriterion criterio = Where.equal("edad", 14);
		ODB odb = ODBFactory.open("neodatis.test");
		IQuery query = new CriteriaQuery(Jugador.class, criterio);
		Objects<Jugador> objects = odb.getObjects(query);
		System.out.println("Jugadores de 14 años: " + objects.size());
		mostrarDatos(objects);
		
		//AND
		criterio = new And().add(Where.equal("ciudad", "Madrid")).add(Where.equal("edad", 15));
		query = new CriteriaQuery(Jugador.class, criterio);
		objects = odb.getObjects(query);
		System.out.println("Madrileños de 15 años: " + objects.size());
		mostrarDatos(objects);
		
		//OR
		criterio = new Or().add(Where.equal("ciudad", "Madrid")).add(Where.equal("edad", 15));
		query = new CriteriaQuery(Jugador.class, criterio);
		objects = odb.getObjects(query);
		System.out.println("Madrileños o de 15 años: " + objects.size());
		mostrarDatos(objects);
	}

	private static void mostrarDatos(Objects<Jugador> objects) {
		int i = 1;
		while (objects.hasNext()) {
			Jugador jug = (Jugador) objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrePais());

		}
	}

}
