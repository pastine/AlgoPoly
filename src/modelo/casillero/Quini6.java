package modelo.casillero;

import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	public void accionar(Jugador jugador, int pasosTotal){
		darPremio(jugador);
	}

	private void darPremio(Jugador unJugador){
		unJugador.recibirPremioQuini();
	}



}