package modeloTest;

import modelo.Terreno;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.RetrocesoDinamico;
import modelo.jugador.Jugador;

public class RetrocesoDinamicoTest {

	@Test
	public void testJugadorRetrocedeUnCasilleroObteniendoNumeroDosYConJugadorConUnaPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarTerreno(new Terreno(1));

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
		
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);

		retroceso.mover(jugador, 2);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeDosCasillerosObteniendoNumeroTresYConJugadorConUnaPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarTerreno(new Terreno(1));

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
		
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);

		jugador.ponerEnCasillero(casillero8);

		retroceso.mover(jugador, 3);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeUnCasilleroObteniendoNumeroCuatroYConJugadorConTresPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
		
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);

		retroceso.mover(jugador, 4);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCincoCasillerosObteniendoNumeroCincoYConJugadorConCeroPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();

		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);

		retroceso.mover(jugador, 5);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeDosCasillerosObteniendoNumeroSeisYConJugadorConCuatroPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();

		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);
		
		retroceso.mover(jugador, 6);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroDosYConJugadorConCincoPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));
		jugador.comprarTerreno(new Terreno(1));

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();

		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);

		retroceso.mover(jugador, 2);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero8.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCincoCasillerosObteniendoNumeroSieteYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);
		
		retroceso.mover(jugador, 7);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
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
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);
		
		retroceso.mover(jugador, 8);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
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
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);
		
		retroceso.mover(jugador, 9);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
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
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		
		jugador.ponerEnCasillero(casillero8);
		
		retroceso.mover(jugador, 10);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
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
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		casillero8.agregarSiguiente(casillero9);
		casillero9.agregarSiguiente(casillero10);
		casillero10.agregarSiguiente(casillero11);
		
		jugador.ponerEnCasillero(casillero11);
		
		retroceso.mover(jugador, 11);
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
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
	
		retroceso.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		casillero7.agregarSiguiente(casillero8);
		casillero8.agregarSiguiente(casillero9);
		casillero9.agregarSiguiente(casillero10);
		casillero10.agregarSiguiente(casillero11);
		
		jugador.ponerEnCasillero(casillero11);
		
		retroceso.mover(jugador, 12);
		Assert.assertTrue(retroceso.jugadorEstaEnCasillero(jugador));
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
