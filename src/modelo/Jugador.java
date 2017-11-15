package modelo;

import java.util.ArrayList;

public class Jugador {
	private int saldo;
	private ArrayList<Terreno> propiedades;
	private Casillero casilleroActual;
	private EstadoDeMovimientoDelJugador estadoMovimiento;
	
	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Terreno>();
		estadoMovimiento = new EstadoLibre();
	}
	public void ponerEnCasillero(Casillero casillero) {
		this.casilleroActual = casillero;
		this.casilleroActual.agregarJugador(this);
	}
	
	public void avanzar(int pasosTotal) {
		estadoMovimiento.avanzar(this,	casilleroActual, pasosTotal);
	}
	
	public void retroceder(int pasosTotal) {
		estadoMovimiento.retroceder(this,	casilleroActual, pasosTotal);
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
	}
	
	public boolean esDuenioDeTerreno(Terreno terreno) {
		return propiedades.contains(terreno);
	}
	
	public boolean pagarFianza(Carcel carcel) {
		return carcel.cobrarFianza(this);
	}

	public void cambiarEstadoAPreso(){
		this.estadoMovimiento = new EstadoPreso();
	}

	public void cambiarEstadoALibre(){
		this.estadoMovimiento = new EstadoLibre();
	}
}
