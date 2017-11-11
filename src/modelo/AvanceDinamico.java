package modelo;

public class AvanceDinamico {
	
	public void avanzar(Jugador unJugador, Casillero casillero, int numero_obtenido) {
		casillero.quitarJugador(unJugador);
		casillero.avanzar(numero_obtenido-2).agregarJugador(unJugador);
	}

}
