package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServer {

	public static void main(String[] args) {
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conexion = DriverManager
					.getConnection("jdbc:sqlserver://192.168.209.121;database=ASI1", "dam201", "dam201");
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("Select * from departamentos");
			while (resul.next()) {
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
			}
			resul.close();
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
