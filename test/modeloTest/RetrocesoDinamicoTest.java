package modeloTest;

import modelo.Tablero;
import modelo.propiedad.Terreno;
import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.Casillero;
import modelo.casillero.RetrocesoDinamico;
import modelo.jugador.Jugador;

public class RetrocesoDinamicoTest {

	@Test
	public void testJugadorRetrocedeUnCasilleroObteniendoNumeroDosYConJugadorConUnaPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarPropiedad(new Terreno(1, 0,0,0));
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);

		
		retroceso.agregarJugador(jugador, 2);
		
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeDosCasillerosObteniendoNumeroTresYConJugadorConUnaPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarPropiedad(new Terreno(1, 0,0,0));
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);

		retroceso.agregarJugador(jugador, 3);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeUnCasilleroObteniendoNumeroCuatroYConJugadorConTresPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarPropiedad(new Terreno(1, 0,0,0));
		jugador.comprarPropiedad(new Terreno(1, 0,0,0));
		jugador.comprarPropiedad(new Terreno(1, 0,0,0));

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 4);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCincoCasillerosObteniendoNumeroCincoYConJugadorConCeroPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 5);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeDosCasillerosObteniendoNumeroSeisYConJugadorConCuatroPropiedades() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 6);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroDosYConJugadorConCincoPropiedad() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));
		jugador.comprarPropiedad(new Terreno(1,0,0,0));

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 2);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(retroceso.jugadorEstaEnCasillero(jugador));

	}

	@Test
	public void testJugadorRetrocedeCincoCasillerosObteniendoNumeroSieteYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 7);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroOchoYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 8);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(retroceso.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeUnCasillerosObteniendoNumeroNueveYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 9);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeCeroCasillerosObteniendoNumeroDiezYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 10);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(retroceso.jugadorEstaEnCasillero(jugador));

	}
	
	@Test
	public void testJugadorRetrocedeNueveCasillerosObteniendoNumeroOnce(){
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

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

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(casillero8);
		tablero.agregarCasillero(casillero9);
		tablero.agregarCasillero(casillero10);
		tablero.agregarCasillero(retroceso);

		
		retroceso.agregarJugador(jugador, 11);
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
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorRetrocedeDiezCasillerosObteniendoNumeroDoce() {
		Jugador jugador = new Jugador();
		RetrocesoDinamico retroceso = new RetrocesoDinamico();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

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

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(casillero8);
		tablero.agregarCasillero(casillero9);
		tablero.agregarCasillero(casillero10);
		tablero.agregarCasillero(retroceso);
		
		retroceso.agregarJugador(jugador, 12);
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
		Assert.assertFalse(retroceso.jugadorEstaEnCasillero(jugador));
	}
	
}
