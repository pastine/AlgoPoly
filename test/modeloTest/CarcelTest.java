package modeloTest;

import modelo.Tablero;
import modelo.casillero.Carcel;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.excepciones.JugadorEstaPresoException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
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
		Assert.assertFalse(jugador.pagarFianza());
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaSiNoEstaPreso() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Assert.assertFalse(jugador.pagarFianza());
		
	}

	@Test
	public void testJugadorNoPuedePagarFianzaEnElSegundoTurnoSiNoTieneSuficienteSaldo() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.quitarDinero(jugador.obtenerSaldo());

		Assert.assertFalse(jugador.pagarFianza());
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

		Assert.assertFalse(jugador.pagarFianza());
		Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);

	}
	
	@Test
	public void testJugadorTiene100DeSalarioYIntentaPagarLaFianzaEnElSegundoTurnoYNoLeDescuentanElDinero() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		jugador.quitarDinero(99900);
		
		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		
		Assert.assertFalse(jugador.pagarFianza());
		Assert.assertEquals(jugador.obtenerSaldo(), 100);
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
		Assert.assertTrue(jugador.pagarFianza());
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElSegundoTurnoYAvanzar(){
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);

		carcel.agregarJugador(jugador, 0);

		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.pagarFianza();
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
		Assert.assertTrue(jugador.pagarFianza());
	}

	@Test
	public void testJugadorPuedePagarFianzaEnElTercerTurnoYAvanzar(){
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		tablero.agregarCasillero(carcel);
		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);

		carcel.agregarJugador(jugador, 0);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		thrown.expect(JugadorEstaPresoException.class);
		jugador.mover(1);
		jugador.pagarFianza();
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
