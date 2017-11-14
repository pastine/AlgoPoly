package modelo;

import modelo.Jugador;

import java.util.HashMap;

public class Carcel {
	private HashMap<Jugador, Integer> prisioneros;
	
	public Carcel() {
		prisioneros = new HashMap<Jugador, Integer>();
	}
	
	public void apresarJugador(Jugador unJugador) {
		prisioneros.put(unJugador, 3);
		unJugador.cambiarEstadoAPreso();
	}
	
	public boolean estaEnLaCarcel(Jugador jugador) {
		int turnosRestantes = turnosQueLeFaltan(jugador);
		return (turnosRestantes > 0);
	}
	
	public int turnosQueLeFaltan(Jugador jugador){
		return this.prisioneros.getOrDefault(jugador, 0);
	}
	
	public boolean cobrarFianza(Jugador jugador) {
		int turnosRestantes = turnosQueLeFaltan(jugador);
		if (turnosRestantes > 2 || turnosRestantes == 0)
			return false;
		jugador.quitarDinero(45000);
		prisioneros.remove(jugador);
		return true;
	}

	public void restarDiaDeCondena(){
		for (HashMap.Entry<Jugador, Integer> prisionero : prisioneros.entrySet()) {
			prisioneros.put(prisionero.getKey(), prisionero.getValue() - 1);
			if (prisionero.getValue() < 1){
				prisionero.getKey().cambiarEstadoALibre();
				prisioneros.remove(prisionero.getKey());
			}
		}
	}
}
