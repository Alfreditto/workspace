package com.ifpvg.tema2;

import java.sql.*;

public class InsertarDep {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			int dep = 15;
			String dnombre = "INFORMATICA";
			String loc = "MADRID";
			String sql = "";
			Statement sentencia = null;


			for (int i = 0; i < 3; i++) {
				if (i %2 == 0) {
					sql = "INSERT INTO DEPARTAMENTOS VALUES ('" + dep + "','" + dnombre + "','" + loc + "')";
				} else {
					sql = "DELETE FROM DEPARTAMENTOS WHERE dept_no = '" + dep + "'";
				}
				System.out.println(sql);
				sentencia = conexion.createStatement();
				int filas = sentencia.executeUpdate(sql);
				System.out.println("Filas acfectadas: " + filas);
				ResultSet resul = sentencia.executeQuery("Select * from departamentos");
				while (resul.next()) {
					System.out.println(
							resul.getInt("dept_no") + "" + resul.getString("dnombre") + " " + resul.getString("loc"));
				}
				System.out.println("---------------------------------------");
			}
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
