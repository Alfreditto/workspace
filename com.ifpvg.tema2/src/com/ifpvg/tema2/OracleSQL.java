package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleSQL {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"ejemplo", "pw");
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
