package modelo.jugador;

import java.util.ArrayList;

import modelo.*;

public class Jugador {
	private int saldo;
	private ArrayList<Terreno> propiedades;
	private ArrayList<Servicio> servicios;
	private Casillero casilleroActual;
	private EstadoDeMovimientoDelJugador estadoMovimiento;
	private EstadoQuiniJugador estadoQuini;
	private boolean direccionAvanzar;
	
	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Terreno>();
		servicios = new ArrayList<Servicio>();
		estadoMovimiento = new EstadoLibre();
		estadoQuini = new EstadoJugadorGanoQuiniCeroVeces();
		direccionAvanzar = true;
	}
	public void ponerEnCasillero(Casillero casillero) {
		this.casilleroActual = casillero;
	}
	
	public void mover(int pasosTotal) {
		estadoMovimiento.mover(this, casilleroActual, pasosTotal, direccionAvanzar);
	}
	
	public void cambiarDireccion() {
		if (direccionAvanzar)
			direccionAvanzar = false;
		else
			direccionAvanzar = true;
	}
	
	public int obtenerSaldo() {
		return saldo;
	}
	
	public int obtenerCantidadDePropiedades() {
		return propiedades.size();
	}
	
	public void recibirDinero(int dinero) {
		saldo += dinero;
	}
	
	public void quitarDinero(int dinero) {
		if(dinero > this.obtenerSaldo()){
			throw new SaldoInsuficienteException();
		}
		saldo -= dinero;
	}
	
	public void comprarTerreno(Terreno terreno) {
		propiedades.add(terreno);
		int costo = terreno.obtenerPrecio();
		this.quitarDinero(costo);
		terreno.cambiarDuenio(this);
	}

	public void comprarServicio(Servicio servicio) {
		servicios.add(servicio);
		int costo = servicio.obtenerPrecio();
		this.quitarDinero(costo);
		servicio.cambiarDuenio(this);
	}
	
	public boolean esDuenioDeTerreno(Terreno terreno) {
		return propiedades.contains(terreno);
	}

	public boolean esDuenioDeServicio(Servicio servicio) {
		return servicios.contains(servicio);
	}
	
	public boolean pagarFianza(Carcel carcel) {
		return carcel.cobrarFianza(this);
	}
	
	public int diasDeCarcelRestantes(){
		return estadoMovimiento.mostrarDiasRestantes();
	}

	public void cambiarEstado(EstadoDeMovimientoDelJugador estadoNuevo){
		this.estadoMovimiento = estadoNuevo;
	}
	
	public void cambiarEstado(EstadoQuiniJugador estadoNuevo){
		this.estadoQuini = estadoNuevo;
	}
	
	public void recibirPremioQuini(){
		this.estadoQuini.darPremioAJugador(this);
	}
	
	public int lanzarDados(){
		Dado dado = Dado.darDado();
		int resultado = dado.tirarDado();
		resultado += dado.tirarDado();
		return resultado;
	}
}
