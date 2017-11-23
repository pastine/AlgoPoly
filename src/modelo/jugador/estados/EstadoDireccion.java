package modelo.jugador.estados;

import modelo.Casillero;

public interface EstadoDireccion {
	
	public Casillero obtenerCasilleroAdyacente(Casillero actual);
	
	public EstadoDireccion cambiarDireccion();
}
