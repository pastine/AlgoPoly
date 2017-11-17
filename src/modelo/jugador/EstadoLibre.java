package modelo.jugador;

import modelo.Casillero;

public class EstadoLibre implements EstadoDeMovimientoDelJugador {
	
	@Override
	public EstadoDeMovimientoDelJugador mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal, boolean direccion){
		casilleroActual.quitarJugador(unJugador);
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
			if (direccion)
				casilleroActual = casilleroActual.obtenerSiguiente();
			else 
				casilleroActual = casilleroActual.obtenerAnterior();
	    }
		casilleroActual.agregarJugador(unJugador);
	    return this;
	}
}