package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad10 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			int emp_no = Integer.parseInt(args[0]);
			String apellido = args[1];
			String oficio = args[2];
			int dir = Integer.parseInt(args[3]);
			double salario = Double.parseDouble(args[4]);
			double comision = Double.parseDouble(args[5]);
			int dept_no = Integer.parseInt(args[6]);

			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia
					.executeQuery("Select dept_no from departamentos where dept_no = " + dept_no + ";");
			if (resul.getFetchSize() == 0) {
				System.out.println("No existe ese departamento");
			} else {
				resul = sentencia.executeQuery("select emp_no from empleados where emp_no = " + emp_no + ";");
				if (resul.getFetchSize() != 0) {
					System.out.println("El empleado ya existe");
				} else {
					if (salario <= 0) {
						System.out.println("Salario debe ser mayor que 0");
					} else {
						resul = sentencia.executeQuery("select dir from empleados where dir = dir;");
						if (resul.getFetchSize() != 0) {
							System.out.println("El director no exsiste");
						} else {
							String sql = "insert into empleados (emp_no, apellido, oficio, dir, salario, comision, dept_no) values ("+emp_no+", "+  apellido+", "+oficio+", "+dir+", "+", "+salario+", "+comision+", "+dept_no+");";
							System.out.println(sql);
							sentencia.executeQuery(sql);
							System.out.println("Insertado con exito");
						}
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
