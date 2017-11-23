package modeloTest;

import modelo.Turnos;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TurnosTest {
    @Test
    public void testAlCrearLosTurnosSeAgreganTodosLosJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < 3; i++) {
            Jugador auxiliar = new Jugador();
            jugadores.add(auxiliar);
        }
        Turnos turnos = new Turnos(jugadores);
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(jugadores.contains(turnos.obtenerJugadorDelTurnoActual()));
            turnos.finalizarTurno();
        }
    }

    @Test
    public void testAlRemoverUnJugadorLaCantidadDeJugadoresDeLaClaseTurnosDisminuyeEnUno() {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < 3; i++) {
            Jugador auxiliar = new Jugador();
            jugadores.add(auxiliar);
        }
        Turnos turnos = new Turnos(jugadores);
        int jugadoresInicial = turnos.cantidadDeJugadoresEnJuego();
        turnos.removerJugadorDelJuego();
        Assert.assertEquals(jugadoresInicial, turnos.cantidadDeJugadoresEnJuego() + 1);
    }

    @Test
    public void testLaRondaDeTurnosVuelveAComenzarIndefinidamente() {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < 3; i++) {
            Jugador auxiliar = new Jugador();
            jugadores.add(auxiliar);
        }
        Turnos turnos = new Turnos(jugadores);
        Jugador jugadorInicial = turnos.obtenerJugadorDelTurnoActual();
        for (int i = 0; i < 10000; i++) {
            turnos.finalizarTurno();
            turnos.finalizarTurno();
            turnos.finalizarTurno();
            Assert.assertEquals(jugadorInicial, turnos.obtenerJugadorDelTurnoActual());
        }
    }

}
