package modelo;

public class AvanceDinamico {
	
	public void avanzar(Jugador unJugador, Casillero casillero, int numero_obtenido) {
		casillero.quitarJugador(unJugador);
		if (numero_obtenido>=1 && numero_obtenido<=6) {
			casillero.avanzar(numero_obtenido-2).agregarJugador(unJugador);
		}
		if (numero_obtenido>=7 && numero_obtenido<=10) {
			int saldo = unJugador.obtenerSaldo();
			casillero.avanzar(saldo%numero_obtenido).agregarJugador(unJugador);
		}
		
	}
	
}
