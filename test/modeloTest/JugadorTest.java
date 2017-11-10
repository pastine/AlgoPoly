package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	@Test
	public void sumarPlataAUnJugadorLeSumaCorrectamenteTest() {
		Jugador jugador = new Jugador();
		jugador.recibirDinero(500);
		
		Assert.assertEquals(jugador.verSaldo(),100500);
	}
	
	@Test
	public void elJugadorSeinicializaConSaldo100000Test() {
		Jugador jugador = new Jugador();
		
		Assert.assertEquals(jugador.verSaldo(), 100000);
	}
	
	@Test
	public void elSaldoDelJugadorSeReduceCorrectamenteTest() {
		Jugador jugador = new Jugador();
		
		jugador.quitarDinero(50000);
		
		Assert.assertEquals(jugador.verSaldo(),50000);
	}

}
