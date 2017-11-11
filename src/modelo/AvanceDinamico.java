package modelo;

public class AvanceDinamico {
	
	public void avanzar(Jugador unJugador, Casillero casillero, int numero_dado) {
		casillero.quitarJugador(unJugador);
		casillero.avanzar(numero_dado).agregarJugador(unJugador);
	}

}
