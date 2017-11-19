package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Propiedad{
	private int costoMultiplicadorServicio;
	
	public Servicio(int precio, int costoMultiplicadorServicio) {
		super.precio = precio;
		super.duenio = null;
		this.costoMultiplicadorServicio = costoMultiplicadorServicio;
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrarServicio(jugador, pasosTotal);
	}
	
	private void cobrarServicio(Jugador jugador, int pasosTotal) {
		jugador.quitarDinero(pasosTotal * costoMultiplicadorServicio);
		duenio.recibirDinero(pasosTotal * costoMultiplicadorServicio);
	}
}
