package modelo;

import modelo.jugador.Jugador;

public class Servicio extends Propiedad{
	private int costoServicioParcial;
	private int costoServicioTotal;
	
	public Servicio(int precio, int costoServicioParcial, int costoServicioTotal) {
		super.precio = precio;
		super.duenio = null;
		this.costoServicioParcial = costoServicioParcial;
		this.costoServicioTotal = costoServicioTotal;
	}
	
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrar(jugador, pasosTotal);
	}
	
	protected void cobrar(Jugador jugador, int pasosTotal) {
		int costoServicio;
		if (duenio.esDuenioDePropiedad(hermano))
			costoServicio = pasosTotal * costoServicioTotal;
		else
			costoServicio = pasosTotal * costoServicioParcial;
		jugador.quitarDinero(costoServicio);
		duenio.recibirDinero(costoServicio);
	}
}
