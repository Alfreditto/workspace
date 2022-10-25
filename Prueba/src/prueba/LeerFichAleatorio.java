package prueba;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {

    public static void main(String[] args) throws IOException {

        File fichero = new File("AleatorioEmple.dat"); //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion;
        Double salario;
        char[] apellido = new char[10];
        char aux;
        posicion = 0;
        for (; ; ) {
            file.seek(posicion);
            id = file.readInt();
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }
            String apellidoS = new String(apellido);
            dep = file.readInt();
            salario = file.readDouble();
            System.out.println("ID: " + id + ", Apellidos: " + apellidoS + " Deparmanto: " + dep + ", Salario: " + salario + " Puntero: " + file.getFilePointer());
            posicion = posicion + 36;
            if (file.getFilePointer() == file.length()) break;
        }
        file.close();
    }
}