package modelo.jugador;

import modelo.casillero.Casillero;
import modelo.Tablero;

public class EstadoLibre implements EstadoDeMovimientoDelJugador {
	
	@Override
	public void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal, boolean direccion){
		Tablero tablero = Tablero.darTablero();

		casilleroActual.quitarJugador(unJugador);
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
			if (direccion)
				casilleroActual = tablero.obtenerSiguiente(casilleroActual);
			else 
				casilleroActual = tablero.obtenerAnterior(casilleroActual);
	    }
		casilleroActual.agregarJugador(unJugador, pasosTotal);
	}
	
	@Override
	public int mostrarDiasRestantes(){
		return 0;
	}
}
