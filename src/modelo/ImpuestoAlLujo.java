package modelo;

import modelo.jugador.Jugador;

public class ImpuestoAlLujo extends Casillero{
	public void accionar(Jugador jugador, int pasosTotal){
		cobrarImpuesto(jugador);
	}
	
	private void cobrarImpuesto(Jugador unJugador) {
		int saldo = unJugador.obtenerSaldo();
		int impuesto = (int) (saldo*0.1);
		unJugador.quitarDinero(impuesto);
	}

}
