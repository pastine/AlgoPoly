package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.Jugador;

public class CarcelTest {

	@Test
	public void testCrearCarcelNoDevuelveNULL() {
		Carcel carcel = new Carcel();
		Assert.assertNotNull(carcel);
	}
	
	@Test
	public void testJugadorApresadoIntentaAvanzarYNoPuede() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);
		Assert.assertNotNull(carcel);
	}

}
