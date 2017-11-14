package modeloTest;

import modelo.JugadorEstaPresoException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Carcel;
import modelo.Jugador;
import org.junit.rules.ExpectedException;

public class CarcelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testApresarJugadorQuedaPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);

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
		carcel.apresarJugador(jugador);
		Assert.assertFalse(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorNoPuedePagarFianzaSiNoEstaPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Assert.assertFalse(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElSegundoTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);
		carcel.restarDiaDeCondena();
		Assert.assertTrue(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElTercerTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);
		carcel.restarDiaDeCondena();
		carcel.restarDiaDeCondena();
		Assert.assertTrue(jugador.pagarFianza(carcel));
	}

	@Test
	public void testJugadorNoEstaPresoAlCuartoTurnoPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);
		carcel.restarDiaDeCondena();
		carcel.restarDiaDeCondena();
		carcel.restarDiaDeCondena();
		Assert.assertFalse(carcel.estaEnLaCarcel(jugador));
	}


	@Test
	public void testJugadorAlEstarPresoNoPuedeAvanzar() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);

		thrown.expect(JugadorEstaPresoException.class);
		jugador.avanzar(1);
	}

	@Test
	public void testJugadorAlEstarPresoNoPuedeRetroceder() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.apresarJugador(jugador);

		thrown.expect(JugadorEstaPresoException.class);
		jugador.retroceder(1);
	}


}
