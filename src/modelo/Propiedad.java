package modelo;

import modelo.jugador.Jugador;

public abstract class Propiedad extends Casillero{
	protected int precio;
	protected Jugador duenio;
	protected Propiedad hermano;
	
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
	
	public void asigarHermano(Propiedad hermano) {
		this.hermano = hermano;
	}
}
