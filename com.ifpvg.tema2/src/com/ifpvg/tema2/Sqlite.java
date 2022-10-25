package com.ifpvg.tema2;

import java.sql.*;

public class Sqlite {
	public static void main(String[] args) {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:d:/sqlite/ejemplo.db");
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("Select * from departamentos");
			while (resul.next()) {
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
			}
			resul.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
