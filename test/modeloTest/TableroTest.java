package modeloTest;

import modelo.Tablero;
import modelo.casillero.Casillero;
import modelo.casillero.CasilleroNoEncontradoException;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TableroTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAlAgregarDosCasillerosAUnTableroSeIngresanEnElOrdenDeLlegada() {
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();
        Tablero tablero = Tablero.darTablero();
        tablero.limpiarTablero();

        tablero.agregarCasillero(casillero1);
        tablero.agregarCasillero(casillero2);

        Assert.assertEquals(tablero.obtenerSiguiente(casillero1), casillero2);
        Assert.assertEquals(casillero1, tablero.obtenerAnterior(casillero2));
    }

    @Test
    public void testBuscarElSiguienteAUnCasilleroQueNoEstaEnUnTableroLanzaCasilleroNoEncontradoException() {
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();
        Tablero tablero = Tablero.darTablero();
        tablero.limpiarTablero();
        tablero.agregarCasillero(casillero1);

        thrown.expect(CasilleroNoEncontradoException.class);
        tablero.obtenerSiguiente(casillero2);
    }

    @Test
    public void testBuscarElAnteriorAUnCasilleroQueNoEstaEnUnTableroLanzaCasilleroNoEncontradoException() {
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();
        Tablero tablero = Tablero.darTablero();
        tablero.limpiarTablero();
        tablero.agregarCasillero(casillero1);

        thrown.expect(CasilleroNoEncontradoException.class);
        tablero.obtenerAnterior(casillero2);
    }

    @Test
    public void testElCasilleroEsCircular() {
        Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();
        Casillero casillero3 = new Casillero();
        Tablero tablero = Tablero.darTablero();
        tablero.limpiarTablero();
        tablero.agregarCasillero(casillero1);
        tablero.agregarCasillero(casillero2);
        tablero.agregarCasillero(casillero3);

        Assert.assertEquals(casillero1, tablero.obtenerSiguiente(casillero3));
        Assert.assertEquals(tablero.obtenerAnterior(casillero1), casillero3);

    }
    
    @Test
    public void testJugadorTiraDadosYSeEncuentraLaCantidadCorrectaDeCasillerosMasAdelante(){
    	Tablero tablero = Tablero.darTablero();
    	Jugador jugador = new Jugador();
    	
    	Casillero casillero1 = new Casillero();
        Casillero casillero2 = new Casillero();
        Casillero casillero3 = new Casillero();
        Casillero casillero4 = new Casillero();
        Casillero casillero5 = new Casillero();
        Casillero casillero6 = new Casillero();
        
        tablero.limpiarTablero();
        tablero.agregarCasillero(casillero1);
        tablero.agregarCasillero(casillero2);
        tablero.agregarCasillero(casillero3);
        tablero.agregarCasillero(casillero4);
        tablero.agregarCasillero(casillero5);
        tablero.agregarCasillero(casillero6);
        
        casillero1.agregarJugador(jugador,0);
        jugador.mover(4);
        
        Assert.assertFalse(casillero1.jugadorEstaEnCasillero(jugador));
        Assert.assertTrue(casillero5.jugadorEstaEnCasillero(jugador));
        
    }
}
