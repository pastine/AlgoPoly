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
		this.actualizarEstadoCobro();
		this.hermano.actualizarEstadoCobro();
	}
	
	public void asigarHermano(Propiedad hermano) {
		this.hermano = hermano;
	}

	protected abstract void cobrar(Jugador jugador, int pasosTotal);
	public abstract void actualizarEstadoCobro();
}
