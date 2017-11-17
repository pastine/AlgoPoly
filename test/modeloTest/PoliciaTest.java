package modeloTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import modelo.Carcel;
import modelo.Policia;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;

import org.junit.rules.ExpectedException;

public class PoliciaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void jugadorCaeEnPoliciaEsEnviadoACarcel(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();

        policia.apresarJugador(jugador);

        Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
    }

    @Test
    public void jugadorCaeEnPoliciaYNoPuedeAvanzar(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();

        policia.apresarJugador(jugador);

        thrown.expect(JugadorEstaPresoException.class);
        jugador.avanzar(1);
    }

    @Test
    public void jugadorCaeEnPoliciaYNoPuedeRetroceder(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();

        policia.apresarJugador(jugador);

        thrown.expect(JugadorEstaPresoException.class);
        jugador.retroceder(1);
    }
}
