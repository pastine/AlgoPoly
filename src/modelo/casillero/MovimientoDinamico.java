package modelo.casillero;

import modelo.jugador.Jugador;

public abstract class MovimientoDinamico extends Casillero {
	
	int primerValorMin;
	int segundoValorMin;
	int tercerValorMin;
	
	int primerValorMax;
	int segundoValorMax;
	int tercerValorMax;
	
	
	protected abstract void primerCaso(Jugador unJugador, int numeroObtenido);
	protected abstract void segundoCaso(Jugador unJugador, int numeroObtenido);
	protected abstract void tercerCaso(Jugador unJugador, int numeroObtenido);

	public void accionar(Jugador jugador, int pasosTotal){
		mover(jugador, pasosTotal);
	}

	private void mover(Jugador unJugador, int numeroObtenido) {
		if (numeroObtenido>=primerValorMin && numeroObtenido<=primerValorMax) {
			primerCaso(unJugador, numeroObtenido);
		}
		if (numeroObtenido>=segundoValorMin && numeroObtenido<=segundoValorMax) {
			segundoCaso(unJugador, numeroObtenido);
		}
		if (numeroObtenido>=tercerValorMin && numeroObtenido<=tercerValorMax) {
			tercerCaso(unJugador, numeroObtenido);
		}
	}
	
	void resultadoMenosDos(Jugador unJugador, int numeroObtenido){
		unJugador.mover(numeroObtenido-2);
	}
	
	void restoDeDivision(Jugador unJugador, int numeroObtenido){
		int saldo = unJugador.obtenerSaldo();
		unJugador.mover(saldo%numeroObtenido);
	}
	
	void resultadoPorCantidadDePropiedades(Jugador unJugador, int numeroObtenido){
		int numeroCasilleros = numeroObtenido - unJugador.obtenerCantidadDePropiedades();
		if (numeroCasilleros<0) {
		    numeroCasilleros = 0;
        }
		unJugador.mover(numeroCasilleros);
	}
}
