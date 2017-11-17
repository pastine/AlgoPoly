package modelo.jugador;

import modelo.Casillero;
import modelo.jugador.EstadoDeMovimientoDelJugador;

public class EstadoPreso implements EstadoDeMovimientoDelJugador{
	
	private int diasQueFaltan;
	
	public EstadoPreso(){
		diasQueFaltan = 3;
	}
	
    @Override
    public EstadoDeMovimientoDelJugador avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        diasQueFaltan-=1;
        if (diasQueFaltan==0) return new EstadoLibre();
    	throw new JugadorEstaPresoException();
    }

    @Override
    public EstadoDeMovimientoDelJugador retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
    	diasQueFaltan-=1;
        if (diasQueFaltan==0) return new EstadoLibre();
    	throw new JugadorEstaPresoException();
    }


}
