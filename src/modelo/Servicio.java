package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Propiedad{
	private int costoServicioParcial;
	private int costoServicioTotal;
	private EstadoCobroServicio estadoCobroServicio;
	
	public Servicio(int precio, int costoServicioParcial, int costoServicioTotal) {
		super.precio = precio;
		super.duenio = null;
		super.hermano = this;
		this.costoServicioParcial = costoServicioParcial;
		this.costoServicioTotal = costoServicioTotal;
		this.estadoCobroServicio = new EstadoCobroServicio(costoServicioParcial);

	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrar(jugador, pasosTotal);
	}
	
	protected void cobrar(Jugador jugador, int pasosTotal) {
		this.estadoCobroServicio.cobrar(this.duenio, jugador, pasosTotal);
	}

	public void actualizarEstadoCobro(){
		if (duenio == hermano.obtenerDuenio()){
			estadoCobroServicio = new EstadoCobroServicio(costoServicioTotal);
		} else {
			estadoCobroServicio = new EstadoCobroServicio(costoServicioParcial);
		}
	}

}
