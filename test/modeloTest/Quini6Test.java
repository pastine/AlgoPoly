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

        unQuini.agregarJugador(unJugador, 0);

        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_inicial + 50000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorSegundaVezLeAumentaElSaldoEn30000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.agregarJugador(unJugador, 0);
        int saldo_intermedio = unJugador.obtenerSaldo();
        unQuini.agregarJugador(unJugador, 0);
        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_intermedio + 30000);
    }

    @Test
    public void testAlDarPremioAUnJugadorPorTerceraVezLeAumentaElSaldoEn0() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        unQuini.agregarJugador(unJugador, 0);
        unQuini.agregarJugador(unJugador, 0);
        int saldo_final = unJugador.obtenerSaldo();
        unQuini.agregarJugador(unJugador, 0);
        
        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_final);
    }

    @Test
    public void testAlDarPremioAUnJugador1000VecesLeAumentaElSaldoEn80000() {

        Quini6 unQuini = new Quini6();
        Jugador unJugador = new Jugador();
        int saldo_inicial = unJugador.obtenerSaldo();
        for (int i = 0; i < 1000; i++) {
            unQuini.agregarJugador(unJugador, 0);
        }
        Assert.assertEquals(unJugador.obtenerSaldo(), saldo_inicial + 80000);
    }

    @Test
    public void testAlRecibirDosPremiosUnJugadorConUnaEntregaEnElMedioAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();

        unQuini.agregarJugador(jugadorA, 0);
        unQuini.agregarJugador(jugadorB, 0);
        unQuini.agregarJugador(jugadorA, 0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), 100000 + 50000 + 30000);
    }

    @Test
    public void testAlRecibirUnPremiosUnJugadorEntreDosEntregasAOtroJugadorRecibeBienElPremio() {

        Quini6 unQuini = new Quini6();
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();


        unQuini.agregarJugador(jugadorA, 0);
        unQuini.agregarJugador(jugadorB, 0);
        unQuini.agregarJugador(jugadorA, 0);
        

        Assert.assertEquals(jugadorB.obtenerSaldo(), 100000 + 50000);
    }


}
