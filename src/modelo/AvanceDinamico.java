package modelo;

public class AvanceDinamico {
	
	public void avanzar(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		casillero.quitarJugador(unJugador);
		if (numeroObtenido>=1 && numeroObtenido<=6) {
			casillero.avanzar(numeroObtenido-2).agregarJugador(unJugador);
		}
		if (numeroObtenido>=7 && numeroObtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			casillero.avanzar(saldo%numeroObtenido).agregarJugador(unJugador);
		}
		if (numeroObtenido>=11 && numeroObtenido<=12) {
			int cantidadPropiedades = unJugador.obtenerCantidadDePropiedades();
			casillero.avanzar(numeroObtenido - cantidadPropiedades).agregarJugador(unJugador);
		}
	}
	
}
