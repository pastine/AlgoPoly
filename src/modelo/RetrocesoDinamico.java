package modelo;

import modelo.jugador.Jugador;

public class RetrocesoDinamico {

	public void retroceder(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		unJugador.cambiarDireccion();
		if (numeroObtenido>=7 && numeroObtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			unJugador.mover(saldo%numeroObtenido);
		}
		if (numeroObtenido>=11 && numeroObtenido<=12) {
			unJugador.mover(numeroObtenido-2);
		}
		if (numeroObtenido>=2 && numeroObtenido<=6) {
			int numeroCasilleros = numeroObtenido - unJugador.obtenerCantidadDePropiedades();
			if (numeroCasilleros<0) {
				numeroCasilleros = 0;
			}
			unJugador.mover(numeroCasilleros);
		}
		unJugador.cambiarDireccion();
	}
	
}
