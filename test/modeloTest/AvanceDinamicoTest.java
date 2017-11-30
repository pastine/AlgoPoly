package modeloTest;

import modelo.Tablero;
import modelo.casillero.AvanceDinamico;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.propiedad.Terreno;
import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	@Test
	public void testJugadorNoAvanzaCasillerosObteniendoNumeroDos(){
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		
		avance.agregarJugador(jugador, 2);
		Assert.assertTrue(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));		
		
	}
	
	@Test
	public void testJugadorAvanzaUnCasilleroObteniendoNumeroTres() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);

		avance.agregarJugador(jugador, 3);
        Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaDosCasillerosObteniendoNumeroCuatro() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);

		avance.agregarJugador(jugador, 4);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaTresCasillerosObteniendoNumeroCinco() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);

		avance.agregarJugador(jugador, 5);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
	
	}
	
	@Test
	public void testJugadorAvanzaCuatroCasillerosObteniendoConNumeroSeis() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);

		avance.agregarJugador(jugador, 6);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		
		
	}
	
	@Test
	public void testJugadorAvanzaCincoCasillerosObteniendoConNumeroSieteYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		Casillero casillero8 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(casillero8);

		avance.agregarJugador(jugador, 7);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero6.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero8.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorNoAvanzaCasillerosObteniendoConNumeroOchoYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);

		avance.agregarJugador(jugador, 8);
		Assert.assertTrue(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaUnCasilleroObteniendoNumeroNueveYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		
		avance.agregarJugador(jugador, 9);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorNoAvanzaCasillerosObteniendoConNumeroDiezYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		
		avance.agregarJugador(jugador, 10);
		Assert.assertTrue(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		
	}

	@Test
	public void testJugadorAvanzaTresCasillerosObteniendoConNumeroOnceYConJugadorConOchoPropiedades() {
		Jugador jugador = new Jugador();
		int numeroPropiedades = 8;
		for (int i = 0; i < numeroPropiedades; i++) {
			jugador.comprarPropiedad(new Terreno(1, 0,0,0));
		}

		AvanceDinamico avance = new AvanceDinamico();

		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);

		avance.agregarJugador(jugador, 11);
		Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero4.jugadorEstaEnCasillero(jugador));

	}

    @Test
    public void testJugadorAvanzaSieteCasillerosObteniendoConNumeroDoceYConJugadorConCincoPropiedades() {
        Jugador jugador = new Jugador();
        int numeroPropiedades = 5;
        for (int i = 0; i < numeroPropiedades; i++) {
            jugador.comprarPropiedad(new Terreno(1, 0,0,0));
        }

        AvanceDinamico avance = new AvanceDinamico();

        Casillero casillero2 = new Casillero();
        Casillero casillero3 = new Casillero();
        Casillero casillero4 = new Casillero();
        Casillero casillero5 = new Casillero();
        Casillero casillero6 = new Casillero();
        Casillero casillero7 = new Casillero();
        Casillero casillero8 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);
		tablero.agregarCasillero(casillero4);
		tablero.agregarCasillero(casillero5);
		tablero.agregarCasillero(casillero6);
		tablero.agregarCasillero(casillero7);
		tablero.agregarCasillero(casillero8);

        avance.agregarJugador(jugador, 12);
        Assert.assertFalse(avance.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
        Assert.assertTrue(casillero8.jugadorEstaEnCasillero(jugador));

    }

    @Test
    public void testJugadorAvanzaCeroCasillerosObteniendoConNumeroDoceYConJugadorConTrecePropiedades() {
        Jugador jugador = new Jugador();
        int numeroPropiedades = 13;
        for (int i = 0; i < numeroPropiedades; i++) {
            jugador.comprarPropiedad(new Terreno(1, 0,0,0));
        }

        AvanceDinamico avance = new AvanceDinamico();

        Casillero casillero2 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		tablero.agregarCasillero(avance);
		tablero.agregarCasillero(casillero2);

        avance.agregarJugador(jugador, 12);
        Assert.assertTrue(avance.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));

    }
    
}
