package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;
import modelo.Terreno;

public class JugadorTest {

	@Test
	public void testSumarPlataAUnJugadorLeSumaCorrectamente() {
		Jugador jugador = new Jugador();
		jugador.recibirDinero(500);
		
		Assert.assertEquals(jugador.obtenerSaldo(),100500);
	}
	
	@Test
	public void testElJugadorSeinicializaConSaldo100000() {
		Jugador jugador = new Jugador();
		
		Assert.assertEquals(jugador.obtenerSaldo(), 100000);
	}
	
	@Test
	public void testElSaldoDelJugadorSeReduceCorrectamente() {
		Jugador jugador = new Jugador();
		
		jugador.quitarDinero(50000);
		
		Assert.assertEquals(jugador.obtenerSaldo(),50000);
	}
	
	@Test
	public void testLaCantidadDePropiedadesEnJugadorSinPropiedadesEsCero() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(jugador.obtenerCantidadDePropiedades(),0);
	}
	
	@Test
	public void testLaCantidadDePropiedadesEnJugadorTrasComprarEsUno() {
		Jugador jugador = new Jugador();
		Terreno bsAs = new Terreno(1000);
		jugador.comprarTerreno(bsAs);
		Assert.assertEquals(jugador.obtenerCantidadDePropiedades(),1);
	}
	
	@Test
	public void testAvanzar1PasoElJugadorEstaEnElSiguienteCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		jugador.ponerEnCasillero(casillero1);
		casillero1.agregarJugador(jugador);
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		jugador.avanzar(2);
		
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testAvanzar0PasoElJugadorEstaEnElMismoCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero = new Casillero();
		
		jugador.ponerEnCasillero(casillero);
		casillero.agregarJugador(jugador);
		
		jugador.avanzar(0);
		
		Assert.assertTrue(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testRetroceder2PasosElJugadorEsta2casilleroAtras() {
		Jugador jugador = new Jugador();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		jugador.ponerEnCasillero(casillero3);
		casillero3.agregarJugador(jugador);
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		jugador.retroceder(2);
		
		Assert.assertTrue(casillero1.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testRetroceder0PasosElJugadorEstaEnElMismocasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero = new Casillero();
		
		jugador.ponerEnCasillero(casillero);
		casillero.agregarJugador(jugador);

		jugador.retroceder(0);
		
		Assert.assertTrue(casillero.jugadorEstaEnCasillero(jugador));
	}
}
