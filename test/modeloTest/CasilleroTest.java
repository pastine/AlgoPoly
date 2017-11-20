package modeloTest;

import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.jugador.Jugador;

public class CasilleroTest {

	@Test
	public void testAgregarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		casillero.agregarJugador(jugador, 0);
		Assert.assertTrue(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	@Test 
	public void testQuitarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		casillero.agregarJugador(jugador,0);
		casillero.quitarJugador(jugador);
		Assert.assertFalse(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	
}
