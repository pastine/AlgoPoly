package modelo.jugador;


public class EstadoJugadorGanoQuiniDosVeces implements EstadoQuiniJugador {

	@Override
	public void darPremioAJugador(Jugador jugador) {
		jugador.cambiarEstado(this);
		
	}

}
