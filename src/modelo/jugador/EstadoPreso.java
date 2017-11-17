package modelo.jugador;

import modelo.Casillero;
import modelo.jugador.EstadoDeMovimientoDelJugador;

public class EstadoPreso implements EstadoDeMovimientoDelJugador{
	
	private int diasQueFaltan;
	
	public EstadoPreso(){
		diasQueFaltan = 3;
	}
	
	@Override
	public EstadoDeMovimientoDelJugador mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal, boolean direccion) {
	diasQueFaltan-=1;
    if (diasQueFaltan==0) return new EstadoLibre();
	throw new JugadorEstaPresoException();
	}
}