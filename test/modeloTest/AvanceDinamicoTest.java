package modeloTest;


import org.junit.Assert;
import org.junit.Test;

import modelo.AvanceDinamico;
import modelo.Casillero;
import modelo.Jugador;



public class AvanceDinamicoTest {

	
	@Test
	public void testDeberiaAvanzarDosCasillerosTirandoDadosConNumeroDos(){
		Jugador jugador = new Jugador();
		AvanceDinamico avance = new AvanceDinamico();
		
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		avance.avanzar(jugador,casillero1,2);
		
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero4.jugadorEstaEnCasillero(jugador));
		
	}
	
	/*
	@Test
	public void testDeberiaAvanzarTresCasillerosTirandoDadosConNumeroTres() {
		AvanceDinamico avance = new AvanceDinamico();
		Assert.assertEquals(avance.avanzar(3), 3);
	}*/
	
}
