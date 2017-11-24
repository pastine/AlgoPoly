package modelo;

import modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

public class Turnos {
    private ArrayBlockingQueue<Jugador> turnos;

    public Turnos(ArrayList<Jugador> jugadores){
        turnos = new ArrayBlockingQueue<Jugador>(3);
        Collections.shuffle(jugadores);
        for (Jugador jugador: jugadores) {
            turnos.add(jugador);
        }
    }

    public Jugador obtenerJugadorDelTurnoActual(){
        return turnos.peek();
    }

    public void finalizarTurno(){
        turnos.add(turnos.poll());
    }

    // removerJugador elimina el jugador actual del juego, y cambia el turno al siguiente jugador
    public void removerJugadorDelJuego(){
        turnos.poll();
    }

    public int cantidadDeJugadoresEnJuego(){
        return turnos.size();
    }
}