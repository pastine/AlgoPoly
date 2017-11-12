package modeloTest;

import org.junit.Assert;
import org.junit.Test;

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
}
