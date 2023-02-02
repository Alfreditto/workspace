package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class ConsultasBis {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");

		Values valores = odb.getValues(new ValuesCriteriaQuery(Jugador.class,
				new Or().add(Where.equal("pais.nombrePais", "España")).add(Where.equal("pais.nombrePais", "España"))));
	}

}
