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

import com.ifpvg.tema4.clases.Pais;

public class Actividad6Bis {

	public static void main(String[] args) {
		Pais p1 = new Pais(33,"Francia");

		Pais p2 = new Pais(34,"España");

		ODB odb = ODBFactory.open("neodatis.test");


		Jugador j1 = new Jugador("Pedro","voleibol","Madrid",14,p2);

		Jugador j2 = new Jugador("Fran","tenis","Guadalajara",14,p1);

		Jugador j3 = new Jugador("David","baloncesto","Madrid",15,p1);

		Jugador j4 = new Jugador("Santiago","tenis","Guadalajara",15,p2);

		Jugador j5 = new Jugador("Javier","tenis","Daimiel",14,p2);
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		odb.store(j5);
		

		ICriterion criterio = new And().add(Where.equal("edad", 14)).add(new Or().add(Where.equal("ciudad", "Madrid")).add(Where.equal("ciudad", "Guadalajara")));
		IQuery query = new CriteriaQuery(Jugador.class, criterio);
		Objects<Jugador> objects = odb.getObjects(query);
		System.out.println("Madrileños/Guadalajareños de 14 años: " + objects.size());
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
