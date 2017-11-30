package modelo.propiedad;

import modelo.jugador.Jugador;
import modelo.propiedad.estados.EstadoCobroTerreno;

import java.util.ArrayList;

public class Terreno extends Propiedad{
	EstadoCobroTerreno estadoCobroTerreno;
	final ArrayList<Integer> preciosAlquiler;
	int numeroCasas;
	final int precioConstruccionCasa;

	public Terreno(int unPrecio, int alquilerSinCasa, int alquilerConCasa, int costoConstruccionCasa) {
		super.precio = unPrecio;
		super.duenio = null;
		super.hermano = this;
		this.preciosAlquiler = new ArrayList<>();
		this.preciosAlquiler.add(alquilerSinCasa);
		this.preciosAlquiler.add(alquilerConCasa);
		this.estadoCobroTerreno = new EstadoCobroTerreno(alquilerSinCasa);
		this.numeroCasas = 0;
		this.precioConstruccionCasa = costoConstruccionCasa;
	}

	public void accionar(Jugador jugador, int pasosTotal){
		cobrar(jugador);
	}

	private void cobrar(Jugador visitante){
		estadoCobroTerreno.cobrar(this.duenio, visitante);
	}

	public void actualizarEstadoCobro(){
		estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
	}

	public int obtenerCantidadDeConstrucciones(){
		return numeroCasas;
	}
	
	public void construir() {
		construirCasa();
	}
	public void construirCasa(){
		if (!permiteConstruirCasa(duenio.obtenerSaldo())) throw new ConstruccionNoPermitidaException();
		duenio.quitarDinero(precioConstruccionCasa);
		numeroCasas += 1;
		estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
	}
	
	public boolean permiteConstruir(int saldo) {
		return permiteConstruirCasa(saldo);
	}
	public boolean permiteConstruirCasa(int saldo){
		return (numeroCasas < 1) && saldo >= precioConstruccionCasa;
	}
	void removerConstrucciones() { this.numeroCasas = 0; }

	@Override
	public void cambiarDuenio(Jugador jugador) {
		removerConstrucciones();
		super.cambiarDuenio(jugador);
	}
	
	public int obtenerValorTotal(){
		int valor = this.precio;
		if(this.numeroCasas>0) valor += this.precioConstruccionCasa;
		return valor;
	}
	
	public int obtenerCostoAlquiler() {
		return estadoCobroTerreno.obtenerCostoAlquiler();
		
	}
	public String pedirSituacion() {
		String situacion = "\nCosto Terreno: $" + precio;
		situacion += "\nPropietario: ";
		if (duenio != null)
			situacion += duenio.pedirNombre();
		situacion += "\nAlquiler: $" + this.obtenerCostoAlquiler();
		situacion += "\nConstrucciones: " + numeroCasas;
		return situacion;
	}
}
