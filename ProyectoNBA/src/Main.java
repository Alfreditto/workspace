import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Estadisticas;
import primero.Jugadores;
import primero.Partidos;
import primero.SessionFactoryUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx=session.beginTransaction();
		int id = Integer.parseInt(args[0]);
		Jugadores jugador = (Jugadores) session.load(Jugadores.class, id);
		System.out.println("Datos del jugador: " + id);
		System.out.println("Nombre: " + jugador.getNombre());
		System.out.println("Equipo: " + jugador.getEquipos().getNombre());
		System.out.println("Temporada\tPuntos\tAsis\tTap\tReb");
		System.out.println("==================================================");
		Set<Estadisticas> estadisticas = jugador.getEstadisticases();
		for (Estadisticas estadistica : estadisticas) {
			System.out.print(estadistica.getId().getTemporada() + "\t\t");
			System.out.print(estadistica.getPuntosPorPartido() + "\t");
			System.out.print(estadistica.getAsistenciasPorPartido() + "\t");
			System.out.print(estadistica.getTaponesPorPartido() + "\t");
			System.out.println(estadistica.getRebotesPorPartido());
		}
		System.out.println("==================================================");
		System.out.println("Num de registros: " + estadisticas.size());
		System.out.println("==================================================");
		session.close();
		System.out.println (System.getProperty ("java.version"));
	}

}
