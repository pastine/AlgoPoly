package modelo;

import modelo.jugador.Jugador;

public class Terreno extends Casillero{
	private int precio;
	private Jugador duenio;
	private int alquiler;

	public Terreno(int unPrecio, int alquiler) {
		this.precio = unPrecio;
		this.duenio = null;
		this.alquiler = alquiler;
	}

	public void accionar(Jugador jugador, int pasosTotal){
		cobrarAlquiler(jugador);
	}
	
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

	public void cobrarAlquiler(Jugador visitante){
		if (duenio != null) {
			duenio.recibirDinero(alquiler);
			visitante.quitarDinero(alquiler);
		}
	}




}
