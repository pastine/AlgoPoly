package modeloTest;

import modelo.Tablero;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.propiedad.PropiedadConDuenioException;
import modelo.propiedad.Servicio;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ServicioTest {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAlCrearServicioLoCreaConElPrecioCorrecto() {
		int precioServicio = 30000;
		Servicio aysa = new Servicio(precioServicio, 300, 500);
		Assert.assertEquals(precioServicio, aysa.obtenerPrecio());
	}

	@Test
	public void testComprarServicioLePertenece() {
		Servicio aysa = new Servicio(30000, 300, 500);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(aysa);
		boolean pertenece = jugador.esDuenioDePropiedad(aysa);
		Assert.assertTrue(pertenece);
	}

	@Test
	public void testComprarServicioNoLePertenece() {
		Servicio aysa = new Servicio(30000, 300, 500);
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDuenioDePropiedad(aysa);
		Assert.assertFalse(pertenece);
	}

	@Test
	public void testAlComprarServicioSeLeDescuentaElPrecioAlSaldoDelJugador() {
		int precioServicio = 30000;
		Servicio aysa = new Servicio(precioServicio, 300, 500);
		Jugador jugador = new Jugador();
		int saldoInicial = jugador.obtenerSaldo();
		jugador.comprarPropiedad(aysa);
		Assert.assertEquals(saldoInicial, jugador.obtenerSaldo() + precioServicio);
	}

	@Test
	public void testAlComprarServicioElNuevoDuenioEsElJugadorQueLoCompro() {
		int precioServicio = 30000;
		Servicio aysa = new Servicio(precioServicio, 300, 500);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(aysa);
		Assert.assertEquals(jugador, aysa.obtenerDuenio());
	}
	@Test
	public void testSiUnJugadorQuiereComprarUnServicioConDuenioLanzaPropiedadConDuenioException() {
		int precioServicio = 30000;
		Servicio aysa = new Servicio(precioServicio, 300, 500);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarPropiedad(aysa);
		thrown.expect(PropiedadConDuenioException.class);
		jugadorB.comprarPropiedad(aysa);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioConDuenioElSaldoDelPrimeroDisminuyeLaCantidadDePasosPorElMultiplicador() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		int capitalInicial = jugadorB.obtenerSaldo();

		Servicio aysa = new Servicio(30000, 300, 500);
		Servicio edesur = new Servicio(35000, 500, 1000);
		aysa.asignarHermano(edesur);


		jugadorA.comprarPropiedad(aysa);
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(aysa);

		casillero1.agregarJugador(jugadorB,0);

		jugadorB.mover(2);

		int capitalFinal = jugadorB.obtenerSaldo();

		Assert.assertEquals(capitalInicial, capitalFinal + 600);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioConDuenioElSaldoDelSegundoAumentaLaCantidadDePasosPorElMultiplicador() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();

		Servicio aysa = new Servicio(30000, 300, 500);
		Servicio edesur = new Servicio(35000, 500, 1000);
		aysa.asignarHermano(edesur);

		jugadorA.comprarPropiedad(aysa);
		int capitalInicial = jugadorA.obtenerSaldo();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(aysa);


		casillero1.agregarJugador(jugadorB,0);

		jugadorB.mover(2);

		int capitalFinal = jugadorA.obtenerSaldo();

		Assert.assertEquals(capitalInicial + 600 , capitalFinal);
	}

	@Test
	public void testSiUnJugadorCaeEnUnServicioDeSuPropiedadElSaldoNoCambia() {
		Jugador jugadorA = new Jugador();

		Servicio aysa = new Servicio(30000, 300, 500);
		jugadorA.comprarPropiedad(aysa);
		int capitalInicial = jugadorA.obtenerSaldo();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(aysa);


		casillero1.agregarJugador(jugadorA,0);

		jugadorA.mover(2);

		int capitalFinal = jugadorA.obtenerSaldo();

		Assert.assertEquals(capitalInicial , capitalFinal);
	}
	
	@Test
	public void TestCaerEnTrenSinTenerSubteTeCobraEnBaseAlDadoTirado(){
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		int costoServicioParcial = 450;
		Servicio tren = new Servicio(38000, costoServicioParcial, 800);
		Servicio subte = new Servicio(40000, 600, 1100);
		tren.asignarHermano(subte);
		Jugador duenio = new Jugador();
		duenio.comprarPropiedad(tren);
		int pasosTotal = jugador.lanzarDados();
		Casillero casillero = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero);

		casillero.agregarJugador(jugador,0);


		for (int i = 1; i < pasosTotal; i++) {
			Casillero auxiliar = new Casillero();
			tablero.agregarCasillero(auxiliar);
		}
		tablero.agregarCasillero(tren);
		jugador.mover(pasosTotal);
		int capitalPosterior = jugador.obtenerSaldo();
		int costoServicio = costoServicioParcial * pasosTotal;
		Assert.assertEquals(capitalAnterior, capitalPosterior + costoServicio);
	}
	
	@Test
	public void TestCaerEnTrenConSubteTeCobraEnBaseAlDadoTirado(){
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		int costoServicioTotal = 800;
		Servicio tren = new Servicio(38000, 450, costoServicioTotal);
		Servicio subte = new Servicio(40000, 600, 1100);
		Jugador duenio = new Jugador();
		duenio.comprarPropiedad(tren);
		duenio.comprarPropiedad(subte);
		tren.asignarHermano(subte);
		int pasosTotal = jugador.lanzarDados();
		Casillero casillero = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero);

		casillero.agregarJugador(jugador,0);
		for (int i = 1; i < pasosTotal; i++) {
			Casillero auxiliar = new Casillero();
			tablero.agregarCasillero(auxiliar);
		}
		tablero.agregarCasillero(tren);
		jugador.mover(pasosTotal);
		int capitalPosterior = jugador.obtenerSaldo();
		int costoServicio = costoServicioTotal * pasosTotal;
		Assert.assertEquals(capitalAnterior, capitalPosterior + costoServicio);
	}
	
	@Test
	public void TestCaerEnEdesurSinTenerAysaTeCobraEnBaseAlDadoTirado(){
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		int costoServicioParcial = 500;
		Servicio edesur = new Servicio(35000, costoServicioParcial, 1000);
		Servicio aysa = new Servicio(30000, 300,500);
		edesur.asignarHermano(aysa);
		Jugador duenio = new Jugador();
		duenio.comprarPropiedad(edesur);
		int pasosTotal = jugador.lanzarDados();
		Casillero casillero = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero);

		casillero.agregarJugador(jugador,0);
		for (int i = 1; i < pasosTotal; i++) {
			Casillero auxiliar = new Casillero();
			tablero.agregarCasillero(auxiliar);
		}
		tablero.agregarCasillero(edesur);
		jugador.mover(pasosTotal);
		int capitalPosterior = jugador.obtenerSaldo();
		int costoServicio = costoServicioParcial * pasosTotal;
		Assert.assertEquals(capitalAnterior, capitalPosterior + costoServicio);
	}
	
	@Test
	public void TestCaerEnEdesurConAysaTeCobraEnBaseAlDadoTirado(){
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		int costoServicioTotal = 1000;
		Servicio edesur = new Servicio(35000, 500, costoServicioTotal);
		Servicio aysa = new Servicio(30000, 300, 500);
		Jugador duenio = new Jugador();
		duenio.comprarPropiedad(edesur);
		duenio.comprarPropiedad(aysa);
		edesur.asignarHermano(aysa);
		int pasosTotal = jugador.lanzarDados();
		Casillero casillero = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero);

		casillero.agregarJugador(jugador,0);
		for (int i = 1; i < pasosTotal; i++) {
			Casillero auxiliar = new Casillero();
			tablero.agregarCasillero(auxiliar);
		}
		tablero.agregarCasillero(edesur);
		jugador.mover(pasosTotal);
		int capitalPosterior = jugador.obtenerSaldo();
		int costoServicio = costoServicioTotal * pasosTotal;
		Assert.assertEquals(capitalAnterior, capitalPosterior + costoServicio);
	}

}
