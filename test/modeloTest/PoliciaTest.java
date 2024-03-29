package modeloTest;

import modelo.casillero.Carcel;
import modelo.casillero.Policia;
import modelo.jugador.Jugador;
import modelo.jugador.excepciones.JugadorEstaPresoException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PoliciaTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void jugadorCaeEnPoliciaEsEnviadoACarcel(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();
        policia.agregarJugador(jugador, 0);
        Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
    }

    @Test
    public void jugadorCaeEnPoliciaYNoPuedeAvanzar(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();

        policia.agregarJugador(jugador, 0);
        thrown.expect(JugadorEstaPresoException.class);
        jugador.mover(1);
    }
}
