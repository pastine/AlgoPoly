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
		
		Servicio tren = new Servicio(38000, 450);
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
		
		Servicio tren = new Servicio(38000, 450);
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
		
		Servicio tren = new Servicio(38000, 450);
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
	
	@Test
	public void TestCaerEnTrenSinTenerSubteTeCobraEnBaseAlDadoTirado() {
		Jugador jugador = new Jugador();
		int capitalAnterior = jugador.obtenerSaldo();
		
		int costoMultiplicadorServicio = 450;
		
		Servicio tren = new Servicio(38000, costoMultiplicadorServicio);
		int pasosTotal = jugador.lanzarDados();
		
		Casillero casillero = new Casillero();
		jugador.ponerEnCasillero(casillero);
		
		for (int i = 1; i < pasosTotal; i++) {
			casillero.agregarSiguiente(new Casillero());
			casillero = casillero.obtenerSiguiente();
		}
		casillero.agregarSiguiente(tren);
		
		jugador.mover(pasosTotal);
		
		int capitalPosterior = jugador.obtenerSaldo();
		int costoServicio = costoMultiplicadorServicio * pasosTotal;
		Assert.assertEquals(capitalAnterior, capitalPosterior + costoServicio);
	}

}
