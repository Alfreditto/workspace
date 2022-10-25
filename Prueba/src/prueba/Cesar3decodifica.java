package prueba;

import java.io.*;

public class Cesar3decodifica {
    public static void main(String[] args) throws IOException {
        File f1 = new File("copiacodificado.txt");
        File f2 = new File("copiadecodificado.txt");
        if (!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        desCodificar(f1, f2);
    }

    private static void desCodificar(File f1, File f2) throws IOException {
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);
        int c;
        while ((c = fr.read()) != -1) {
            if (c != 32 && c != 10 && c != 46) {
                if (c >= 100 && c <= 122) {
                    c -= 3;
                } else if (c >= 68 && c <= 90) {
                    c -= 3;
                } else {
                    c += 23;
                }
            }
            fw.write(c);
        }
        fr.close();
        fw.close();
    }
}
