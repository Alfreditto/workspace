package com.ifpvg.tema2;

import java.sql.*;

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
			//OBTENER DATOS DE LAS COLUMNAS DE UNA TABLA
			
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS");
				
			ResultSet columnas= null;
			columnas= dbmd.getColumns(null, "ejemplo", "departamentos", null);
			while(columnas.next()) {
				String nomCol= columnas.getString("COLUMN_NAME");
				String tipCol= columnas.getString("TYPE_NAME");
				String tamCol= columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
					
				System.out.println("COLUMUNAS: " +nomCol+ ", Tipo: " +tipCol+ ", Tamaño: " +tamCol+ ", Es nula??: " +nula);
					
					
			}
			
			System.out.println();
			System.out.println();
			
			/////////////////////////////////////////////////////////////
			//OBTENER PRIMARY KEYS DE UNA TABLA
			System.out.println("Primary keys de departamentos");
			ResultSet pk= dbmd.getPrimaryKeys(null, "EJEMPLO", "DEPARTAMENTOS");
			String pkDep="", separador="";
			
			while(pk.next()) {
				pkDep= pkDep + separador + pk.getString("COLUMN_NAME");
				separador="+";
			}
			System.out.println("Clave primaria: " + pkDep);
			
			System.out.println();
			System.out.println();
			
			/////////////////////////////////////////////////////////////
			//OBTENER FOREIGN KEYS DE UNA TABLA
			
			System.out.println("Foreign keys tablas");
			
			ResultSet fk= dbmd.getExportedKeys(null, "EJEMPLO", "DEPARTAMENTOS");
			
			while(fk.next()) {
				String fk_name = fk.getString("FKCOLUMN_NAME");
				String pk_name = fk.getString("PKCOLUMN_NAME");
				String pk_tableName = fk.getString("PKTABLE_NAME");
				String fk_tableName = fk.getString("FKTABLE_NAME");
				
				System.out.println("Tabla PK: " +pk_tableName+ ", Clave Primaria: " +pk_name);
				System.out.println("Tabla FK: " +fk_tableName+ ", Clave Primaria: " +fk_name);
			}
			
			System.out.println();
			System.out.println();
			
			////////////////////////////////////////////////////
			//OBTENER PROCEDIMIENTOS DDE UNA TABLA
			System.out.println("Obtener procedimientos de una BBDD");
			
			ResultSet proc = dbmd.getProcedures(null, "ejemplo", null);
			while(proc.next()) {
				String proc_name= proc.getString("PROCEDURE_NAME");
				String proc_type= proc.getString("PROCEDURE_TYPE");
				System.out.println("Nombre procedimiento: " + proc_name+ ", Tipo: " + proc_type);
			}
			
			System.out.println();
			System.out.println();
			////////////////////////////////////////////////////////
			////// OBTENER METADATOS DE UNA TABLA 
			
			System.out.println("Obtener metadaros de una tabla");
			
			Statement sentencia= conexion.createStatement();
			ResultSet rs= sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
			ResultSetMetaData rsmd= rs.getMetaData();
			int nColumnas= rsmd.getColumnCount();
			String nula;
			System.out.println("N�mero de columnas recuperadas: " + nColumnas);
			
			for(int i=1; i<=nColumnas; i++) {
				System.out.println("Columna --> " +i+ ": ");
				System.out.println("Nombre --> " + rsmd.getColumnName(i));
				System.out.println("Tipo --> " + rsmd.getColumnType(i));
				
				if (rsmd.isNullable(i) == 0) {
					nula="NO";
				}else {
					nula="SI";
				}
				
				System.out.println("Puede ser nula --> " +nula);
				System.out.println("Maximo ancho de la columna --> " + rsmd.getColumnDisplaySize(i));
				
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
