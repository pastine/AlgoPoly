package modelo.jugador;

import modelo.Casillero;

public interface EstadoDeMovimientoDelJugador {
	
	public abstract EstadoDeMovimientoDelJugador mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal, boolean direccion);

}

