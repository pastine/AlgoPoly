package modelo.propiedad;

import modelo.jugador.Jugador;
import modelo.propiedad.estados.EstadoCobroTerreno;

import java.util.ArrayList;

public class Terreno extends Propiedad{
	protected EstadoCobroTerreno estadoCobroTerreno;
	protected ArrayList<Integer> preciosAlquiler;
	protected int numeroCasas;
	protected int precioConstruccionCasa;

	public Terreno(int unPrecio, int alquilerSinCasa, int alquilerConCasa, int costoConstruccionCasa) {
		super.precio = unPrecio;
		super.duenio = null;
		super.hermano = this;
		this.preciosAlquiler = new ArrayList<Integer>();
		this.preciosAlquiler.add(alquilerSinCasa);
		this.preciosAlquiler.add(alquilerConCasa);
		this.estadoCobroTerreno = new EstadoCobroTerreno(alquilerSinCasa);
		this.numeroCasas = 0;
		this.precioConstruccionCasa = costoConstruccionCasa;
	}

	public void accionar(Jugador jugador, int pasosTotal){
		cobrar(jugador,pasosTotal);
	}

	protected void cobrar(Jugador visitante, int pasosTotal){
		estadoCobroTerreno.cobrar(this.duenio, visitante);
	}

	public void actualizarEstadoCobro(){
		estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
	}

	public int obtenerCantidadDeConstrucciones(){
		return numeroCasas;
	}

	public void construirCasa(){
		if (!puedeConstruirCasa()) throw new ConstruccionNoPermitidaException();
		duenio.quitarDinero(precioConstruccionCasa);
		numeroCasas += 1;
		estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
	}

	public boolean puedeConstruirCasa(){
		return (numeroCasas < 1);
	}
	

	@Override
	public void cambiarDuenio(Jugador jugador) {
		this.numeroCasas = 0;
		super.cambiarDuenio(jugador);
	}
	
	public int obtenerValorTotal(){
		int valor = this.precio;
		if(this.numeroCasas>0) valor += this.precioConstruccionCasa;
		return valor;
	}
}
