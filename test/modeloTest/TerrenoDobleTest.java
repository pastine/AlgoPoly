package modeloTest;

import modelo.jugador.Jugador;
import modelo.propiedad.ConstruccionNoPermitidaException;
import modelo.propiedad.PropiedadConDuenioException;
import modelo.propiedad.TerrenoDoble;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TerrenoDobleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testUnJugadorPoseeBuenosAiresNorteYBuenosAiresSurYAlConstruirUnaCasaEnBuenosAiresSurSuSaldoSeDisminuyeEn5000() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);


        int saldoInicial = jugadorA.obtenerSaldo();
        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertEquals(jugadorA.obtenerSaldo() + 5000, saldoInicial);
    }

    @Test
    public void testUnJugadorPoseeBuenosAiresNorteYBuenosAiresSurYAlConstruirUnaCasaEnBuenosAiresNorteSuSaldoSeDisminuyeEn5500() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);


        int saldoInicial = jugadorA.obtenerSaldo();
        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertEquals(jugadorA.obtenerSaldo() + 5500, saldoInicial);
    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresNorteConUnaCasaConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn3500() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());

        jugadorA.construirCasa(buenosAiresNorte);

        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresNorte.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 3500);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 3500, saldoInicialB);

    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurConUnaCasaConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn3000() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());

        jugadorA.construirCasa(buenosAiresSur);

        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresSur.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 3000);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 3000, saldoInicialB);

    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresNorteConDosCasasConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn4000() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);


        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresNorte.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 4000);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 4000, saldoInicialB);

    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurConDosCasasConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn3500() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);


        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresSur.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 3500);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 3500, saldoInicialB);

    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresNorteConHotelConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn6000() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirHotel(buenosAiresNorte);

        Assert.assertFalse(buenosAiresNorte.permiteConstruir());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertTrue(buenosAiresSur.permiteConstruirHotel());


        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresNorte.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 6000);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 6000, saldoInicialB);

    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurConHotelConstruidaYElSaldoDelDuenioAumentaYElDelContrincanteDisminuyeEn5000() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertTrue(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertTrue(buenosAiresSur.permiteConstruirHotel());
        jugadorA.construirHotel(buenosAiresSur);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirHotel());

        int saldoInicialA = jugadorA.obtenerSaldo();
        int saldoInicialB = jugadorB.obtenerSaldo();

        buenosAiresSur.agregarJugador(jugadorB,0);

        Assert.assertEquals(jugadorA.obtenerSaldo(), saldoInicialA + 5000);
        Assert.assertEquals(jugadorB.obtenerSaldo() + 5000, saldoInicialB);

    }

    @Test
    public void testUnJugadorConstruyeTodasLasPropiedadesPosiblesDeBuenosAiresYSeLeDescuentaBienElSaldo() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        int saldoInicial = jugadorA.obtenerSaldo();
        jugadorA.comprarPropiedad(buenosAiresNorte);
        int saldoAVerificar1 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar1, saldoInicial - 25000);

        jugadorA.comprarPropiedad(buenosAiresSur);
        int saldoAVerificar2 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar2, saldoAVerificar1 - 20000);

        jugadorA.construirCasa(buenosAiresNorte);
        int saldoAVerificar3 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar3, saldoAVerificar2 - 5500);

        jugadorA.construirCasa(buenosAiresSur);
        int saldoAVerificar4 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar4, saldoAVerificar3 - 5000);

        jugadorA.construirCasa(buenosAiresNorte);
        int saldoAVerificar5 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar5, saldoAVerificar4 - 5500);

        jugadorA.construirCasa(buenosAiresSur);
        int saldoAVerificar6 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar6, saldoAVerificar5 - 5000);

        jugadorA.construirHotel(buenosAiresNorte);
        int saldoAVerificar7 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar7, saldoAVerificar6 - 9000);

        jugadorA.construirHotel(buenosAiresSur);
        int saldoAVerificar8 = jugadorA.obtenerSaldo();
        Assert.assertEquals(saldoAVerificar8, saldoAVerificar7 - 8000);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirSiSuTerrenoHermanoNoTieneLaMismaCantidadDeConstruccionesConUnaCasa() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        jugadorA.construirCasa(buenosAiresNorte);

        Assert.assertFalse(buenosAiresNorte.permiteConstruir());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirCasa(buenosAiresNorte);
    }

    @Test
    public void testUnJugadorNoPuedeConstruirSiSuTerrenoHermanoNoTieneLaMismaCantidadDeConstruccionesConDosCasas() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        jugadorA.construirCasa(buenosAiresNorte);
        jugadorA.construirCasa(buenosAiresSur);
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertFalse(buenosAiresNorte.permiteConstruir());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirHotel(buenosAiresNorte);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirHotel(buenosAiresSur);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirSiSuTerrenoHermanoNoTieneLaMismaCantidadDeConstruccionesConHotel() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        jugadorA.construirCasa(buenosAiresNorte);
        jugadorA.construirCasa(buenosAiresSur);
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirHotel(buenosAiresSur);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirHotelSiNoTieneDosCasasConstruidas() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        jugadorA.construirCasa(buenosAiresNorte);
        jugadorA.construirCasa(buenosAiresSur);
        jugadorA.construirCasa(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirHotel(buenosAiresNorte);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirHotelSiNoTieneCasasConstruidas() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);
        jugadorA.comprarPropiedad(buenosAiresSur);

        Assert.assertTrue(buenosAiresNorte.permiteConstruir());
        Assert.assertTrue(buenosAiresNorte.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresNorte.permiteConstruirHotel());
        thrown.expect(ConstruccionNoPermitidaException.class);
        jugadorA.construirHotel(buenosAiresNorte);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirCasaSiNoEsDuenioDeLaPropiedad() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        thrown.expect(PropiedadConDuenioException.class);
        jugadorA.construirCasa(buenosAiresSur);

    }

    @Test
    public void testUnJugadorNoPuedeConstruirHotelSiNoEsDuenioDeLaPropiedad() {
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,2500,3500,4000, 6000,5500, 9000);
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);
        Jugador jugadorA = new Jugador();

        jugadorA.comprarPropiedad(buenosAiresNorte);

        Assert.assertFalse(buenosAiresSur.permiteConstruir());
        Assert.assertFalse(buenosAiresSur.permiteConstruirCasa());
        Assert.assertFalse(buenosAiresSur.permiteConstruirHotel());
        thrown.expect(PropiedadConDuenioException.class);
        jugadorA.construirHotel(buenosAiresSur);

    }
    
    @Test
    public void testUnJugadorCaeEnBsAsSurLoCompraYSuDineroSeReduce20000() {
    	int costoPropiedad = 20000;
    	TerrenoDoble buenosAiresSur = new TerrenoDoble(costoPropiedad,2000,3000,3500, 5000,5000, 8000);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(buenosAiresSur);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnBsAsNorteLoCompraYSuDineroSeReduce25000() {
    	int costoPropiedad = 25000;
    	TerrenoDoble buenosAiresNorte = new TerrenoDoble(costoPropiedad, 2500, 3500, 4000, 6000, 5500, 9000);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(buenosAiresNorte);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnCordobaSurLoCompraYSuDineroSeReduce18000() {
    	int costoPropiedad = 18000;
    	TerrenoDoble cordobaSur = new TerrenoDoble(costoPropiedad, 1000, 1500, 2500, 3000, 2000, 3000);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(cordobaSur);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnCordobaNorteLoCompraYSuDineroSeReduce20000() {
    	int costoPropiedad = 20000;
    	TerrenoDoble cordobaNorte = new TerrenoDoble(costoPropiedad, 1300, 1800, 2900, 3500, 2200, 3500);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(cordobaNorte);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnSaltaNorteLoCompraYSuDineroSeReduce23000() {
    	int costoPropiedad = 23000;
    	TerrenoDoble saltaNorte = new TerrenoDoble(costoPropiedad, 2000, 3250, 3850, 5500, 4500, 7500);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(saltaNorte);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorCaeEnSaltaSurLoCompraYSuDineroSeReduce23000() {
    	int costoPropiedad = 23000;
    	TerrenoDoble saltaSur = new TerrenoDoble(costoPropiedad, 2000, 3250, 3850, 5500, 4500, 7500);
    	Jugador jugador = new Jugador();
    	int capitalInicial = jugador.obtenerSaldo();
    	jugador.comprarPropiedad(saltaSur);
    	int capitalFinal = jugador.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + costoPropiedad);
    }
    
    @Test
    public void testUnJugadorQuiereConstruirHotelConSolo1CasaEnCadaPropiedadYSuDineroNoSeReduce() {
    	TerrenoDoble buenosAiresSur = new TerrenoDoble(20000,2000,3000,3500, 5000,5000, 8000);
    	TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000, 2500, 3500, 4000, 6000, 5500, 9000);
    	buenosAiresNorte.asignarHermano(buenosAiresSur);
    	buenosAiresSur.asignarHermano(buenosAiresNorte);
    	Jugador jugador = new Jugador();
    	jugador.comprarPropiedad(buenosAiresSur);
    	jugador.comprarPropiedad(buenosAiresNorte);
    	jugador.construirCasa(buenosAiresSur);
    	jugador.construirCasa(buenosAiresNorte);
    	jugador.construirCasa(buenosAiresNorte);
    	
    	int capitalAntesDeConstruir = jugador.obtenerSaldo();
    	
    	thrown.expect(ConstruccionNoPermitidaException.class);
    	jugador.construirHotel(buenosAiresNorte);
    	
    	int capitalDespuesDeConstruir = jugador.obtenerSaldo();
    	
    	Assert.assertEquals(capitalAntesDeConstruir, capitalDespuesDeConstruir);
    }
    
    @Test
    public void testUnJugadorCaeEnCordobaNorteCon2CasasDeOtroJugadorYSuCapitalSeReduce2900() {
    	int alquilerCon2Casas = 2900;
    	TerrenoDoble cordobaNorte = new TerrenoDoble(20000, 1300, 1800, alquilerCon2Casas, 3500, 2200, 3500);
    	TerrenoDoble cordobaSur = new TerrenoDoble(18000, 1000, 1500, 2500, 3000, 2000, 3000);
    	Jugador duenio = new Jugador();
    	cordobaNorte.asignarHermano(cordobaSur);
    	cordobaSur.asignarHermano(cordobaNorte);
    	duenio.comprarPropiedad(cordobaNorte);
    	duenio.comprarPropiedad(cordobaSur);
    	duenio.construirCasa(cordobaSur);
    	duenio.construirCasa(cordobaNorte);
    	duenio.construirCasa(cordobaSur);
    	duenio.construirCasa(cordobaNorte);
    	Jugador jugadorConMalaSuerte = new Jugador();
    	int capitalInicial = jugadorConMalaSuerte.obtenerSaldo();
    	cordobaNorte.agregarJugador(jugadorConMalaSuerte, 0);
    	int capitalFinal = jugadorConMalaSuerte.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + alquilerCon2Casas);
    }
    
    @Test
    public void testUnJugadorCaeEnSaltaNorteCon2CasasDeOtroJugadorYSuCapitalSeReduce3850() {
    	int alquilerCon2Casas = 3850;
    	TerrenoDoble saltaNorte = new TerrenoDoble(23000, 2000, 3250, alquilerCon2Casas, 5500, 4500, 7500);
    	TerrenoDoble saltaSur = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
    	Jugador duenio = new Jugador();
    	saltaNorte.asignarHermano(saltaSur);
    	saltaSur.asignarHermano(saltaNorte);
    	duenio.comprarPropiedad(saltaNorte);
    	duenio.comprarPropiedad(saltaSur);
    	duenio.construirCasa(saltaSur);
    	duenio.construirCasa(saltaNorte);
    	duenio.construirCasa(saltaSur);
    	duenio.construirCasa(saltaNorte);
    	Jugador jugadorConMalaSuerte = new Jugador();
    	int capitalInicial = jugadorConMalaSuerte.obtenerSaldo();
    	saltaNorte.agregarJugador(jugadorConMalaSuerte, 0);
    	int capitalFinal = jugadorConMalaSuerte.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + alquilerCon2Casas);
    }
    
    @Test
    public void testUnJugadorCaeEnCordobaNorteConHotelDeOtroJugadorYSuCapitalSeReduce3500() {
    	int alquilerConHotel = 3500;
    	TerrenoDoble cordobaNorte = new TerrenoDoble(20000, 1300, 1800, 2900, alquilerConHotel, 2200, 3500);
    	TerrenoDoble cordobaSur = new TerrenoDoble(18000, 1000, 1500, 2500, 3000, 2000, 3000);
    	Jugador duenio = new Jugador();
    	cordobaNorte.asignarHermano(cordobaSur);
    	cordobaSur.asignarHermano(cordobaNorte);
    	duenio.comprarPropiedad(cordobaNorte);
    	duenio.comprarPropiedad(cordobaSur);
    	duenio.construirCasa(cordobaSur);
    	duenio.construirCasa(cordobaNorte);
    	duenio.construirCasa(cordobaSur);
    	duenio.construirCasa(cordobaNorte);
    	duenio.construirHotel(cordobaNorte);
    	Jugador jugadorConMalaSuerte = new Jugador();
    	int capitalInicial = jugadorConMalaSuerte.obtenerSaldo();
    	cordobaNorte.agregarJugador(jugadorConMalaSuerte, 0);
    	int capitalFinal = jugadorConMalaSuerte.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + alquilerConHotel);
    }
    
    @Test
    public void testUnJugadorCaeEnSaltaNorteConHotelDeOtroJugadorYSuCapitalSeReduce() {
    	int alquilerConHotel = 5500;
    	TerrenoDoble saltaNorte = new TerrenoDoble(23000, 2000, 3250, 3850, alquilerConHotel, 4500, 7500);
    	TerrenoDoble saltaSur = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
    	Jugador duenio = new Jugador();
    	saltaNorte.asignarHermano(saltaSur);
    	saltaSur.asignarHermano(saltaNorte);
    	duenio.comprarPropiedad(saltaNorte);
    	duenio.comprarPropiedad(saltaSur);
    	duenio.construirCasa(saltaSur);
    	duenio.construirCasa(saltaNorte);
    	duenio.construirCasa(saltaSur);
    	duenio.construirCasa(saltaNorte);
    	duenio.construirHotel(saltaNorte);
    	Jugador jugadorConMalaSuerte = new Jugador();
    	int capitalInicial = jugadorConMalaSuerte.obtenerSaldo();
    	saltaNorte.agregarJugador(jugadorConMalaSuerte, 0);
    	int capitalFinal = jugadorConMalaSuerte.obtenerSaldo();
    	Assert.assertEquals(capitalInicial, capitalFinal + alquilerConHotel);
    }

    @Test
    public void testAlVenderUnaPropiedadSeRecuperaEl85PorcientoDelValorDeEsaPropiedadYDeLasConstruccionesDelHermano() {
        int alquilerConHotel = 5500;
        TerrenoDoble saltaNorte = new TerrenoDoble(23000, 2000, 3250, 3850, alquilerConHotel, 4500, 7500);
        TerrenoDoble saltaSur = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
        Jugador duenio = new Jugador();
        saltaNorte.asignarHermano(saltaSur);
        saltaSur.asignarHermano(saltaNorte);
        duenio.comprarPropiedad(saltaNorte);
        duenio.comprarPropiedad(saltaSur);
        duenio.construirCasa(saltaSur);
        duenio.construirCasa(saltaNorte);
        duenio.construirCasa(saltaSur);
        duenio.construirCasa(saltaNorte);
        duenio.construirHotel(saltaSur);
        duenio.construirHotel(saltaNorte);

        int capitalInicial = duenio.obtenerSaldo();
        duenio.venderPropiedad(saltaNorte);
        Assert.assertTrue(capitalInicial + (23000 + 4500 * 4 + 7500 * 2) * 0.85 == duenio.obtenerSaldo());
    }
}
