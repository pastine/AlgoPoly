package modeloTest;

import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;
import modelo.propiedad.Servicio;
import org.junit.Assert;
import org.junit.Test;


public class AlgoPolyTest {
    @Test
    public void test() {
        AlgoPoly algoPoly = new AlgoPoly();
        algoPoly.iniciarJuego();
        Assert.assertTrue(true);
    }
    
    @Test
    public void testJugadorVendePropiedadOtroCompraYCuandoOtroPisaSeLeAcreditaAlNuevoDuenio(){
    	Jugador jugador1 = new Jugador();
    	Jugador jugador2 = new Jugador();
    	Jugador jugador3 = new Jugador();
    	
    	int dineroInicial = jugador2.obtenerSaldo();
    	
    	Propiedad propiedad = new Servicio(50, 100, 100);
    	
    	jugador1.comprarPropiedad(propiedad);
    	
    	Assert.assertTrue(jugador1.esDuenioDePropiedad(propiedad));
    	
    	jugador1.venderPropiedad(propiedad);
    	
    	Assert.assertFalse(jugador1.esDuenioDePropiedad(propiedad));
    	
    	jugador2.comprarPropiedad(propiedad);
    	
    	Assert.assertEquals(dineroInicial-50,jugador2.obtenerSaldo());
    	
    	Assert.assertTrue(jugador2.esDuenioDePropiedad(propiedad));
    	
    	propiedad.agregarJugador(jugador3, 1);
    	
    	Assert.assertTrue(propiedad.jugadorEstaEnCasillero(jugador3));
    	
    	//Aca hay algo medio raro, no esta cobrandole a jugador3.
    	
    	Assert.assertEquals(jugador3.obtenerSaldo(),dineroInicial-100);
    	
    	Assert.assertEquals(jugador2.obtenerSaldo(), dineroInicial-50+100);
    	
    }
}
