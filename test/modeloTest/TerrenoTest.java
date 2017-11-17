package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Terreno;
import modelo.jugador.Jugador;

public class TerrenoTest {


	@Test
	public void testAlCrearTerrenoLoCreaConElPrecioCorrecto() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno);
		Assert.assertEquals(precioTerreno, bsAs.obtenerPrecio());
	}

	@Test
	public void testComprarTerrenoLePertenece() {
		Terreno bsAs = new Terreno(1000);
		Jugador jugador = new Jugador();
		jugador.comprarTerreno(bsAs);
		boolean pertenece = jugador.esDuenioDeTerreno(bsAs);
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void testComprarTerrenoNoLePertenece() {
		Terreno bsAs = new Terreno(1000);
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDuenioDeTerreno(bsAs);
		Assert.assertFalse(pertenece);
	}

	@Test
	public void testAlComprarTerrenoSeLeDescuentaElPrecioAlSaldoDelJugador() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno);
		Jugador jugador = new Jugador();
		int saldoInicial = jugador.obtenerSaldo();
		jugador.comprarTerreno(bsAs);
		Assert.assertEquals(saldoInicial, jugador.obtenerSaldo() + precioTerreno);
	}

}
