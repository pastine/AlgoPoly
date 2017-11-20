package modeloTest;



import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.ImpuestoAlLujo;
import modelo.jugador.Jugador;

public class ImpuestoAlLujoTest {

	@Test
	public void testJugadorTieneSaldoDe100000YImpuestoAlLujoLeQuita10000() {
		ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
		Jugador jugador = new Jugador();
		impuesto.agregarJugador(jugador, 0);
		
		Assert.assertEquals(jugador.obtenerSaldo(),90000);
	}
	
	@Test
	public void testJugadorTieneSaldoDe0YImpuestoAlLujoLeQuita0() {
		ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
		Jugador jugador = new Jugador();
		
		jugador.quitarDinero(100000);
		impuesto.agregarJugador(jugador, 0);
		
		Assert.assertEquals(jugador.obtenerSaldo(),0);
	}
	
	@Test
	public void testJugadorTieneSaldoDe500YImpuestoAlLujoLeQuita50() {
		ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
		Jugador jugador = new Jugador();
		
		jugador.quitarDinero(99500);
		impuesto.agregarJugador(jugador, 0);
		
		Assert.assertEquals(jugador.obtenerSaldo(),450);
	}

}
