package com.ifpvg.tema2;

import java.sql.*;

public class ModificarSalarioJava {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			// recuperar parametros de main
			int dep = 10; // nun. departamento
			int subida = 100; // subida

			// construir orden UPDATE

			String sql = "UPDATE empleados SET salario = salario + " + subida + " where dept_no = " + dep;

			System.out.println(sql);

			Statement sentencia = conexion.createStatement();
			
			int filas = sentencia.executeUpdate(sql);
			
			System.out.println("Filas modificadas: " + filas);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
