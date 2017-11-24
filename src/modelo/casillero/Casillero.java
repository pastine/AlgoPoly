package modelo.casillero;

import java.util.ArrayList;

import java.util.List;

import modelo.jugador.Jugador;

public class Casillero {
	private ArrayList<Jugador> jugadores;
	
	public Casillero() {
		jugadores = new ArrayList<Jugador>();
	}
	

	public void agregarJugador(Jugador unJugador, int pasosTotal) {
		jugadores.add(unJugador);
		unJugador.ponerEnCasillero(this);
		this.accionar(unJugador, pasosTotal);
	}
	
	public void quitarJugador(Jugador unJugador) {
		jugadores.remove(unJugador);
	}
	
	public boolean jugadorEstaEnCasillero(Jugador unJugador) {
		return jugadores.contains(unJugador);
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		return;
	}
	
}
