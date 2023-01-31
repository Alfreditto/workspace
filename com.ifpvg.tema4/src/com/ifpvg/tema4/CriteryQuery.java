package com.ifpvg.tema4;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class CriteryQuery {

	public static void main(String[] args) {
	
		ODB odb = ODBFactory.open("neodatis.test");
		IQuery query = new CriteriaQuery(Jugador.class, Where.equal("deporte", "tenis"));
		query.orderByAsc("nombre,edad");
		Objects<Jugador> objects =  odb.getObjects(query);
		int i = 1;
		while (objects.hasNext()) {
			Jugador jug = (Jugador) objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrePais());
		}
	}

}
