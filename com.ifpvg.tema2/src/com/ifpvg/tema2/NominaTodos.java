package com.ifpvg.tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class NominaTodos {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			Statement sentencia = conexion.createStatement();

		String sql = "select apellido, salario, comision from empleados;";
		ResultSet resul = sentencia.executeQuery(sql);
		while (resul.next()) {
			double salario = resul.getDouble(2);
			double comision = resul.getDouble(3);
			sql = "{? = call nomina(?,?,?)}";

			CallableStatement llamada = conexion.prepareCall(sql);

			llamada.registerOutParameter(1, Types.NUMERIC);
			llamada.setDouble(2, salario);
			llamada.setDouble(3, comision);
			llamada.setInt(4, 20);
			
			
			llamada.executeUpdate();
			
			Double nomina = llamada.getDouble(1);

			System.out.println("Empleado: " + resul.getString(1) + ", Salario: " + salario + ", Comision: " + comision + ",Nomina: " + nomina);

		}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
