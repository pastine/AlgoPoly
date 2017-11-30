package modelo.propiedad;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public abstract class Propiedad extends Casillero {
	int precio;
	Jugador duenio;
	Propiedad hermano;

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

	public boolean permiteSerComprado(int saldo) {
		return (duenio == null && saldo >= precio);
	}
	
	public boolean permiteConstruir(int saldo) {
		return false;
	}
	
	public void construir() {
	}

	public String toString() {
		return this.pedirNombre();
	}
	
	public abstract String pedirSituacion();

	protected abstract void actualizarEstadoCobro();
	public abstract int obtenerValorTotal();

	public int obtenerValorDeVenta() {
		return (int)(this.obtenerValorTotal()*0.85);
	}


}
