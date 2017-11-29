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

	public boolean permiteSerComprado(int saldo) {
		return (duenio == null && saldo >= precio);
	}
	
	public boolean permiteConstruir(int saldo) {
		return false;
	}
	
	public void construir() {
		return;
	}
	public void removerConstrucciones() { return; }
	public int obtenerCantidadDeConstrucciones(){
		return 0;
	}
	public String toString() {
		return this.pedirNombre();
	}
	
	public abstract String pedirSituacion();
	protected abstract void cobrar(Jugador jugador, int pasosTotal);
	public abstract void actualizarEstadoCobro();
	public abstract int obtenerValorTotal();


}
