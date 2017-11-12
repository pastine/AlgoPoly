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
	}
	
	public void agregarAnterior(Casillero casillero) {
		this.anterior = casillero;
	}
	
	public Casillero obtenerSiguiente() {
		return siguiente;
	}
	
	public Casillero obtenerAnterior() {
		return anterior;
	}
	
	public Casillero avanzar(int pasosTotal) {
		Casillero actual = this;
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados ++) {
			actual = actual.obtenerSiguiente();
		}
		return actual;
	}
	
	public Casillero retroceder(int pasosTotal) {
		Casillero actual = this;
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados ++) {
			actual = actual.obtenerAnterior();
		}
		return actual;
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
