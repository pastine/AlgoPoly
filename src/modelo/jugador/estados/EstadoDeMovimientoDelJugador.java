package modelo.jugador.estados;

import modelo.jugador.Jugador;
import modelo.casillero.Casillero;

public interface EstadoDeMovimientoDelJugador {
	
	public abstract void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal);
		
	public abstract int mostrarDiasRestantes();
	
	public void cambiarDireccion();
}

