package modelo.jugador.estados;

import modelo.Tablero;
import modelo.casillero.Casillero;

public class EstadoDireccionAvanzar implements EstadoDireccion{

	public Casillero obtenerCasilleroAdyacente(Casillero actual) {
		Tablero tablero = Tablero.darTablero();
		return tablero.obtenerSiguiente(actual);
	}
	
	public EstadoDireccion cambiarDireccion() {
		return new EstadoDireccionRetroceder();
	}
}
