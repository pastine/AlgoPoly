package modelo.jugador.estados;

import modelo.Casillero;

public class EstadoDireccionAvanzar implements EstadoDireccion{

	public Casillero obtenerCasilleroAdyacente(Casillero actual) {
		
		return actual.obtenerSiguiente();
	}
	
	public EstadoDireccion cambiarDireccion() {
		return new EstadoDireccionRetroceder();
	}
}
