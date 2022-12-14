package com.ifpvg.tema2;

import java.sql.*;

public class Actividad11 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			String sql = "select apellido, salario, oficio from empleados where dept_no = ?;";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(args[0]));
			ResultSet salida = sentencia.executeQuery();
			while (salida.next()) {
				System.out.println(salida.getString("apellido") + "\t" + salida.getDouble("salario") + "\t"
						+ salida.getString("oficio"));
			}
			sql = "SELECT * from totales where dep = ?";
			sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(args[0]));
			salida = sentencia.executeQuery();
			while (salida.next()) {
				System.out.println("Departamento: " + salida.getString("dep") + " Salario medio: "
						+ salida.getDouble("media") + " Empleados: "
						+ salida.getInt("nemp"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
