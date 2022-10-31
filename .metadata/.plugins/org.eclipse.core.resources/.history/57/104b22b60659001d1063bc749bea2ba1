package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad8Oracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"ejemplo", "pw");
			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("Informacion sobre la BBDD");
			System.out.println("-------------------------");
			System.out.println("Nombre: " + nombre);
			System.out.println("Driver: " + driver);
			System.out.println("URL: " + url);
			System.out.println("Usuario: " + usuario);

			ResultSet resul = null;
			resul = dbmd.getTables(null, "EJEMPLO", null, null);

			while (resul.next()) {
				String catalogo = resul.getString("TABLE_CAT");
				String esquema = resul.getString("TABLE_SCHEM");
				String tabla = resul.getString("TABLE_NAME");
				String tipo = resul.getString("TABLE_TYPE");
				System.out.println("-------------------------");
				System.out.println("Catalogo: " + catalogo);
				System.out.println("Esquema: " + esquema);
				System.out.println("Tabla: " + tabla);
				System.out.println("Tipo: " + tipo);
			}
			conexion.close();
			resul.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
