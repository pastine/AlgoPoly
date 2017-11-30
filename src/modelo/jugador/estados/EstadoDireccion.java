package modelo.jugador.estados;

import modelo.casillero.Casillero;

public interface EstadoDireccion {
	
	Casillero obtenerCasilleroAdyacente(Casillero actual);
	
	EstadoDireccion cambiarDireccion();
}
