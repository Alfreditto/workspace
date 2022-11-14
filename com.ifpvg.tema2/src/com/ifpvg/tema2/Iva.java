package com.ifpvg.tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Iva {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
		Double cantidad = Double.parseDouble(args[0]);
		int porcentaje = Integer.parseInt(args[1]);

		String sql = "{? = call iva(?,?)}";

		CallableStatement llamada = conexion.prepareCall(sql);

		llamada.registerOutParameter(1, Types.NUMERIC);
		llamada.setDouble(2, cantidad);
		llamada.setInt(3, porcentaje);
		
		llamada.executeUpdate();
		Double n = llamada.getDouble(1);
		System.out.println ("Nuevo precio: "+n);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
