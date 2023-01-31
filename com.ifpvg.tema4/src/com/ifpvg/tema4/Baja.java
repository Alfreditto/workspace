package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Baja {
public static void main(String[] args) {
	ODB odb = ODBFactory.open("neodatis.test");
	IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombre", "Miguel"));
	Objects<Jugador> objetos = odb.getObjects(query);
	Jugador jug = (Jugador) objetos.getFirst();
	System.out.println(objetos.size());
	odb.delete(jug);
	System.out.println(objetos.size());
	odb.close();
}
}
