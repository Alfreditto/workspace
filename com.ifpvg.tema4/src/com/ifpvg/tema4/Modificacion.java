package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Modificacion {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("neodatis.test");
		IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombre", "Maria"));
		Objects<Jugador> objetos = odb.getObjects(query);
		
		Jugador jug = (Jugador) objetos.getFirst();
		jug.setDeporte("vóley-playa");
		odb.store(jug);
		odb.close();

	}

}
