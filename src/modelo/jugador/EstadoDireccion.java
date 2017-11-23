package modelo.jugador;

import modelo.Casillero;

public interface EstadoDireccion {
	
	public Casillero obtenerCasilleroAdyacente(Casillero actual);
	
	public EstadoDireccion cambiarDireccion();
}
