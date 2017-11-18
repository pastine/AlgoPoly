package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Casillero{
	private int precio;
	private int costoMultiplicadorServicio;
	
	public Servicio(int precio, int costoMultiplicadorServicio) {
		this.precio = precio;
		this.costoMultiplicadorServicio = costoMultiplicadorServicio;
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrarServicio(jugador, pasosTotal);
	}
	
	public void cobrarServicio(Jugador jugador, int pasosTotal) {
		jugador.quitarDinero(pasosTotal * costoMultiplicadorServicio);
	}
}
