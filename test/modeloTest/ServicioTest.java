package modeloTest;

import org.junit.Test;
import org.junit.Assert;

import modelo.Casillero;
import modelo.Servicio;
import modelo.jugador.Jugador;

public class ServicioTest {

	@Test
	public void testCaerEnTrenSinTenerSubteCon2TeCobra900() {
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		
		Servicio tren = new Servicio(38000);
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
				
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(tren);
		
		jugador.ponerEnCasillero(casillero1);
		
		jugador.mover(2);
		
		int capitalPosterior = jugador.obtenerSaldo();
		
		Assert.assertEquals(capitalAnterior, capitalPosterior + 900);
	}

	@Test
	public void testCaerEnTrenSinTenerSubteCon3TeCobra1350() {
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		
		Servicio tren = new Servicio(38000);
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(tren);
		
		jugador.ponerEnCasillero(casillero1);
		
		jugador.mover(3);
		
		int capitalPosterior = jugador.obtenerSaldo();
		
		Assert.assertEquals(capitalAnterior, capitalPosterior + 1350);
	}
	
	@Test
	public void testCaerEnTrenSinTenerSubteCon4TeCobra1800() {
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		
		Servicio tren = new Servicio(38000);
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		
		
		casillero1.agregarSiguiente(casillero2);
		casillero2.agregarSiguiente(casillero3);
		casillero3.agregarSiguiente(casillero4);
		casillero4.agregarSiguiente(tren);
		
		jugador.ponerEnCasillero(casillero1);
		
		jugador.mover(4);
		
		int capitalPosterior = jugador.obtenerSaldo();
		
		Assert.assertEquals(capitalAnterior, capitalPosterior + 1800);
	}

}