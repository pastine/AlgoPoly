package modelo;

import modelo.jugador.Jugador;

public class Terreno extends Propiedad{
	private int alquiler;

	public Terreno(int unPrecio, int alquiler) {
		super.precio = unPrecio;
		super.duenio = null;
		this.alquiler = alquiler;
	}

	public void accionar(Jugador jugador, int pasosTotal){
		cobrarAlquiler(jugador);
	}

	private void cobrarAlquiler(Jugador visitante){
		if (duenio != null) {
			duenio.recibirDinero(alquiler);
			visitante.quitarDinero(alquiler);
		}
	}
}
