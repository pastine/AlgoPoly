package modelo.jugador.estados;

import modelo.Tablero;
import modelo.casillero.Casillero;

public class EstadoDireccionRetroceder implements EstadoDireccion{

public Casillero obtenerCasilleroAdyacente(Casillero actual) {
		Tablero tablero = Tablero.darTablero();
		return tablero.obtenerAnterior(actual);
	}

	public EstadoDireccion cambiarDireccion() {
		return new EstadoDireccionAvanzar();
	}
}
