package com.ifpvg.tema2;

import java.sql.*;

public class Actividad12 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
		int dep = Integer.parseInt(args[0]);

		String sql = "{? = call departamento(?)}";

		CallableStatement llamada = conexion.prepareCall(sql);

		llamada.registerOutParameter(1, Types.VARCHAR);
		llamada.setInt(2, dep);
		
		llamada.executeUpdate();
		String n = llamada.getString(1);
		System.out.println ("Departamento: "+n);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
