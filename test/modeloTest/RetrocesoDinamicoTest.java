package modeloTest;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;
import modelo.RetrocesoDinamico;

public class RetrocesoDinamicoTest {

	
	@Test
	public void testJugadorRetrocedeCincoCasillerosObteniendoNumeroSieteYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);

		
		casillero8.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero8,7);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroOchoYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);

		
		casillero8.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero8,8);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero8.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeUnCasillerosObteniendoNumeroNueveYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);

		
		casillero8.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero8,9);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroDiezYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);

		
		casillero8.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero8,10);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero8.jugadorEstaEnCasillero(jugador));

	}
	
	
	
	
	@Test
	public void testJugadorRetrocedeNueveCasillerosObteniendoNumeroOnce(){
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
		Casillero casillero9 = new Casillero();
		Casillero casillero10 = new Casillero();
		Casillero casillero11 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		casillero8.agregarSiguiente(casillero9);
		casillero9.agregarSiguiente(casillero10);
		casillero10.agregarSiguiente(casillero11);
		
		casillero11.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero11,11);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero9.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero10.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero11.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorRetrocedeDiezCasillerosObteniendoNumeroDoce() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
		Casillero casillero9 = new Casillero();
		Casillero casillero10 = new Casillero();
		Casillero casillero11 = new Casillero();
	
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		casillero8.agregarSiguiente(casillero9);
		casillero9.agregarSiguiente(casillero10);
		casillero10.agregarSiguiente(casillero11);
		
		casillero11.agregarJugador(jugador);
		
		retroceso.retroceder(jugador,casillero11,12);
		Assert.assertTrue(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero9.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero10.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero11.jugadorEstaEnCasillero(jugador));
	}
	
	
	
}
