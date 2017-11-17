package modelo.jugador;

import java.util.ArrayList;
import modelo.Dado;
import modelo.Carcel;
import modelo.Casillero;
import modelo.Terreno;

public class Jugador {
	private int saldo;
	private ArrayList<Terreno> propiedades;
	private Casillero casilleroActual;
	private EstadoDeMovimientoDelJugador estadoMovimiento;
	private EstadoQuiniJugador estadoQuini;
	private boolean direccionAvanzar;
	
	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Terreno>();
		estadoMovimiento = new EstadoLibre();
		estadoQuini = new EstadoJugadorGanoQuiniCeroVeces();
		direccionAvanzar = true;
	}
	public void ponerEnCasillero(Casillero casillero) {
		this.casilleroActual = casillero;
		this.casilleroActual.agregarJugador(this);
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
	}
	
	public boolean esDuenioDeTerreno(Terreno terreno) {
		return propiedades.contains(terreno);
	}
	
	public boolean pagarFianza(Carcel carcel) {
		return carcel.cobrarFianza(this);
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
