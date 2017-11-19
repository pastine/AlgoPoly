package modeloTest;

import modelo.PropiedadConDuenioException;
import modelo.jugador.JugadorEstaPresoException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Terreno;
import modelo.jugador.Jugador;
import org.junit.rules.ExpectedException;

public class TerrenoTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAlCrearTerrenoLoCreaConElPrecioCorrecto() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0);
		Assert.assertEquals(precioTerreno, bsAs.obtenerPrecio());
	}

	@Test
	public void testComprarTerrenoLePertenece() {
		Terreno bsAs = new Terreno(1000,0);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(bsAs);
		boolean pertenece = jugador.esDuenioDePropiedad(bsAs);
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void testComprarTerrenoNoLePertenece() {
		Terreno bsAs = new Terreno(1000, 0);
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDuenioDePropiedad(bsAs);
		Assert.assertFalse(pertenece);
	}

	@Test
	public void testAlComprarTerrenoSeLeDescuentaElPrecioAlSaldoDelJugador() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0);
		Jugador jugador = new Jugador();
		int saldoInicial = jugador.obtenerSaldo();
		jugador.comprarPropiedad(bsAs);
		Assert.assertEquals(saldoInicial, jugador.obtenerSaldo() + precioTerreno);
	}

	@Test
	public void testAlComprarTerrenoElNuevoDuenioEsElJugadorQueLoCompro() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(bsAs);
		Assert.assertEquals(jugador, bsAs.obtenerDuenio());
	}

	@Test
	public void testSiUnJugadorQuiereComprarUnTerrenoConDuenioLanzaPropiedadConDuenioException() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 0);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarPropiedad(bsAs);

		thrown.expect(PropiedadConDuenioException.class);
		jugadorB.comprarPropiedad(bsAs);
	}

	@Test
	public void testSiUnJugadorCaeEnUnTerrenoConDuenioElSaldoDelPrimeroDisminuyeIgualQueElPrecioDelAlquiler() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 1000);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		int saldoInicial = jugadorB.obtenerSaldo();

		jugadorA.comprarPropiedad(bsAs);
		bsAs.agregarJugador(jugadorB, 0);

		Assert.assertEquals(jugadorB.obtenerSaldo() + 1000, saldoInicial);
	}

	@Test
	public void testSiUnJugadorCaeEnUnTerrenoConDuenioElSaldoDelSegundoAumentaIgualQueElPrecioDelAlquiler() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 1000);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarPropiedad(bsAs);
		int saldoInicial = jugadorA.obtenerSaldo();
		bsAs.agregarJugador(jugadorB, 0);

		Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicial + 1000);
	}


}
