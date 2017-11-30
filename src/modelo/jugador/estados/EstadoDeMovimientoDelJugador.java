package modelo.jugador.estados;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public interface EstadoDeMovimientoDelJugador {
	
	void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal);
		
	int mostrarDiasRestantes();
	
	void cambiarDireccion();
}

