package modelo.jugador.estados;

import modelo.casillero.Casillero;

public interface EstadoDireccion {
	
	public Casillero obtenerCasilleroAdyacente(Casillero actual);
	
	public EstadoDireccion cambiarDireccion();
}
