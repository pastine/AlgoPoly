package modeloTest;

import modelo.ServicioConDuenioException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import modelo.Casillero;
import modelo.Servicio;
import modelo.jugador.Jugador;
import org.junit.rules.ExpectedException;

public class ServicioTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAlCrearServicioLoCreaConElPrecioCorrecto() {
		int precioServicio = 20000;
		Servicio aysa = new Servicio(precioServicio, 10);
		Assert.assertEquals(precioServicio, aysa.obtenerPrecio());
	}

	@Test
	public void testComprarServicioLePertenece() {
		Servicio aysa = new Servicio(1000, 10);
		Jugador jugador = new Jugador();
		jugador.comprarServicio(aysa);
		boolean pertenece = jugador.esDuenioDeServicio(aysa);
		Assert.assertTrue(pertenece);
	}

	@Test
	public void testComprarServicioNoLePertenece() {
		Servicio aysa = new Servicio(1000, 10);
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDuenioDeServicio(aysa);
		Assert.assertFalse(pertenece);
	}

	@Test
	public void testAlComprarServicioSeLeDescuentaElPrecioAlSaldoDelJugador() {
		int precioServicio = 20000;
		Servicio aysa = new Servicio(precioServicio,0);
		Jugador jugador = new Jugador();
		int saldoInicial = jugador.obtenerSaldo();
		jugador.comprarServicio(aysa);
		Assert.assertEquals(saldoInicial, jugador.obtenerSaldo() + precioServicio);
	}

	@Test
	public void testAlComprarServicioElNuevoDuenioEsElJugadorQueLoCompro() {
		int precioServicio = 20000;
		Servicio aysa = new Servicio(precioServicio,0);
		Jugador jugador = new Jugador();
		jugador.comprarServicio(aysa);
		Assert.assertEquals(jugador, aysa.obtenerDuenio());
	}

	@Test
	public void testSiUnJugadorQuiereComprarUnServicioConDuenioLanzaPropiedadConDuenioException() {
		int precioServicio = 20000;
		Servicio aysa = new Servicio(precioServicio, 0);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarServicio(aysa);

		thrown.expect(ServicioConDuenioException.class);
		jugadorB.comprarServicio(aysa);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioConDuenioElSaldoDelPrimeroDisminuyeLaCantidadDePasosPorElMultiplicador() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		int capitalInicial = jugadorB.obtenerSaldo();

		Servicio aysa = new Servicio(20000, 100);
		jugadorA.comprarServicio(aysa);
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();

		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(aysa);

		jugadorB.ponerEnCasillero(casillero1);

		jugadorB.mover(2);

		int capitalFinal = jugadorB.obtenerSaldo();

		Assert.assertEquals(capitalInicial, capitalFinal + 200);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioConDuenioElSaldoDelSegundoAumentaLaCantidadDePasosPorElMultiplicador() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();

		Servicio aysa = new Servicio(20000, 100);
		jugadorA.comprarServicio(aysa);
		int capitalInicial = jugadorA.obtenerSaldo();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();

		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(aysa);

		jugadorB.ponerEnCasillero(casillero1);

		jugadorB.mover(2);

		int capitalFinal = jugadorA.obtenerSaldo();

		Assert.assertEquals(capitalInicial + 200 , capitalFinal);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioDeSuPropiedadElSaldoNoCambia() {
		Jugador jugadorA = new Jugador();

		Servicio aysa = new Servicio(20000, 100);
		jugadorA.comprarServicio(aysa);
		int capitalInicial = jugadorA.obtenerSaldo();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();

		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(aysa);

		jugadorA.ponerEnCasillero(casillero1);

		jugadorA.mover(2);

		int capitalFinal = jugadorA.obtenerSaldo();

		Assert.assertEquals(capitalInicial , capitalFinal);
	}

}
