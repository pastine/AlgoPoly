package modeloTest;

import modelo.*;
import modelo.jugador.Jugador;
import modelo.jugador.SaldoInsuficienteException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

public class JugadorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
	public void testReducirLaCantidadDeDineroDelJugadorEnMasDeSuSaldoLanzaSaldoInsuficienteException() {
		Jugador jugador = new Jugador();

		thrown.expect(SaldoInsuficienteException.class);
		jugador.quitarDinero(500000);
	}
	
	@Test
	public void testLaCantidadDePropiedadesEnJugadorSinPropiedadesEsCero() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(jugador.obtenerCantidadDePropiedades(),0);
	}
	
	@Test
	public void testLaCantidadDePropiedadesEnJugadorTrasComprarEsUno() {
		Jugador jugador = new Jugador();
		Terreno bsAs = new Terreno(1000, 0);
		jugador.comprarTerreno(bsAs);
		Assert.assertEquals(jugador.obtenerCantidadDePropiedades(),1);
	}
	
	@Test
	public void testAvanzar2PasoElJugadorEstaEnElSiguienteCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		jugador.ponerEnCasillero(casillero1);
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		jugador.mover(2);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testAvanzar0PasoElJugadorEstaEnElMismoCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero = new Casillero();
		
		jugador.ponerEnCasillero(casillero);
		
		jugador.mover(0);
		
		Assert.assertTrue(casillero.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testJuagdorTiraElDado100VecesYSiempreResultaEntre1Y12(){
		Jugador jugador = new Jugador();
		int resultado;
		for (int i=0;i<100;i++){
			resultado = jugador.lanzarDados();
			Assert.assertTrue(resultado<=12 && resultado>=1);
		}
	}
}
