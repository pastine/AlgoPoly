package modelo.jugador;

import modelo.Casillero;

public interface EstadoDeMovimientoDelJugador {

    public abstract EstadoDeMovimientoDelJugador avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal);

    public abstract EstadoDeMovimientoDelJugador retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal);

}

