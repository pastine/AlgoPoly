package modelo;

import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	public void agregarJugador(Jugador jugador){
		super.agregarJugador(jugador);
		darPremio(jugador);
	}

	private void darPremio(Jugador unJugador){
		unJugador.recibirPremioQuini();
	}



}