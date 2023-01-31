import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Equipos;
import primero.Jugadores;
import primero.SessionFactoryUtil;

public class InformacionEquipos {
	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Query equiposQuery = session.createQuery("FROM Equipos");
		List<Equipos> equipos = equiposQuery.list();
		System.out.println("==================================================");
		System.out.println("Numero de equipos: " + equipos.size());
		System.out.println("==================================================");
		for (Equipos equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre());
			String nombre = equipo.getNombre();
			Query jugadoresQuery = session.createQuery("FROM Jugadores WHERE Nombre_equipo = " + "'" + nombre + "'");
			List<Jugadores> jugadores = jugadoresQuery.list();
			for (Jugadores jugador : jugadores) {
				int codigoJugador = jugador.getCodigo();
				Query estadisticasQuery = session
						.createQuery("SELECT avg(puntosPorPartido) FROM Estadisticas WHERE jugador = " + codigoJugador);
				List Estadistica = estadisticasQuery.list();
				Float puntos = Estadistica.get(0) == null ? 0 : (Float.parseFloat(Estadistica.get(0).toString()));
				String puntosStr = String.format("%.2f", puntos);
				System.out.println(codigoJugador + " " + jugador.getNombre() + ": " + puntosStr);
			}
			System.out.println("==================================================");

		}

	}
}
