package modelo.jugador.estados;

import modelo.jugador.Jugador;

public class EstadoJugadorGanoQuiniDosVeces implements EstadoQuiniJugador {

	@Override
	public void darPremioAJugador(Jugador jugador) {
		jugador.cambiarEstado(this);
		
	}

}
