package modeloTest;

import modelo.propiedad.ConstruccionNoPermitidaException;
import modelo.propiedad.PropiedadConDuenioException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.propiedad.Terreno;
import modelo.propiedad.TerrenoDoble;
import modelo.jugador.Jugador;
import org.junit.rules.ExpectedException;

public class TerrenoTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAlCrearTerrenoLoCreaConElPrecioCorrecto() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0, 0,0);
		Assert.assertEquals(precioTerreno, bsAs.obtenerPrecio());
	}

	@Test
	public void testComprarTerrenoLePertenece() {
		Terreno bsAs = new Terreno(1000,0, 0,0);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(bsAs);
		boolean pertenece = jugador.esDuenioDePropiedad(bsAs);
		Assert.assertTrue(pertenece);
	}

	@Test
	public void testComprarTerrenoNoLePertenece() {
		Terreno bsAs = new Terreno(1000, 0, 0,0);
		Jugador jugador = new Jugador();
		boolean pertenece = jugador.esDuenioDePropiedad(bsAs);
		Assert.assertFalse(pertenece);
	}

	@Test
	public void testAlComprarTerrenoSeLeDescuentaElPrecioAlSaldoDelJugador() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0, 0,0);
		Jugador jugador = new Jugador();
		int saldoInicial = jugador.obtenerSaldo();
		jugador.comprarPropiedad(bsAs);
		Assert.assertEquals(saldoInicial, jugador.obtenerSaldo() + precioTerreno);
	}

	@Test
	public void testAlComprarTerrenoElNuevoDuenioEsElJugadorQueLoCompro() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno,0, 0,0);
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(bsAs);
		Assert.assertEquals(jugador, bsAs.obtenerDuenio());
	}


	@Test
	public void testSiUnJugadorCaeEnUnTerrenoConDuenioElSaldoDelPrimeroDisminuyeIgualQueElPrecioDelAlquiler() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 1000, 0,0);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		int saldoInicial = jugadorB.obtenerSaldo();

		jugadorA.comprarPropiedad(bsAs);
		bsAs.agregarJugador(jugadorB, 0);

		Assert.assertEquals(jugadorB.obtenerSaldo() + 1000, saldoInicial);
	}

	@Test
	public void testSiUnJugadorCaeEnUnTerrenoConDuenioElSaldoDelSegundoAumentaIgualQueElPrecioDelAlquiler() {
		int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 1000, 0,0);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarPropiedad(bsAs);
		int saldoInicial = jugadorA.obtenerSaldo();
		bsAs.agregarJugador(jugadorB, 0);

		Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicial + 1000);
	}

	@Test
	public void testUnJugadorCuentaConUnTerrenoYConstruyeUnaPropiedadSuDineroSeDecrementaEnElPrecioDeConstruccionDeCasa() {
		int costoConstruccion = 4000;
		Terreno santaFe = new Terreno(15000, 1500, 3500,costoConstruccion);
		Jugador jugadorA = new Jugador();
		jugadorA.comprarPropiedad(santaFe);
		int saldoInicial = jugadorA.obtenerSaldo();
		jugadorA.construirCasa(santaFe);

		Assert.assertEquals(jugadorA.obtenerSaldo() + costoConstruccion, saldoInicial);
	}
	
	@Test
	public void testSiUnJugadorQuiereComprarUnTerrenoConDuenioLanzaPropiedadConDuenioException() {
	int precioTerreno = 20000;
		Terreno bsAs = new Terreno(precioTerreno, 0, 0,0);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.comprarPropiedad(bsAs);
		
		thrown.expect(PropiedadConDuenioException.class);
	 	jugadorB.comprarPropiedad(bsAs);
	}
	
	@Test
	public void testUnJugadorQueCuentaConUnTerrenoSimpleNoPuedeConstruirDosCasas() {
		Terreno santaFe = new Terreno(15000, 1500, 3500,4000);
		Jugador jugadorA = new Jugador();
		jugadorA.comprarPropiedad(santaFe);

		jugadorA.construirCasa(santaFe);
		thrown.expect(ConstruccionNoPermitidaException.class);
		jugadorA.construirCasa(santaFe);
	}

	@Test
	public void testUnJugadorQueNoEsDuenioDeUnaPropiedadSimpleNoPuedeConstruirUnaCasa() {
		Terreno santaFe = new Terreno(15000, 1500, 3500,4000);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorB.comprarPropiedad(santaFe);

		thrown.expect(PropiedadConDuenioException.class);
		jugadorA.construirCasa(santaFe);
	}

	@Test
	public void testUnJugadorQueCaeEnUnaPropiedadConCasaConstruidaSeLeDisminuyeElDineroIgualAlAlquilerConCasaDeLaPropiedad() {
		int alquilerConCasa = 3500;
		Terreno santaFe = new Terreno(15000, 1500, alquilerConCasa,4000);
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorB.comprarPropiedad(santaFe);
		jugadorB.construirCasa(santaFe);
		int saldoInicial = jugadorA.obtenerSaldo();
		santaFe.agregarJugador(jugadorA,0);

		Assert.assertEquals(jugadorA.obtenerSaldo() + alquilerConCasa, saldoInicial);
	}
	
    @Test
    public void testUnJugadorCaeEnSantaFeLoCompraYSuDineroSeReduce15000() {
    	int costoPropiedad = 15000;
    	Terreno santaFe = new Terreno(costoPropiedad, 1500, 3500, 4000);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(santaFe);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnNeuquenLoCompraYSuDineroSeReduce17000() {
    	int costoPropiedad = 17000;
    	Terreno neuquen = new Terreno(costoPropiedad, 1800, 3800, 4800);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(neuquen);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnTucumanLoCompraYSuDineroSeReduce25000() {
    	int costoPropiedad = 25000;
    	Terreno santaFe = new Terreno(costoPropiedad, 2500, 4500, 7000);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(santaFe);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testNoSePuedeConstruirHotelEnTerrenoSimple(){
    	Terreno terreno = new Terreno(1000,250,500,700);
    	Jugador jugador = new Jugador();
    	
    	jugador.comprarPropiedad(terreno);
    	
    	jugador.construirCasa(terreno);
    	
    	thrown.expect(ConstruccionNoPermitidaException.class);
    	jugador.construirCasa(terreno);
    	
    	thrown.expect(ConstruccionNoPermitidaException.class);
    	jugador.construirHotel((TerrenoDoble)terreno);
    }

}
