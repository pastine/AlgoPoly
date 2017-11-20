package modelo;

import modelo.jugador.Jugador;

public class Terreno extends Propiedad{
	private int alquiler;
	private EstadoCobroTerreno estadoCobroTerreno;

	public Terreno(int unPrecio, int alquiler) {
		super.precio = unPrecio;
		super.duenio = null;
		super.hermano = this;
		this.alquiler = alquiler;
		this.estadoCobroTerreno = new EstadoCobroTerreno(alquiler);
	}

	public void accionar(Jugador jugador, int pasosTotal){
		cobrar(jugador,pasosTotal);
	}

	protected void cobrar(Jugador visitante, int pasosTotal){
		estadoCobroTerreno.cobrar(this.duenio, visitante);
	}

	public void actualizarEstadoCobro(){

	}
}
