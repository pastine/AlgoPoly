package modeloTest;

import org.junit.Test;
import org.junit.Assert;
import modelo.Carcel;
import modelo.Jugador;
import modelo.Policia;

public class PoliciaTest {
    @Test
    public void jugadorCaeEnPoliciaEsEnviadoACarcel(){
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);
        Jugador jugador = new Jugador();

        policia.jugadorLlega(jugador);

        Assert.assertTrue(carcel.estaEnLaCarcel(jugador));
    }
}
