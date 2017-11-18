package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Casillero{
	private int precio;
	
	public Servicio(int precio) {
		this.precio = precio;
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrarServicio(jugador, pasosTotal);
	}
	
	public void cobrarServicio(Jugador jugador, int pasosTotal) {
		jugador.quitarDinero(pasosTotal * 450);
	}
}
