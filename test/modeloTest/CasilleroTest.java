package modeloTest;

import modelo.CoordenadasCasillero;
import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.Casillero;
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

	@Test
	public void testUnCasilleroObtieneBienLasCoordenadasDelMismo(){
		Casillero casillero = new Casillero();
		CoordenadasCasillero coordenadas = new CoordenadasCasillero(10,20);
		casillero.asignarCoordenadas(coordenadas);

		Assert.assertEquals(casillero.obtenerCoordenadaHorizontal(),10);
		Assert.assertEquals(casillero.obtenerCoordenadaVertical(),20);

	}
	
}
