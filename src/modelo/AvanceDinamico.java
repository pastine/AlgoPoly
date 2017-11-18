package modelo;

import modelo.jugador.Jugador;

public class AvanceDinamico extends MovimientoDinamico{
	
	public AvanceDinamico(){
		primerValorMin = 2;
		segundoValorMin = 7;
		tercerValorMin = 11 ;
		
		primerValorMax = 6;
		segundoValorMax = 10;
		tercerValorMax= 12;
	}

	@Override
	protected void primerCaso(Jugador unJugador, int numeroObtenido) {
		super.resultadoMenosDos(unJugador,numeroObtenido);
	}

	@Override
	protected void segundoCaso(Jugador unJugador, int numeroObtenido) {
		super.restoDeDivision(unJugador, numeroObtenido);
	}

	@Override
	protected void tercerCaso(Jugador unJugador, int numeroObtenido) {
		super.resultadoPorCantidadDePropiedades(unJugador, numeroObtenido);
	}
}
