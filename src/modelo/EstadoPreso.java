package modelo;

public class EstadoPreso implements EstadoDeMovimientoDelJugador{

    @Override
    public void avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        throw new JugadorEstaPresoException();
    }

    @Override
    public void retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        throw new JugadorEstaPresoException();
    }


}
