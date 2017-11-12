package modelo;

public class RetrocesoDinamico {

	public void retroceder(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		casillero.quitarJugador(unJugador);
		casillero.retroceder(numeroObtenido-2).agregarJugador(unJugador);
	}
	
}
