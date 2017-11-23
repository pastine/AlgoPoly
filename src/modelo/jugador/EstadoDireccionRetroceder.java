package modelo.jugador;

import modelo.Casillero;

public class EstadoDireccionRetroceder implements EstadoDireccion{

public Casillero obtenerCasilleroAdyacente(Casillero actual) {
		
		return actual.obtenerAnterior();
	}

	public EstadoDireccion cambiarDireccion() {
		return new EstadoDireccionAvanzar();
	}
}
