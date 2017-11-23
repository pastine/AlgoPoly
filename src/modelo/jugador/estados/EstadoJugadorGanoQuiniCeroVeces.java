package modelo.jugador.estados;

import modelo.jugador.Jugador;

public class EstadoJugadorGanoQuiniCeroVeces implements EstadoQuiniJugador{

	@Override
	public void darPremioAJugador(Jugador jugador) {
		jugador.recibirDinero(50000);
		jugador.cambiarEstado(new EstadoJugadorGanoQuiniUnaVez());
	}
	
}
