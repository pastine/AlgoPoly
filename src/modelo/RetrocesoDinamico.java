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
}
