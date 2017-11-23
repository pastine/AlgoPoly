package modelo.jugador;

import java.util.ArrayList;

import modelo.Carcel;
import modelo.Casillero;
import modelo.Dado;
import modelo.propiedad.Propiedad;
import modelo.propiedad.PropiedadConDuenioException;
import modelo.propiedad.Terreno;
import modelo.propiedad.TerrenoDoble;

public class Jugador {
	private int saldo;
	private ArrayList<Propiedad> propiedades;
	private Casillero casilleroActual;
	private EstadoDeMovimientoDelJugador estadoMovimiento;
	private EstadoQuiniJugador estadoQuini;

	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<Propiedad>();
		estadoMovimiento = new EstadoLibre();
		estadoQuini = new EstadoJugadorGanoQuiniCeroVeces();
	}
	public void ponerEnCasillero(Casillero casillero) {
		this.casilleroActual = casillero;
	}

	public void mover(int pasosTotal) {
		estadoMovimiento.mover(this, casilleroActual, pasosTotal);
	}
	
	public void cambiarDireccion() {
		estadoMovimiento.cambiarDireccion();
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

	public void comprarPropiedad(Propiedad propiedad) {
		propiedad.comprar(this);
		propiedades.add(propiedad);
		
	}

	public boolean esDuenioDePropiedad(Propiedad propiedad) {
		return propiedades.contains(propiedad);
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

	public void construirCasa(Terreno terreno){
		if (this != terreno.obtenerDuenio()) throw new PropiedadConDuenioException();
		terreno.construirCasa();
	}

	public void construirHotel(TerrenoDoble terrenoDoble){
		if (this != terrenoDoble.obtenerDuenio()) throw new PropiedadConDuenioException();
		terrenoDoble.construirHotel();
	}

	public void intercambiarPropiedad(Jugador otroJugador, Propiedad miPropiedad, Propiedad otraPropiedad){
		otroJugador.aceptarPropiedad(miPropiedad, otraPropiedad);
		this.aceptarPropiedad(otraPropiedad, miPropiedad);
		otraPropiedad.cambiarDuenio(this);
		miPropiedad.cambiarDuenio(otroJugador);
	}

	public void aceptarPropiedad(Propiedad nuevaPropiedad, Propiedad viejaPropiedad){
		this.propiedades.add(nuevaPropiedad);
		this.propiedades.remove(viejaPropiedad);
	}

}
