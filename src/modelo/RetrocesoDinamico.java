package modelo;

import modelo.jugador.Jugador;

public class RetrocesoDinamico extends MovimientoDinamico{
	
	public RetrocesoDinamico(){
		primerValorMin = 7;
		segundoValorMin = 11;
		tercerValorMin = 2 ;
		
		primerValorMax =10;
		segundoValorMax = 12;
		tercerValorMax= 6;
	}

	@Override
	protected void segundoCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.resultadoMenosDos(unJugador,numeroObtenido);
		unJugador.cambiarDireccion();
	}

	@Override
	protected void primerCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.restoDeDivision(unJugador, numeroObtenido);
		unJugador.cambiarDireccion();
	}

	@Override
	protected void tercerCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.resultadoPorCantidadDePropiedades(unJugador, numeroObtenido);
		unJugador.cambiarDireccion();
	}

	/*public void retroceder(Jugador unJugador, Casillero casillero, int numeroObtenido) {
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
	*/
}
