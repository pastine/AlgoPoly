package modelo.jugador.estados;

import modelo.Casillero;
import modelo.jugador.Jugador;

public interface EstadoDeMovimientoDelJugador {
	
	public abstract void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal);
		
	public abstract int mostrarDiasRestantes();
	
	public void cambiarDireccion();
}

