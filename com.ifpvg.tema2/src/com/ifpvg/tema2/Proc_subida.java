package com.ifpvg.tema2;

import java.sql.*;

public class Proc_subida {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

		//recuperar datos d emain
		String dep = args[0];
		String  subida = args[0];
		
		String sql ="call subida_sal(?,?)";
		
		CallableStatement llamada = conexion.prepareCall(sql);
		
		llamada.setInt(1, Integer.parseInt(dep));
		llamada.setFloat(2, Float.parseFloat(subida));
		llamada.executeUpdate();
		
		System.out.println("Subida realizada");
		
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		ResultSet resul = sentencia.executeQuery("Select * from empleados where dept_no = " + dep);
		
		while (resul.next()) {
			System.out.println("N� " + resul.getString("emp_no") +" Apellido: " +resul.getString("Apellido") +"Salario: "+ resul.getDouble("Salario"));
			
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
