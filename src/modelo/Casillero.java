package modelo;

import java.util.ArrayList;

import java.util.List;

public class Casillero {
	private Casillero anterior;
	private Casillero siguiente;
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	
	public Casillero() {
		anterior = null;
		siguiente = null;
	}
	
	public void agregarSiguiente(Casillero casillero) {
		this.siguiente = casillero;
		casillero.agregarAnterior(this);
	}
	
	private void agregarAnterior(Casillero casillero) {
		this.anterior = casillero;
	}
	
	public Casillero obtenerSiguiente() {
		return siguiente;
	}
	
	public Casillero obtenerAnterior() {
		return anterior;
	}
	
	public void agregarJugador(Jugador unJugador) {
		jugadores.add(unJugador);
		
	}
	
	public void quitarJugador(Jugador unJugador) {
		jugadores.remove(unJugador);
	}
	
	public boolean jugadorEstaEnCasillero(Jugador unJugador) {
		return jugadores.contains(unJugador);
	}
	
}
