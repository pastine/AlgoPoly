package modelo;

public interface EstadoDeMovimientoDelJugador {

    public abstract void avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal);

    public abstract void retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal);

}

