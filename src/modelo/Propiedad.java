package modelo;

import modelo.jugador.Jugador;

public abstract class Propiedad extends Casillero{
	protected int precio;
	protected Jugador duenio;
	
	public int obtenerPrecio() {
		return precio;
	}
	
	public Jugador obtenerDuenio() {
		return duenio;
	}
	
	public void cambiarDuenio(Jugador jugador){
		if (duenio != null) throw new PropiedadConDuenioException();
		this.duenio = jugador;
	}
}
