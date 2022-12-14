package com.ifpvg.tema2;

import java.sql.*;

public class Ejercicio7 {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			Statement sentencia = conexion.createStatement();
			int idCliente = 103;
			ResultSet resul = sentencia.executeQuery("select nombre from clientes where id = " + idCliente + ";");
			resul.next();
				System.out.println("Ventas del cliente: " + resul.getString(1));

			
			resul = sentencia.executeQuery(
					"select c.nombre, v.idventa, p.descripcion,p.pvp, v.cantidad, (v.cantidad * p.pvp) as importe"
							+ " from clientes c join ventas v on c.id = v.idcliente join productos p on p.id = v.idproducto"
							+ " where c.id = " + idCliente + " group by c.id, v.idventa;");
			while (resul.next()) {
				System.out.println("Venta: " + resul.getInt(2));
				System.out.println("\tProducto: " + resul.getString(3) + " -- " + resul.getDouble(4));
				System.out.println("\tCantidad: " + resul.getInt(5));
				System.out.println("\tImporte: " + resul.getDouble(6));
			}
			resul = sentencia.executeQuery(
					"select count(v.idventa), sum(v.cantidad * p.pvp) from clientes c join ventas v on c.id = v.idcliente join productos p on p.id = v.idproducto where c.id = "
							+ idCliente + " group by c.id;");
			while (resul.next()) {
				System.out.println("Numero de ventas: " + resul.getInt(1));
				System.out.println("Importe total: " + resul.getDouble(2));

			}
		} catch (SQLException e) {
			System.out.println("Ha ocurrido una excepcion");
			System.out.println("Mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("C?digo de error: " + e.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
