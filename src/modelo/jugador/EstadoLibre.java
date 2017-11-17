package modelo.jugador;

import modelo.Casillero;

public class EstadoLibre implements EstadoDeMovimientoDelJugador {

    @Override
    public EstadoDeMovimientoDelJugador avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        casilleroActual.quitarJugador(unJugador);
        for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
            casilleroActual = casilleroActual.obtenerSiguiente();
        }
        casilleroActual.agregarJugador(unJugador);
        return this;
    }

   @Override
    public EstadoDeMovimientoDelJugador retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        casilleroActual.quitarJugador(unJugador);
        for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
            casilleroActual = casilleroActual.obtenerAnterior();
        }
        casilleroActual.agregarJugador(unJugador);
        return this;
    }
}
