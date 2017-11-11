package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Terreno;

public class TerrenoTest {


	@Test
	public void testComprarTerrenoLePertenece() {
		Terreno bsAs = new Terreno();
		Jugador jugador = new Jugador();
		jugador.comprarTerreno(bsAs);
		boolean pertenece = jugador.esDueñoDeTerreno(bsAs);
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void testComprarTerrenoNoLePertenece() {
		Terreno bsAs = new Terreno();
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDueñoDeTerreno(bsAs);
		Assert.assertFalse(pertenece);
	}
}
