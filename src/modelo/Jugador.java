package modelo;

import java.util.ArrayList;

public class Jugador {
	private int saldo;
	private ArrayList<Terreno> propiedades;
	
	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Terreno>();
	}
	
	public int verSaldo() {
		return saldo;
	}
	
	public void recibirDinero(int dinero) {
		saldo += dinero;
	}
	
	public void quitarDinero(int dinero) {
		saldo -= dinero;
	}
	
	public void comprarTerreno(Terreno terreno) {
		propiedades.add(terreno);
		int costo = terreno.obtenerCosto();
		this.quitarDinero(costo);
	}
	
	public boolean esDueñoDeTerreno(Terreno terreno) {
		return propiedades.contains(terreno);
	}
}
