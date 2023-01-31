package com.ifpvg.tema4;

import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.ifpvg.tema4.clases.Pais;

public class EjemploNeodatis {

	public static void main(String[] args) {
		Pais p1 = new Pais(34, "España");
		Pais p2 = new Pais(33, "Francia");
		
		
		Jugador j1 = new Jugador("Maria", "voleibol", "Madrid", 14, p2);
		Jugador j2 = new Jugador("Miguel", "tenis", "Madrid", 15, p1);
		Jugador j3 = new Jugador("Mario", "baloncesto", "Guadalajara", 15, p2);
		Jugador j4 = new Jugador("Alicia", "tenis", "Madrid", 14, p1);

		ODB odb = ODBFactory.open("neodatis.test");

		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);

		Objects<Jugador> objects = odb.getObjects(Jugador.class);
		int i = 1;
		System.out.println(objects.size());
		while (objects.hasNext()) {
			Jugador jug = (Jugador) objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrePais());

		}
		odb.close();
	}

}

class Jugador {
	private String nombre;
	private String deporte;
	private String ciudad;
	private int edad;
	private Pais pais;

	public Jugador(String nombre, String deporte, String ciudad, int edad, Pais pais) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
		this.ciudad = ciudad;
		this.edad = edad;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}
