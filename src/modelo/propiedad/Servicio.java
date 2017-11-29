package modelo.propiedad;

import modelo.jugador.Jugador;
import modelo.propiedad.estados.EstadoCobroServicio;

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

	@Override
	public void accionar(Jugador jugador, int pasosTotal) {
		cobrar(jugador, pasosTotal);
	}

	public void asignarHermano(Servicio hermano) {
		this.hermano = hermano;
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
	
	public int obtenerValorTotal(){
		return this.precio;
	}
	
	public String pedirSituacion() {
		String situacion = "\nCosto Servicio: $" + precio;
		situacion += "\nPropietario: ";
		if (duenio != null)
			situacion += duenio.pedirNombre();
		situacion += "\nservicio: " + estadoCobroServicio.obtenerCostoServicio() + " x dados";
		return situacion;
	}

}
