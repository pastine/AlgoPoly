package modelo.jugador;

import modelo.Casillero;
import modelo.jugador.EstadoDeMovimientoDelJugador;

public class EstadoPreso implements EstadoDeMovimientoDelJugador{
	
	private int diasQueFaltan;
	
	public EstadoPreso(){
		diasQueFaltan = 3;
	}
	
	@Override
	public void mover(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
		diasQueFaltan-=1;
	    if (diasQueFaltan==0) unJugador.cambiarEstado(new EstadoLibre());
		throw new JugadorEstaPresoException();
	}
	
	@Override
	public int mostrarDiasRestantes(){
		return diasQueFaltan;
	}

	@Override
	public void cambiarDireccion() {
		//No es necesario implementar este caso porque es imposible que ocurra.
		// Solo se retrocede cuando se cae en casillero RetrocesoDinamico.
		
	}
}
