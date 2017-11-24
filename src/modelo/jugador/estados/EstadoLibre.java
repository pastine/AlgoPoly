package modelo.jugador.estados;

import modelo.jugador.Jugador;
import modelo.casillero.Casillero;
import modelo.*;
import modelo.Tablero;

public class EstadoLibre implements EstadoDeMovimientoDelJugador {
	
	private EstadoDireccion direccion;
	
	public EstadoLibre() {
		this.direccion = new EstadoDireccionAvanzar();
	}
	
	@Override
	public void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal){
		casilleroActual.quitarJugador(unJugador);
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
			casilleroActual = direccion.obtenerCasilleroAdyacente(casilleroActual);
	    }
		casilleroActual.agregarJugador(unJugador, pasosTotal);
	}
	
	@Override
	public int mostrarDiasRestantes(){
		return 0;
	}
	
	public void cambiarDireccion() {
		this.direccion = direccion.cambiarDireccion();
	}
}
