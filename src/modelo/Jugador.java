package modelo;

import java.util.ArrayList;

public class Jugador {
	private int saldo;
	private ArrayList<Terreno> propiedades;
	private Casillero casilleroActual;
	
	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Terreno>();
	}
	public void ponerEnCasillero(Casillero casillero) {
		this.casilleroActual = casillero;
		this.casilleroActual.agregarJugador(this);
	}
	
	public void avanzar(int pasosTotal) {
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
			casilleroActual = casilleroActual.obtenerSiguiente();
		}
		casilleroActual.agregarJugador(this);
	}
	
	public void retroceder(int pasosTotal) {
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
			casilleroActual = casilleroActual.obtenerAnterior();
		}
		casilleroActual.agregarJugador(this);
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

}
