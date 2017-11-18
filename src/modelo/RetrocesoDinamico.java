package modelo;

import modelo.jugador.Jugador;

public class RetrocesoDinamico extends MovimientoDinamico{
	
	public RetrocesoDinamico(){
		primerValorMin = 2;
		segundoValorMin = 7;
		tercerValorMin = 11 ;
		
		primerValorMax = 6;
		segundoValorMax = 10;
		tercerValorMax= 12;
	}
	
	@Override
	protected void primerCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.resultadoPorCantidadDePropiedades(unJugador, numeroObtenido);
		unJugador.cambiarDireccion();
	}

	
	@Override
	protected void segundoCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.restoDeDivision(unJugador, numeroObtenido);
		unJugador.cambiarDireccion();
	}

	@Override
	protected void tercerCaso(Jugador unJugador, int numeroObtenido) {
		unJugador.cambiarDireccion();
		super.resultadoMenosDos(unJugador,numeroObtenido);
		unJugador.cambiarDireccion();
	}
}
