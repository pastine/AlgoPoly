package modeloTest;
import modelo.CasilleroNoEncontradoException;
import modelo.jugador.JugadorEstaPresoException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Casillero;
import modelo.Tablero;
import org.junit.rules.ExpectedException;

public class TableroTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
}
