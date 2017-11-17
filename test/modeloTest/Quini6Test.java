package modeloTest;
import modelo.Quini6;
import modelo.jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;


public class Quini6Test {

    @Test
    public void testAlDarPremioAUnJugadorPorPrimeraVezLeAumentaElSaldoEn50000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.obtenerSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_inicial + 50000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorSegundaVezLeAumentaElSaldoEn30000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.darPremio(unJugador);
        int saldo_intermedio = unJugador.obtenerSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_intermedio + 30000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorTerceraVezLeAumentaElSaldoEn0() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.darPremio(unJugador);
        unQuini.darPremio(unJugador);
        int saldo_final = unJugador.obtenerSaldo();
        unQuini.darPremio(unJugador);

        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_final);
    }

    @Test
    public void testAlDarPremioAUnJugador1000VecesLeAumentaElSaldoEn80000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.obtenerSaldo();
        for (int i = 0; i < 1000; i++) {
            unQuini.darPremio(unJugador);
        }
        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_inicial + 80000);
    }

    @Test
    public void testAlRecibirDosPremiosUnJugadorConUnaEntregaEnElMedioAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador JugadorA = new Jugador();
        Jugador JugadorB = new Jugador();

        unQuini.darPremio(JugadorA);
        unQuini.darPremio(JugadorB);
        unQuini.darPremio(JugadorA);

        Assert.assertEquals(JugadorA.obtenerSaldo(), 100000 + 50000 + 30000);
    }

    @Test
    public void testAlRecibirUnPremiosUnJugadorEntreDosEntregasAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador JugadorA = new Jugador();
        Jugador JugadorB = new Jugador();

        unQuini.darPremio(JugadorA);
        unQuini.darPremio(JugadorB);
        unQuini.darPremio(JugadorA);

        Assert.assertEquals(JugadorB.obtenerSaldo(), 100000 + 50000);
    }


}
