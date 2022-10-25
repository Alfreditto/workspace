package com.ifpvg.tema2;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ampliacion1 {
	public static void main(String[] args) {
		ArrayList<Integer> idRepetido = new ArrayList<Integer>();
		ArrayList<Byte> idRepetidoDep = new ArrayList<Byte>();
		int cont = 0;
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "EMPLEDEP.yap");
		//borrar empleados
		ObjectSet<Empleado2> resulta1 = db.queryByExample(new Empleado2());
		if (resulta1.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			while (resulta1.hasNext()) {
				Empleado2 existe = (Empleado2) resulta1.next();
				if (!idRepetido.contains(existe.getNumero())) {
					idRepetido.add(existe.getNumero());
				} else {
					db.delete(existe);
					cont++;
				}
			}
			System.out.println("Empleados borrados: " + cont);
		}
		//borrar dep
		ObjectSet<Departamento> resulta2 = db.queryByExample(new Departamento());
		if (resulta2.size() == 0) {
			System.out.println("La base de datos no tiene personas");
		} else {
			while (resulta2.hasNext()) {
				Departamento existe = (Departamento) resulta2.next();
				if (!idRepetidoDep.contains(existe.getDpto())) {
					idRepetidoDep.add(existe.getDpto());
				} else {
					db.delete(existe);
					cont++;
				}
			}
			System.out.println("Departamentos borrados: " + cont);
		}
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
