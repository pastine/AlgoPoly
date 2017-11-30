package modelo.casillero;

import modelo.CoordenadasCasillero;
import modelo.jugador.Jugador;

import java.util.ArrayList;

public class Casillero {
	private final ArrayList<Jugador> jugadores;
	private CoordenadasCasillero coordenadas;
	private String nombre;
	
	public Casillero() {
		jugadores = new ArrayList<>();
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
	
	protected void accionar(Jugador jugador, int pasosTotal) {
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


	public boolean permiteSerComprado(int saldo) {
		return false;
	}

	public void asignarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String pedirNombre() {
		return nombre;
	}


	public String pedirSituacion() {
		return "";
	}
}
