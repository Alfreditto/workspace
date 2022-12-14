package com.ifpvg.tema2;

import java.sql.*;

public class CrearVista {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			// construir orden CREATE
			String sql = "CREATE OR REPLACE VIEW totales (dep, dnombre, nemp, media) AS "
					+ "SELECT d.dept_no, dnombre, COUNT(emp_no), AVG (salario) "
					+ "FROM departamentos d LEFT JOIN empleados e " + "ON e.dept_no = d.dept_no "
					+ "GROUP BY d.dept_no, dnombre ";
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Resultado ejecución: " + filas);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
