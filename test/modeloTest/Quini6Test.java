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
    public void testAlDarPremioAUnJugadorPorPrimeraVezLeAumentaElSaldoEn50000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.verSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.verSaldo(), saldo_inicial + 50000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorSegundaVezLeAumentaElSaldoEn30000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.darPremio(unJugador);
        int saldo_intermedio = unJugador.verSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.verSaldo(), saldo_intermedio + 30000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorTerceraVezLeAumentaElSaldoEn0() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.darPremio(unJugador);
        unQuini.darPremio(unJugador);
        int saldo_final = unJugador.verSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.verSaldo(), saldo_final);
    }

    @Test
    public void testAlDarPremioAUnJugador1000VecesLeAumentaElSaldoEn80000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.verSaldo();
        for (int i = 0; i < 1000; i++) {
            unQuini.darPremio(unJugador);
        }
        Assert.assertEquals(unJugador.verSaldo(), saldo_inicial + 80000);
    }

    @Test
    public void testAlRecibirDosPremiosUnJugadorConUnaEntregaEnElMedioAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador JugadorA = new Jugador();
        Jugador JugadorB = new Jugador();

        unQuini.darPremio(JugadorA);
        unQuini.darPremio(JugadorB);
        unQuini.darPremio(JugadorA);

        Assert.assertEquals(JugadorA.verSaldo(), 100000 + 50000 + 30000);
    }

    @Test
    public void testAlRecibirUnPremiosUnJugadorEntreDosEntregasAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador JugadorA = new Jugador();
        Jugador JugadorB = new Jugador();

        unQuini.darPremio(JugadorA);
        unQuini.darPremio(JugadorB);
        unQuini.darPremio(JugadorA);

        Assert.assertEquals(JugadorB.verSaldo(), 100000 + 50000);
    }


}
