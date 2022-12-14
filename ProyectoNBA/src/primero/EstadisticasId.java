package primero;
// Generated 14 dic 2022 13:52:47 by Hibernate Tools 6.1.3.Final

/**
 * EstadisticasId generated by hbm2java
 */
public class EstadisticasId implements java.io.Serializable {

	private int jugador;
	private String temporada;

	public EstadisticasId() {
	}

	public EstadisticasId(int jugador, String temporada) {
		this.jugador = jugador;
		this.temporada = temporada;
	}

	public int getJugador() {
		return this.jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public String getTemporada() {
		return this.temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadisticasId))
			return false;
		EstadisticasId castOther = (EstadisticasId) other;

		return (this.getJugador() == castOther.getJugador())
				&& ((this.getTemporada() == castOther.getTemporada()) || (this.getTemporada() != null
						&& castOther.getTemporada() != null && this.getTemporada().equals(castOther.getTemporada())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getJugador();
		result = 37 * result + (getTemporada() == null ? 0 : this.getTemporada().hashCode());
		return result;
	}

}
