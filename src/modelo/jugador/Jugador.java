package modelo.jugador;

import modelo.Dado;
import modelo.casillero.Carcel;
import modelo.casillero.Casillero;
import modelo.jugador.estados.EstadoDeMovimientoDelJugador;
import modelo.jugador.estados.EstadoJugadorGanoQuiniCeroVeces;
import modelo.jugador.estados.EstadoLibre;
import modelo.jugador.estados.EstadoQuiniJugador;
import modelo.jugador.excepciones.SaldoInsuficienteException;
import modelo.propiedad.Propiedad;
import modelo.propiedad.PropiedadConDuenioException;
import modelo.propiedad.Terreno;
import modelo.propiedad.TerrenoDoble;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private int saldo;
	private final ArrayList<Propiedad> propiedades;
	private Casillero casilleroActual;
	private EstadoDeMovimientoDelJugador estadoMovimiento;
	private EstadoQuiniJugador estadoQuini;

	public Jugador() {
		saldo = 100000;
		propiedades = new ArrayList<>();
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

	public	ArrayList<Propiedad> obtenerPropiedades(){
		return propiedades;
	}
	
	public int obtenerCantidadDePropiedades() {
		return propiedades.size();
	}

	
	public void recibirDinero(int dinero) {
		saldo += dinero;
	}

	public void quitarDinero(int dinero) {
		while (dinero > this.obtenerSaldo() && this.obtenerCantidadDePropiedades() > 0){
			this.venderPropiedad(obtenerPropiedades().get(0));
		}
		saldo -= dinero;
		if (saldo < 0) throw new SaldoInsuficienteException();
	}

	public void comprarPropiedad(Propiedad propiedad) {
		propiedad.comprar(this);
		propiedades.add(propiedad);
		
	}

	public boolean esDuenioDePropiedad(Propiedad propiedad) {
		return propiedades.contains(propiedad);
	}

	public boolean pagarFianza() {
		Carcel carcel = (Carcel)this.casilleroActual;
		boolean result;
		try {
			result = carcel.cobrarFianza(this);
		}catch (Exception e) {
			return false;
		}
		return result;
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
		return dado.tirarDado();
	}

	public void construirCasa(Terreno terreno){
		if (this != terreno.obtenerDuenio()) throw new PropiedadConDuenioException();
		terreno.construirCasa();
	}

	public void construirHotel(TerrenoDoble terrenoDoble){
		if (this != terrenoDoble.obtenerDuenio()) throw new PropiedadConDuenioException();
		terrenoDoble.construirHotel();
	}
	
	public String toString() {
		return this.pedirNombre();
	}

	public void intercambiarPropiedad(Jugador otroJugador, Propiedad miPropiedad, Propiedad otraPropiedad){
		otroJugador.aceptarPropiedad(miPropiedad, otraPropiedad);
		this.aceptarPropiedad(otraPropiedad, miPropiedad);
		otraPropiedad.cambiarDuenio(this);
		miPropiedad.cambiarDuenio(otroJugador);
	}

	private void aceptarPropiedad(Propiedad nuevaPropiedad, Propiedad viejaPropiedad){
		this.propiedades.add(nuevaPropiedad);
		this.propiedades.remove(viejaPropiedad);
	}


	public void venderPropiedad(Propiedad propiedad){
		int valor = propiedad.obtenerValorTotal();
		this.recibirDinero((int)(valor*0.85));
		propiedad.cambiarDuenio(null);
		this.propiedades.remove(propiedad);
	}

	public int obtenerCoordenadaHorizontal(){
		return casilleroActual.obtenerCoordenadaHorizontal();
	}

	public int obtenerCoordenadaVertical(){
		return casilleroActual.obtenerCoordenadaVertical();
	}
	public Casillero obtenerCasillero() {
		return casilleroActual;
	}
	
	public void asginarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String pedirNombre() {
		return nombre;
	}
	
}
