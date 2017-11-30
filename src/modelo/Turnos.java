package modelo;

import modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

public class Turnos {
    private final ArrayBlockingQueue<Jugador> turnos;

    public Turnos(ArrayList<Jugador> jugadores){
        turnos = new ArrayBlockingQueue<>(3);
        Collections.shuffle(jugadores);
        turnos.addAll(jugadores);
    }

    public Jugador obtenerJugadorDelTurnoActual(){
        return turnos.peek();
    }

    public void finalizarTurno(){
        turnos.add(turnos.poll());
    }

    // removerJugador elimina el jugador actual del juego
    public Jugador removerJugadorDelJuego(){
        Jugador jugadorEliminado = turnos.poll();
        //Hago que el próximo turno sea del que venía despues del eliminado
        turnos.add(turnos.poll());
        return jugadorEliminado;
    }

    public int cantidadDeJugadoresEnJuego(){
        return turnos.size();
    }

}
