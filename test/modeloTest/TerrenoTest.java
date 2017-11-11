package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Terreno;

public class TerrenoTest {

	@Test
	public void testCrearTerrenoNoDevuelveNULL() {
		Terreno bsAs = new Terreno();
		Assert.assertNotNull(bsAs);
	}
	
	@Test
	public void testComprarTerrenoLePertenece() {
		Terreno bsAs = new Terreno();
		Jugador jugador = new Jugador();
		jugador.comprarTerreno(bsAs);
		boolean pertenece = jugador.perteneceTerreno(bsAs);
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void testComprarTerrenoNoLePertenece() {
		Terreno bsAs = new Terreno();
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.perteneceTerreno(bsAs);
		Assert.assertFalse(pertenece);
	}
}