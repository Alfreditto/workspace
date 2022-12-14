import org.hibernate.*;
import prueba.DepartamentosEntity;
import prueba.SessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
        System.out.println("Inserto una fila en la tabla Departamentos.");

        DepartamentosEntity dep = new DepartamentosEntity();


        dep.setDeptNo((byte) 121);
        dep.setDnombre("DAM2");
        dep.setLoc("Puertollano");
        session.save(dep);
        tx.commit();
        session.close();
        System.out.println (System.getProperty ("java.version"));
    }
}
