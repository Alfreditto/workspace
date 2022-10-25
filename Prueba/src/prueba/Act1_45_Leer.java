package prueba;
import java.io.*;

public class Act1_45_Leer {

	public static void main(String[] args) throws IOException {
		char departamento[]= new char[15];
		char localidad[]= new char[18];
		File fichero = new File("Departamentos.dat");
		int idDept= 0;
		
		RandomAccessFile file= new RandomAccessFile(fichero, "r");
		
		System.out.println("Tama�o total: " + fichero.length());
		//long posicion = (idDept-1)*70;
		
		while(file.getFilePointer() < file.length()) {
			
			//file.seek(posicion);
			idDept= file.readInt();
			
			for(int i=0; i<departamento.length; i++) {
				departamento[i]= file.readChar();
			}
			
			String departamentos = new String(departamento);
			
			for(int i=0; i<localidad.length; i++) {
				localidad[i]= file.readChar();
			}
			
			String localidades= new String(localidad);
			
			System.out.println("-> Numero departamento: " + idDept + ", nombre: "+ departamentos + ", localidad: " + localidades);
			//posicion= posicion +70;
		}
		
		file.close();

	}

}
