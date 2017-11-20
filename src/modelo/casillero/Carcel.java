package modelo.casillero;

import modelo.jugador.Jugador;
import modelo.jugador.EstadoLibre;
import modelo.jugador.EstadoPreso;
import modelo.jugador.SaldoInsuficienteException;

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
	
	public int turnosQueLeFaltan(Jugador jugador){
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
			return false;
		}
	}
}
