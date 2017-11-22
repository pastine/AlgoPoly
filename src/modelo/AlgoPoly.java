package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;
import modelo.jugador.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

public class AlgoPoly {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private ArrayBlockingQueue<Jugador> turnos;

    public AlgoPoly(){
        jugadores = new ArrayList<Jugador>();
        turnos = new ArrayBlockingQueue<Jugador>(3);
    }

    public void iniciarJuego(){
        crearTableroYJugadores();
        turnos = asignarTurnos(jugadores);
        Jugador jugadorActual = turnos.peek();
        while (turnos.size() > 1) {
            ofrecerOpciones(jugadorActual);
            int numeroPasos1 = jugadorActual.lanzarDados();
            int numeroPasos2 = jugadorActual.lanzarDados();
            while(numeroPasos1 == numeroPasos2){
            	numeroPasos1 = jugadorActual.lanzarDados();
                numeroPasos2 = jugadorActual.lanzarDados();
            }
            int numeroPasos = numeroPasos1 + numeroPasos2;
            try{
                jugadorActual.mover(numeroPasos);
            } catch (SaldoInsuficienteException e){
                turnos.poll();
                continue;
            } catch (JugadorEstaPresoException e) {

            }
            turnos.add(turnos.poll());
            jugadorActual = turnos.peek();
        }
    }

    private void crearTableroYJugadores(){
        tablero = Tablero.inicializar();
        Casillero salida = tablero.obtenerPrimerCasillero();
        for (int i = 0; i < 3; i++) {
            Jugador auxiliar = new Jugador();
            jugadores.add(auxiliar);
            salida.agregarJugador(auxiliar,0);
        }
    }

    private ArrayBlockingQueue<Jugador> asignarTurnos(ArrayList<Jugador> jugadores){
        Collections.shuffle(jugadores);
        ArrayBlockingQueue turnos = new ArrayBlockingQueue<Jugador>(3);
        for (int i = 0; i < 3; i++) {
            turnos.add(jugadores.get(i));
        }
        return turnos;
    }

    private void ofrecerOpciones(Jugador jugadorActual){
        return;
    }

}
