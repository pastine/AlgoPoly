package modelo;

public class EstadoLibre implements EstadoDeMovimientoDelJugador {

    @Override
    public void avanzar(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        casilleroActual.quitarJugador(unJugador);
        for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
            casilleroActual = casilleroActual.obtenerSiguiente();
        }
        casilleroActual.agregarJugador(unJugador);
    }

   @Override
    public void retroceder(Jugador unJugador, Casillero casilleroActual, int pasosTotal) {
        casilleroActual.quitarJugador(unJugador);
        for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados++) {
            casilleroActual = casilleroActual.obtenerAnterior();
        }
        casilleroActual.agregarJugador(unJugador);
    }
}
