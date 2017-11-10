package modelo;

import modelo.Jugador;

import java.util.HashMap;

public class Carcel {
	private HashMap<Jugador, Integer> prisioneros;
	
	public Carcel() {
		prisioneros = new HashMap<Jugador, Integer>();
	}
	
	public void apresarJugador(Jugador unJugador) {
		prisioneros.put(unJugador, 1);
	}
	
	public boolean estaEnLaCarcel(Jugador jugador) {
		int esta = this.prisioneros.getOrDefault(jugador,0);
		return (esta > 0);
	}
}
