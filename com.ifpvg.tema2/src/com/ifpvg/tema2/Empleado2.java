package com.ifpvg.tema2;
// Se usa con Actividad5bis2
import java.util.*;
public class Empleado2 {
	private int numero;	
	private String apellidos;
	private String oficio;
	private int dir;
	private Date fecha;
	private float salario;
	private float comision;
	private byte dpto;
	
	// Los constructores se pueden generar con Source - Generate Constructor using Fields... 
	public Empleado2(int numero,String apellidos,String oficio,int dir,Date fecha,float salario,float comision, byte dpto){
		this.numero=numero;
		this.apellidos=apellidos;
		this.oficio=oficio;
		this.dir=dir;
		this.fecha=fecha;
		this.salario=salario;
		this.comision=comision;
		this.dpto=dpto;
	}
	public Empleado2(){
		this.numero=0;
		this.apellidos=null;
		this.oficio=null;
		this.dir=0;
		this.fecha=null;
		this.salario=0;
		this.comision=0;
		this.dpto=0;
	}
	
	// A partir de aqui se puede generar con Source - Generate Gettings and Settings:
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public byte getDpto() {
		return dpto;
	}
	public void setDpto(byte dpto) {
		this.dpto = dpto;
	}
	@Override
	public String toString() {
		return "Empleado numero=" + numero + ", apellidos=" + apellidos + ", oficio=" + oficio + ", dir=" + dir
				+ ", fecha=" + fecha + ", salario=" + salario + ", comision=" + comision + ", dpto=" + dpto;
	}
	
}
