package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Casillero{
	private int precio;
	private Jugador duenio;
	private int costoMultiplicadorServicio;
	
	public Servicio(int precio, int costoMultiplicadorServicio) {
		this.precio = precio;
		this.duenio = null;
		this.costoMultiplicadorServicio = costoMultiplicadorServicio;
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrarServicio(jugador, pasosTotal);
	}
	
	public void cobrarServicio(Jugador jugador, int pasosTotal) {
		jugador.quitarDinero(pasosTotal * costoMultiplicadorServicio);
		duenio.recibirDinero(pasosTotal * costoMultiplicadorServicio);
	}

	public int obtenerPrecio() {
		return precio;
	}

	public Jugador obtenerDuenio() {
		return duenio;
	}

	public void cambiarDuenio(Jugador jugador){
		if (duenio != null) throw new ServicioConDuenioException();
		this.duenio = jugador;
	}
}
