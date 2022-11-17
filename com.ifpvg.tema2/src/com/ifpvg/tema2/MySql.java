package com.ifpvg.tema2;

import java.sql.*;

public class MySql {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("Select * from departamentos");
			while (resul.next()) {
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
			}
			resul.close();
			// DatabaseMetaData dbmd = conexion.getMetaData();
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println ("Ha ocurrido una excepcion");
			System.out.println ("Mensaje: " + e.getMessage());
			System.out.println ("SQL Estado: "+ e.getSQLState());
			System.out.println ("C�digo de error: " + e.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
