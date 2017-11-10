package modeloTest;
import modelo.Jugador;
import modelo.Quini6;
import org.junit.Assert;
import org.junit.Test;


public class Quini6Test {
    @Test
    public void testAlCrearQuini6NoDevuelveNull() {

        Quini6 unQuini = new Quini6();

        Assert.assertNotNull(unQuini);
    }

    @Test
    public void testAlPagarUnJugadorPorPrimeraVezLeAumentaElSaldoEn50000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.verSaldo();
        unQuini.darPremio(unJugador);


        Assert.assertEquals(unJugador.verSaldo(), saldo_inicial + 50000);
    }
}
    