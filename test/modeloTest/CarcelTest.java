package modeloTest;

import modelo.Casillero;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Carcel;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;

import org.junit.rules.ExpectedException;

public class CarcelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testApresarJugadorQuedaPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);

		Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
		
	}

	@Test
	public void testJugadorNoPresoNoEstaEnLaCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();

		Assert.assertFalse(carcel.estaEnLaCarcel(jugador));
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaEnElPrimerTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		Assert.assertFalse(jugador.pagarFianza(carcel));
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaSiNoEstaPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Assert.assertFalse(jugador.pagarFianza(carcel));
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaEnElSegundoTurnoSiNoTieneSuficienteSaldo() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.quitarDinero(jugador.obtenerSaldo());

		Assert.assertFalse(jugador.pagarFianza(carcel));
		Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaEnElTercerTurnoSiNoTieneSuficienteSaldo() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.quitarDinero(jugador.obtenerSaldo());

		Assert.assertFalse(jugador.pagarFianza(carcel));
		Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);

	}

	@Test
	public void testJugadorPuedePagarFianzaEnElSegundoTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		Assert.assertTrue(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElSegundoTurnoYAvanzar(){
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();


		carcel.agregarJugador(jugador, 0);

		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);

		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.pagarFianza(carcel);
		jugador.mover(2);
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
	}


	@Test
	public void testJugadorPuedePagarFianzaEnElTercerTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		Assert.assertTrue(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElTercerTurnoYAvanzar(){
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();

		carcel.agregarSiguiente(casillero1);
		casillero2.agregarSiguiente(casillero2);

		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.pagarFianza(carcel);
		jugador.mover(2);
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		
	}

	@Test
	public void testJugadorNoEstaPresoAlCuartoTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		Assert.assertFalse(carcel.estaEnLaCarcel(jugador));
		
	}


	@Test
	public void testJugadorAlEstarPresoNoPuedeAvanzar() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);

		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		
	}

}
