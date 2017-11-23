package modelo.jugador;

import modelo.Casillero;

public interface EstadoDeMovimientoDelJugador {
	
	public abstract void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal);
		
	public abstract int mostrarDiasRestantes();
	
	public void cambiarDireccion();
}

