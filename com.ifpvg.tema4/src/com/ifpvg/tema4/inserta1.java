package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.ifpvg.tema4.clases.Departamentos;
import com.ifpvg.tema4.clases.Empleados;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class inserta1 {

public static void main(String[] args) {
	try {       
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String date = "1990/12/17"; 
		java.util.Date utilDate = formatter.parse(date);
		java.sql.Date fecha1 = new java.sql.Date(utilDate.getTime());
		
		date = "1990/02/20"; 
		utilDate = formatter.parse(date);
		java.sql.Date fecha2 = new java.sql.Date(utilDate.getTime());
		
		date = "2005/06/27"; 
		utilDate = formatter.parse(date);
		java.sql.Date fecha3 = new java.sql.Date(utilDate.getTime());
			 
		Departamentos d1 = new Departamentos(10,"Contabilidad","Sevilla");
		Departamentos d2 = new Departamentos(20,"Investigación","Madrid");
		Departamentos d3 = new Departamentos(30,"Ventas","Barcelona");
		Departamentos d4 = new Departamentos(40,"Producción","Bilbao");
			 
		Empleados e1 = new Empleados(7369,"Sánchez","Empleado",null,fecha1,(float) 1040,(float) 0,d2);
		e1.setDir(e1);
		Empleados e2 = new Empleados(7499,"Arroyo","Vendedor",e1,fecha2,1500,390,d3);
		Empleados e3 = new Empleados(7521,"Sala","Vendedor",e2,fecha3,1625,650,d3);
		Empleados e4 = new Empleados(7566,"Jiménez","Director",e3,fecha1,2900,(float) 0,d2);
		Empleados e5 = new Empleados(7654,"Martín","Vendedor",e4,fecha2,1600,1020,d3);
		Empleados e6 = new Empleados(7698,"Negro","Director",e5,fecha3,3005,(float) 0,d3);
		Empleados e7 = new Empleados(7782,"Cerezo","Director",e6,fecha1,2885,(float) 0,d1);
		Empleados e8 = new Empleados(7788,"Gil","Analista",e7,fecha2,3000,(float) 0,d2);
		Empleados e9 = new Empleados(7839,"Rey","Presidente",null,fecha3,4100,(float) 0,d1);
		e9.setDir(e9);
		Empleados e10 = new Empleados(7844,"Tovar","Vendedor",e9,fecha1,1350,0,d3);
		Empleados e11 = new Empleados(7876,"Alonso","Empleado",e9,fecha2,1430,0,d2);
		Empleados e12 = new Empleados(7900,"Jimeno","Empleado",e9,fecha3,1335,0,d3);
		Empleados e13 = new Empleados(7902,"Fernández","Analista",e9,fecha1,3000,0,d2);
		Empleados e14 = new Empleados(7934,"Muñoz","Empleado",e9,fecha2,1690,0,d1);
		
		
		ODB odb = ODBFactory.open("Oficina.db");
		odb.store(d1);
		odb.store(d2);
		odb.store(d3);
		odb.store(d4);
		
		odb.store(e1);
		odb.store(e2);
		odb.store(e3);
		odb.store(e4);
		odb.store(e5);
		odb.store(e6);
		odb.store(e7);
		odb.store(e8);
		odb.store(e9);
		odb.store(e10);
		odb.store(e11);
		odb.store(e12);
		odb.store(e13);
		odb.store(e14);
		
		Objects<Empleados> objects = odb.getObjects(Empleados.class);
		
		System.out.println(objects.size() + " Empleados: ");
		
		int i = 1;
		while (objects.hasNext()){
			Empleados emp = objects.next();
			System.out.println((i++) + "\t: " + emp.getEmpNo() + " * " + 
			emp.getApellido());
		}
		odb.close();
	} catch (ParseException e) {System.out.println(e.toString());       e.printStackTrace();}
}
}
