package com.ifpvg.tema2;

//Escrito con amor por Alfredo mu?oz Lajara
import java.sql.*;

public class Ejercicio7Ampliacion2020 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			Statement sentencia = conexion.createStatement();
			sentencia.execute("create or replace view resumen_producto as "
					+ "select productos.id, productos.descripcion, pvp, count(idventa), "
					+ "count(distinct(idcliente)) as num_clientes ,sum(cantidad) as cantidad ,sum(cantidad*pvp) as precio_total "
					+ "from ventas right join productos on ventas.idproducto = productos.id " + "group by productos.id;");
			ResultSet resul = sentencia.executeQuery("Select * from resumen_producto");
			while (resul.next()) {
				System.out.println("Producto: " + resul.getString(1) + "\n" + "Descripcion: " + resul.getString(2)
						+ "\n" + "P.V.P. " + resul.getDouble(3) + "\n" + "\t N?mero de ventas de este producto: "
						+ resul.getInt(4) + "\n" + "\t N?mero de clientes a los que se le ha vendido: "
						+ resul.getInt(5) + "\n" + "\t Unidades vendidas de este producto: " + resul.getInt(6) + "\n"
						+ "\t Unidades vendidas * P.V.P: " + resul.getDouble(7));
			}
			int pro = Integer.parseInt(args[0]);
			float iva = Float.parseFloat(args[1]);
			ResultSet infoProducto = sentencia
					.executeQuery("(select descripcion,precio_total from `resumen_producto` where id =  " +pro+ ")");
			infoProducto.next();
			String descripcion = infoProducto.getString(1);
			double precioTotal = infoProducto.getDouble(2);
			resul = sentencia.executeQuery("select iva(" + precioTotal + ", " + iva + ")");
			resul.next();
			System.out.println("Total de ventas de " + descripcion + " " + precioTotal + "\n"
					+ "Total a pagar con un iva del " + iva + "% incluido: " + resul.getDouble(1));

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
