package com.ifpvg.tema2;

import java.sql.*;

public class Reto {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.209.49;database=ASI2", "dam201",
					"popeye");
			String dni = "5980787M";
			int edad = 19;
			String nombre = "Alfredo";
			String apellido = "Lajara";
			String sql = "insert into estrellaDAM values ('" + dni + "'," + edad + ",'" + nombre + "','" + apellido
					+ "');";
			Statement sentencia = conexion.createStatement();
			sentencia.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
