package modelo.propiedad;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public abstract class Propiedad extends Casillero {
	protected int precio;
	protected Jugador duenio;
	protected Propiedad hermano;

	public int obtenerPrecio() {
		return precio;
	}

	public Jugador obtenerDuenio() {
		return duenio;
	}
	public void comprar(Jugador jugador) {
		if(duenio!=null) throw new PropiedadConDuenioException();
		int costo = this.obtenerPrecio();
		jugador.quitarDinero(costo);
		this.duenio = jugador;
		this.actualizarEstadoCobro();
		this.hermano.actualizarEstadoCobro();

	}
	public void cambiarDuenio(Jugador jugador){
		this.duenio = jugador;
		this.actualizarEstadoCobro();
		this.hermano.actualizarEstadoCobro();
	}

	public void asigarHermano(Propiedad hermano) {
		this.hermano = hermano;
	}

	protected abstract void cobrar(Jugador jugador, int pasosTotal);
	public abstract void actualizarEstadoCobro();
	public abstract int obtenerValorTotal();
}
