package com.ifpvg.tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Actividad12bis {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
		int num_emple = Integer.parseInt(args[0]);

		String sql = "{? = call empleado(?)}";

		CallableStatement llamada = conexion.prepareCall(sql);

		llamada.registerOutParameter(1, Types.VARCHAR);
		llamada.setInt(2, num_emple);
		
		llamada.executeUpdate();
		String n = llamada.getString(1);
		System.out.println ("Empleados: "+n);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
