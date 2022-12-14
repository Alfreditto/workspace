import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.SessionFactoryUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Inserto una fila en la tabla Departamentos.");
		
		Departamentos dep = new Departamentos();
		
		
		dep.setDeptNo((byte) 127);
		dep.setDnombre("DAM2");
		dep.setLoc("Puertollano");
		session.save(dep);
		tx.commit();
		session.close();
		System.out.println (System.getProperty ("java.version"));
	}

}
