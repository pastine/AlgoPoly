package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.jugador.Jugador;

public class CasilleroTest {
	
	@Test
	public void testAgregarSiguienteEnCasilleroAgregaUnSiguiente() {
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		casillero1.agregarSiguiente(casillero2);
		Casillero siguiente = casillero1.obtenerSiguiente();
		Assert.assertEquals(casillero2, siguiente);
	}
	
	@Test
	public void testAgregarAnteriorEnCasilleroAgregaUnAnterior() {
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		casillero1.agregarSiguiente(casillero2);
		Casillero anterior = casillero2.obtenerAnterior();
		Assert.assertEquals(casillero1, anterior);
	}
	
	@Test
	public void testAgregarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		jugador.ponerEnCasillero(casillero);
		Assert.assertTrue(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	@Test 
	public void testQuitarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		jugador.ponerEnCasillero(casillero);
		casillero.quitarJugador(jugador);
		Assert.assertFalse(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	
}
