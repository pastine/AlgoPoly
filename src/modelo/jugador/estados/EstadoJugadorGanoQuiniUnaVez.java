package modelo.jugador.estados;

import modelo.jugador.Jugador;

public class EstadoJugadorGanoQuiniUnaVez implements EstadoQuiniJugador {

	@Override
	public void darPremioAJugador(Jugador jugador) {
		jugador.recibirDinero(30000);
		jugador.cambiarEstado(new EstadoJugadorGanoQuiniDosVeces());
		
	}

}
