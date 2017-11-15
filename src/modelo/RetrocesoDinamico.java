package modelo;

public class RetrocesoDinamico {

	public void retroceder(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		if (numeroObtenido>=7 && numeroObtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			unJugador.retroceder(saldo%numeroObtenido);
		}
		if (numeroObtenido>=11 && numeroObtenido<=12) {
			unJugador.retroceder(numeroObtenido-2);
		}
		if (numeroObtenido>=2 && numeroObtenido<=6) {
			int numeroCasilleros = numeroObtenido - unJugador.obtenerCantidadDePropiedades();
			if (numeroCasilleros<0) {
				numeroCasilleros = 0;
			}
			unJugador.retroceder(numeroCasilleros);
		}
	}
	
}
