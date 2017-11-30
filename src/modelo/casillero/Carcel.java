package modelo.casillero;

import modelo.jugador.Jugador;
import modelo.jugador.excepciones.SaldoInsuficienteException;
import modelo.jugador.estados.EstadoLibre;
import modelo.jugador.estados.EstadoPreso;

public class Carcel extends Casillero{
	
	public void accionar(Jugador jugador, int pasosTotal){
		apresarJugador(jugador);
	}
	
	private void apresarJugador(Jugador unJugador) {
		unJugador.cambiarEstado(new EstadoPreso());
	}
	
	public boolean estaEnLaCarcel(Jugador jugador) {
		int turnosRestantes = turnosQueLeFaltan(jugador);
		return (turnosRestantes > 0);
	}
	
	private int turnosQueLeFaltan(Jugador jugador){
		return jugador.diasDeCarcelRestantes();
	}
	
	public boolean cobrarFianza(Jugador jugador) {
		int turnosRestantes = turnosQueLeFaltan(jugador);
		if (turnosRestantes > 2 || turnosRestantes == 0)
			return false;
		try {
			jugador.quitarDinero(45000);
			jugador.cambiarEstado(new EstadoLibre());
			return true;
		} catch (SaldoInsuficienteException e) {
			jugador.recibirDinero(45000);
			return false;
		}
	}
}
