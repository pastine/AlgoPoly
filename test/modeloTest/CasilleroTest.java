package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;

public class CasilleroTest {

	@Test
	public void testCrearCasilleroNoDevuelevNULL() {
		Casillero casillero = new Casillero();
		Assert.assertNotNull(casillero);
	}
	
	@Test
	public void testAvanzar1CasilleroNoEsElMismoCasillero() {
		Casillero casillero = new Casillero();
		Casillero actual = casillero.avanzar(1);
		Assert.assertNotEquals(casillero, actual);
	}
	
	@Test
	public void testAvanzar1CasilleroEsElSiguienteCasillero() {
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		casillero1.agregarSiguiente(casillero2);
		Casillero actual = casillero1.avanzar(1);
		Assert.assertEquals(casillero2, actual);
	}
	
	@Test
	public void testAgregarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		casillero.agregarJugador(jugador);
		Assert.assertTrue(casillero.jugador_esta_en_casillero(jugador));
	}
	
	@Test 
	public void testQuitarJugadorDeUnCasillero() {
		Casillero casillero = new Casillero();
		Jugador jugador = new Jugador();
		casillero.agregarJugador(jugador);
		casillero.quitarJugador(jugador);
		Assert.assertFalse(casillero.jugador_esta_en_casillero(jugador));
	}
	
	
}
