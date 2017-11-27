package modelo.casillero;

import java.util.ArrayList;

import modelo.CoordenadasCasillero;
import modelo.jugador.Jugador;

public class Casillero {
	private ArrayList<Jugador> jugadores;
	private CoordenadasCasillero coordenadas;
	private String nombre;
	
	public Casillero() {
		jugadores = new ArrayList<Jugador>();
		coordenadas = new CoordenadasCasillero(0, 0);
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

	public void asignarCoordenadas(CoordenadasCasillero coordenadas){
		this.coordenadas = coordenadas;
	}

	public int obtenerCoordenadaHorizontal(){
		return coordenadas.obtenerCoordenadaHorizontal();
	}

	public int obtenerCoordenadaVertical(){
		return coordenadas.obtenerCoordenadaVertical();
	}


	public boolean puedoComprar() {
		return false;
	}

	public void asignarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String pedirNombre() {
		return nombre;
	}
}
