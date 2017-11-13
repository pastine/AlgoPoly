package modeloTest;


import modelo.Terreno;
import org.junit.Assert;
import org.junit.Test;

import modelo.AvanceDinamico;
import modelo.Casillero;
import modelo.Jugador;



public class AvanceDinamicoTest {

	
	@Test
	public void testJugadorNoAvanzaCasillerosObteniendoNumeroDos(){
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,2);
		Assert.assertTrue(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));

		
	}
	
	
	@Test
	public void testJugadorAvanzaUnCasilleroObteniendoNumeroTres() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,3);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaDosCasillerosObteniendoNumeroCuatro() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,4);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaTresCasillerosObteniendoNumeroCinco() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,5);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
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
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		Casillero casillero5 = new Casillero();
		Casillero casillero6 = new Casillero();
		Casillero casillero7 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(casillero5);
		casillero5.agregarSiguiente(casillero6);
		casillero6.agregarSiguiente(casillero7);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,6);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
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
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,7);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
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
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
				
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,8);
		Assert.assertTrue(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorAvanzaUnCasilleroObteniendoNumeroNueveYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,9);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		
	}
	
	@Test
	public void testJugadorNoAvanzaCasillerosObteniendoConNumeroDiezYConJugadorConSaldo100000() {
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
				
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		
		casillero1.agregarJugador(jugador);
		
		avance.avanzar(jugador,casillero1,10);
		Assert.assertTrue(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		
	}

	@Test
	public void testJugadorAvanzaTresCasillerosObteniendoConNumeroOnceYConJugadorConOchoPropiedades() {
		Jugador jugador = new Jugador();
		int numeroPropiedades = 8;
		for (int i = 0; i < numeroPropiedades; i++) {
			jugador.comprarTerreno(new Terreno(1));
		}

		AvanceDinamico avance = new AvanceDinamico();

		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();


		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);


		casillero1.agregarJugador(jugador);

		avance.avanzar(jugador,casillero1,11);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero4.jugadorEstaEnCasillero(jugador));

	}

    @Test
    public void testJugadorAvanzaSieteCasillerosObteniendoConNumeroDoceYConJugadorConCincoPropiedades() {
        Jugador jugador = new Jugador();
        int numeroPropiedades = 5;
        for (int i = 0; i < numeroPropiedades; i++) {
            jugador.comprarTerreno(new Terreno(1));
        }

        AvanceDinamico avance = new AvanceDinamico();

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


        casillero1.agregarJugador(jugador);

        avance.avanzar(jugador,casillero1,12);
        Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero3.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero5.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero6.jugadorEstaEnCasillero(jugador));
        Assert.assertFalse(casillero7.jugadorEstaEnCasillero(jugador));
        Assert.assertTrue(casillero8.jugadorEstaEnCasillero(jugador));

    }
}
