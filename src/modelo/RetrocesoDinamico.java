package modelo;

public class RetrocesoDinamico {

	public void retroceder(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		casillero.quitarJugador(unJugador);
		if (numeroObtenido>=7 && numeroObtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			casillero.retroceder(saldo%numeroObtenido).agregarJugador(unJugador);
		}
		if (numeroObtenido>=11 && numeroObtenido<=12) {
			casillero.retroceder(numeroObtenido-2).agregarJugador(unJugador);
		}
		if (numeroObtenido>=2 && numeroObtenido<=6) {
			int numeroCasilleros = numeroObtenido - unJugador.obtenerCantidadDePropiedades();
			if (numeroCasilleros<0) {
				numeroCasilleros = 0;
			}
			casillero.retroceder(numeroCasilleros).agregarJugador(unJugador);
		}
	}
	
}
