package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad6 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia
					.executeQuery("select emp_no, apellido, salario from empleados where dept_no = 20");
			System.out.println("Empleados con el departamento 20");
			while (resul.next()) {
				System.out.println(resul.getString(1) + " " + resul.getString(2) + " " + resul.getDouble(3));
			}
			resul.close();

			resul = sentencia.executeQuery("select apellido, max(salario) from empleados where dept_no = 20");
			System.out.println("El empleado con mas sueldo es:");
			while (resul.next()) {
				System.out.println(resul.getString(1) + " " + resul.getDouble(2));
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
