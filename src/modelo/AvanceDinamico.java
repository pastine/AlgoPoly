package modelo;

import modelo.jugador.Jugador;

public class AvanceDinamico {
	
	public void avanzar(Jugador unJugador, Casillero casillero, int numeroObtenido) {
		if (numeroObtenido>=1 && numeroObtenido<=6) {
			unJugador.avanzar(numeroObtenido-2);
		}
		if (numeroObtenido>=7 && numeroObtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			unJugador.avanzar(saldo%numeroObtenido);
		}
		if (numeroObtenido>=11 && numeroObtenido<=12) {
			int numeroCasilleros = numeroObtenido - unJugador.obtenerCantidadDePropiedades();
			if (numeroCasilleros<0) {
			    numeroCasilleros = 0;
            }
			unJugador.avanzar(numeroCasilleros);
		}
	}
	
}
