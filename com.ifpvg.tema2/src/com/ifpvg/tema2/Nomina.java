package com.ifpvg.tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Nomina {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
		Double salario = Double.parseDouble(args[0]);
		Double comision = Double.parseDouble(args[1]);
		int irpf = Integer.parseInt(args[2]);

		String sql = "{? = call nomina(?,?,?)}";

		CallableStatement llamada = conexion.prepareCall(sql);

		llamada.registerOutParameter(1, Types.NUMERIC);
		llamada.setDouble(2, salario);
		llamada.setDouble(3, comision);
		llamada.setInt(4, irpf);
		
		llamada.executeUpdate();
		Double n = llamada.getDouble(1);
		System.out.println ("Salario calculado: "+n);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
