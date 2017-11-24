package modeloTest;

import modelo.*;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.SaldoInsuficienteException;

import modelo.propiedad.Propiedad;
import modelo.propiedad.Terreno;
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
		Terreno bsAs = new Terreno(1000, 0,0,0);
		jugador.comprarPropiedad(bsAs);
		Assert.assertEquals(jugador.obtenerCantidadDePropiedades(),1);
	}
	
	@Test
	public void testAvanzar2PasoElJugadorEstaEnElSiguienteCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();

		Tablero tablero = Tablero.darTablero();
		tablero.limpiarTablero();

		casillero1.agregarJugador(jugador,0);

		tablero.agregarCasillero(casillero1);
		tablero.agregarCasillero(casillero2);
		tablero.agregarCasillero(casillero3);

		jugador.mover(2);
		Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
		Assert.assertFalse(casillero2.jugadorEstaEnCasillero(jugador));
		Assert.assertTrue(casillero3.jugadorEstaEnCasillero(jugador));
	}
	
	@Test
	public void testAvanzar0PasoElJugadorEstaEnElMismoCasillero() {
		Jugador jugador = new Jugador();
		Casillero casillero = new Casillero();

		casillero.agregarJugador(jugador,0);
		
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
	
	@Test
	public void testJugadoresIntercambianPropiedadesEstasCambianDeDuenioCorrectamente(){
		Propiedad propiedad1 = new Terreno(10,20,0,0);
		Propiedad propiedad2 = new Terreno(50,10,0,0);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.comprarPropiedad(propiedad1);
		jugador2.comprarPropiedad(propiedad2);
		
		jugador1.intercambiarPropiedad(jugador2, propiedad1, propiedad2);
		
		Assert.assertTrue(jugador2.esDuenioDePropiedad(propiedad1));
		Assert.assertTrue(jugador1.esDuenioDePropiedad(propiedad2));
	}
	
	@Test
	public void testJugadoresIntercambianPropiedadesCuandoOtroCaeElAlquilerVaAlJuagadorCorrespondiente(){
		Propiedad propiedad1 = new Terreno(10,20,0,0);
		Propiedad propiedad2 = new Terreno(50,10,0,0);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		
		jugador1.comprarPropiedad(propiedad1);
		jugador2.comprarPropiedad(propiedad2);
		
		int dineroOriginal = jugador2.obtenerSaldo();
		
		jugador1.intercambiarPropiedad(jugador2, propiedad1, propiedad2);
		
		propiedad1.agregarJugador(jugador3, 2);
		
		Assert.assertTrue((dineroOriginal+20)==jugador2.obtenerSaldo());
	}
	
	@Test
	public void testJugadoresIntercambianPropiedadesConConstruccionPeroEstasVuelvenANoTenerNada(){
		Propiedad propiedad1 = new Terreno(10,20,5,0);
		Propiedad propiedad2 = new Terreno(50,10,0,0);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		
		jugador1.comprarPropiedad(propiedad1);
		jugador2.comprarPropiedad(propiedad2);
		
		jugador1.construirCasa((Terreno)propiedad1);
		
		int dineroOriginal = jugador2.obtenerSaldo();
		
		jugador1.intercambiarPropiedad(jugador2, propiedad1, propiedad2);
		
		propiedad1.agregarJugador(jugador3, 2);
		
		Assert.assertTrue((dineroOriginal+20)==jugador2.obtenerSaldo());
	}
}
