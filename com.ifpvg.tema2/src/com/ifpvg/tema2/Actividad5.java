package com.ifpvg.tema2;

// Actividad5bis2 est� hecho con Date (obsoleto) pero SIEMPRE FUNCIONA!
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.*;

public class Actividad5 {
	final static String BDEYD = "EMPLEDEP.yap";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEYD);

		Date fecha = new Date();
		fecha.setYear(1990);
		fecha.setMonth(Calendar.DECEMBER);
		fecha.setDate(17);
		Empleado2 e1 = new Empleado2(7369, "S�NCHEZ", "EMPLEADO", 7902, fecha, 1040, (float) 0, (byte) 20);
		db.store(e1);

		Date fecha2 = new Date();
		fecha2.setYear(1990);
		fecha2.setMonth(Calendar.FEBRUARY);
		fecha2.setDate(20);
		Empleado2 e2 = new Empleado2(7499, "ARROYO", "VENDEDOR", 7698, fecha2, 1500, (float) 390, (byte) 30);
		db.store(e2);

		Date fecha3 = new Date();
		fecha3.setYear(1991);
		fecha3.setMonth(Calendar.FEBRUARY);
		fecha3.setDate(22);
		Empleado2 e3 = new Empleado2(7521, "SALA", "VENDEDOR", 7698, fecha3, 1625, (float) 650, (byte) 30);
		db.store(e3);
		//Introducir departamentos
			Departamento dep1 = new Departamento((byte)10,"CONTABILIDAD","SEVILLA");
			db.store(dep1);
			Departamento dep2 = new Departamento((byte)20,"INVESTIGACION","MADRID");
			db.store(dep2);
			Departamento dep3 = new Departamento((byte)30,"VENTAS","BARCELONA");
			db.store(dep3);
			Departamento dep4 = new Departamento((byte)40,"PRODUCCION","BILBAO");
			db.store(dep4);
		
		//leer EMPLE
		Empleado2 per = new Empleado2();

		ObjectSet<Empleado2> result = db.queryByExample(per);

		if (result.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			System.out.printf("Numero de reguistros: %d\n", result.size());
		}
		while (result.hasNext()) {
			Empleado2 p = (Empleado2) result.next();
			System.out.println(p);
		}
		//LEER DEP
		Departamento dep = new Departamento();

		ObjectSet<Departamento> resulta = db.queryByExample(dep);

		if (resulta.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			System.out.printf("Numero de reguistros: %d\n", resulta.size());
		}
		while (resulta.hasNext()) {
			Departamento d = (Departamento) resulta.next();
			System.out.println(d);
		}
		db.close();
	}
}