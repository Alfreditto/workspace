package com.ifpvg.tema4.clases;

import java.io.Serializable;

public class Pais implements Serializable{
	private int id;
	private String nombrePais;
	public Pais(int id, String nombrePais) {
		super();
		this.id = id;
		this.nombrePais = nombrePais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	
}
